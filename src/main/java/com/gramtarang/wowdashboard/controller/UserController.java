package com.gramtarang.wowdashboard.controller;

import com.gramtarang.wowdashboard.entity.StudentDetails;
import com.gramtarang.wowdashboard.entity.User;
import com.gramtarang.wowdashboard.entity.UserDto;
import com.gramtarang.wowdashboard.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public UserDto login(@RequestParam(value = "userName") String userName,
                         @RequestParam(value = "password") String password)
    {
        return userService.checkLogin(userName, password);
    }
    @PostMapping("add")
    public User addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping("studentDetails/{userId}")
    public StudentDetails getStudentDetail(@PathVariable(value = "userId") Integer userId)
    {
        return userService.getDetails(userId);
    }

    @GetMapping("studentDetails")
    public List<StudentDetails> getStudentDetailByProject(@RequestParam(value = "projectId") String projectId)
    {
        return userService.getStudentDetails(projectId);
    }

    @GetMapping("getStudentDetails")
    public List<StudentDetails> getStudents()
    {
        return userService.getall();
    }
}
