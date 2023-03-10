package com.gramtarang.wowdashboard.controller;

import com.gramtarang.wowdashboard.entity.AttendenceUser;
import com.gramtarang.wowdashboard.entity.ResponseDto;
import com.gramtarang.wowdashboard.service.AttendenceUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendence/")
public class AttendenceLoginController {
    private AttendenceUserService attendenceUserService;

    public AttendenceLoginController(AttendenceUserService attendenceUserService) {
        this.attendenceUserService = attendenceUserService;
    }
    @PostMapping("add")
    public AttendenceUser add(@RequestBody AttendenceUser attendenceUser)
    {
        return attendenceUserService.addUser(attendenceUser);
    }
    @PostMapping("login")
    public ResponseDto checkLogin(@RequestParam(value = "username") String username,
                                  @RequestParam(value = "password") String password){
        return attendenceUserService.checkCredentials(username, password);
    }
}
