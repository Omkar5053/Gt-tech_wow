package com.gramtarang.wowdashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class UserInfo {
    private String name;
    private String dept;
    private String project;
    private String campus;
    private String username;

}
