package com.gramtarang.wowdashboard.entity;

import jakarta.persistence.*;

@Entity
public class AttendenceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(unique = true)
    private String username;
    private String password;
    private String emailId;
    private String mobile;
    private boolean status;

    @Enumerated(EnumType.ORDINAL)
    private ROLES role;

    public AttendenceUser() {
    }

    public AttendenceUser(Integer userId, String username, String password, String emailId, String mobile, boolean status, ROLES role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.emailId = emailId;
        this.mobile = mobile;
        this.status = status;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ROLES getRole() {
        return role;
    }

    public void setRole(ROLES role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AttendenceUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status=" + status +
                ", role=" + role +
                '}';
    }
}
