package com.gramtarang.wowdashboard.controller;

import com.gramtarang.wowdashboard.entity.StudentDetails;
import com.gramtarang.wowdashboard.entity.User;
import com.gramtarang.wowdashboard.entity.ResponseDto;
import com.gramtarang.wowdashboard.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseDto login(@RequestParam(value = "userName") String userName,
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
}
