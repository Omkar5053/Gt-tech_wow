package com.gramtarang.wowdashboard.service;

import com.gramtarang.wowdashboard.entity.StudentDetails;
import com.gramtarang.wowdashboard.entity.User;
import com.gramtarang.wowdashboard.entity.ResponseDto;
import com.gramtarang.wowdashboard.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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


    public ResponseDto checkLogin(String userName, String password) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.getUserByUserName(userName);
        String encodedPassword = user.getPassword();
        if (!passwordEncoder.matches(password, encodedPassword)) {
            responseDto.setStatus("Failed to Login");
            return responseDto;
        }
        responseDto.setUserName(userName);
        if (user.getRole() != 0)
            responseDto.setRole("Student");
        else
            responseDto.setRole("Admin");
        responseDto.setStatus("Success");
        return responseDto;
    }

    public User addUser(User user) {

        user.setCreatedDate(new Date());
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
        studentDetails.setSchool(user.get().getSchool());
        studentDetails.setProjectDetails(user.get().getProjectDetails());
        return studentDetails;
    }

    public int getNoOfStudnetsByProjectId(String projectId)
    {
        List<User> users = userRepository.getUsersByProjectId(projectId);
        return users.size();
    }
}
