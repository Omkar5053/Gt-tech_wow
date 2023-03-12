package com.gramtarang.wowdashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserDto {
    private String userName;
    private String role;
    private String userStatus;
    private String apiStatus;
    private UserInfo userInfo;
}
