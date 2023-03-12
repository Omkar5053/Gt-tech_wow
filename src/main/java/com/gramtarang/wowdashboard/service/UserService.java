package com.gramtarang.wowdashboard.service;

import com.gramtarang.wowdashboard.entity.*;
import com.gramtarang.wowdashboard.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto checkLogin(String userName, String password) {

        UserDto userDto = new UserDto();
        UserInfo userInfo = new UserInfo();
        User user = userRepository.getUserByUserName(userName);
        String encodedPassword = user.getPassword();
        if (!passwordEncoder.matches(password, encodedPassword)) {
            userDto.setApiStatus("Failed");
            return userDto;
        }
        userDto.setUserName(userName);
        userDto.setRole(user.getRole().toString());
        userDto.setApiStatus("SUCCESS");
        if(user.isStatus())
            userDto.setUserStatus("ACTIVE");
        else
            userDto.setUserStatus("INACTIVE");
        userInfo.setName(user.getFullName());
        userInfo.setDept(user.getBranch());
        userInfo.setProject(user.getProjectDetails().getProjectName());
        userInfo.setCampus(user.getCampus());
        userDto.setUserInfo(userInfo);
        return userDto;
    }

    public User addUser(User user) {

        user.setCreatedDate(new Date());
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public StudentDetails getDetails(Integer userId) {
        StudentDetails studentDetails = new StudentDetails();
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            return null;
        }
        studentDetails.setBranch(user.get().getBranch());
        studentDetails.setCampus(user.get().getCampus());
        studentDetails.setFullName(user.get().getFullName());
        studentDetails.setProjectDetails(user.get().getProjectDetails());
        studentDetails.setRegNo(user.get().getUserName());
        return studentDetails;
    }

    public int getNoOfStudnetsByProjectId(String projectId)
    {
        List<User> users = userRepository.getUsersByProjectId(projectId);
        return users.size();
    }

    public List<StudentDetails> getStudentDetails(String projectId) {
        List<User> users = userRepository.getUsersByProjectId(projectId);
        List<StudentDetails> studentDetails = new ArrayList<>();
        for(User user : users)
        {
            studentDetails.add(convertToStudentDetail(user));
        }
      return studentDetails;
    }

    private StudentDetails convertToStudentDetail(User user) {
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setBranch(user.getBranch());
        studentDetails.setCampus(user.getCampus());
        studentDetails.setFullName(user.getFullName());
        studentDetails.setProjectDetails(user.getProjectDetails());
        studentDetails.setRegNo(user.getUserName());
        return studentDetails;
    }

    public List<StudentDetails> getall() {
        List<StudentDetails> studentDetails = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user : users)
        {
            studentDetails.add(convertToStudentDetail(user));
        }
        return studentDetails;
    }
}
