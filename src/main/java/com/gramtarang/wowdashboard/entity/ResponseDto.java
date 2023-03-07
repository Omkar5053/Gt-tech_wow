package com.gramtarang.wowdashboard.entity;

public class ResponseDto {
    public String userName;
    public String role;
    public String status;

    public ResponseDto() {
    }

    public ResponseDto(String userName, String role, String status) {
        this.userName = userName;
        this.role = role;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
