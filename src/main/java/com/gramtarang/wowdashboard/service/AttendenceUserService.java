package com.gramtarang.wowdashboard.service;

import com.gramtarang.wowdashboard.entity.AttendenceUser;
import com.gramtarang.wowdashboard.entity.ResponseDto;
import com.gramtarang.wowdashboard.entity.User;
import com.gramtarang.wowdashboard.repository.AttendenceUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AttendenceUserService {
    private AttendenceUserRepository attendenceUserRepository;

    public AttendenceUserService(AttendenceUserRepository attendenceUserRepository) {
        this.attendenceUserRepository = attendenceUserRepository;
    }
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ResponseDto checkCredentials(String username, String password) {
        ResponseDto responseDto = new ResponseDto();
        AttendenceUser user = attendenceUserRepository.getAttendenceUserByUsername(username);
        String encodedPassword = user.getPassword();
        if (!passwordEncoder.matches(password, encodedPassword) || user.getRole().toString() == "STUDENT") {
            responseDto.setStatus("Invalid Credentials");
            return responseDto;
        }
        responseDto.setUserName(username);
        responseDto.setRole(user.getRole().toString());
        responseDto.setStatus("Success");
        return responseDto;
    }

    public AttendenceUser addUser(AttendenceUser attendenceUser) {
        String encodedPassword = passwordEncoder.encode(attendenceUser.getPassword());
        attendenceUser.setPassword(encodedPassword);
        return attendenceUserRepository.save(attendenceUser);
    }
}
