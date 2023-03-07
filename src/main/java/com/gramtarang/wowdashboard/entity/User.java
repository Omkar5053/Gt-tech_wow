package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String password;
    private String fullName;
    private String branch;
    private String campus;
    private String yearOfPassing;
    private Integer role;
    @JsonIgnore
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date createdDate;
    private String school;
    private String emailId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private ProjectDetails projectDetails;

    public User() {
    }

    public User(Integer userId, String userName, String password, String fullName, String branch, String campus, String yearOfPassing, Integer role, Date createdDate, String school, String emailId, ProjectDetails projectDetails) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.branch = branch;
        this.campus = campus;
        this.yearOfPassing = yearOfPassing;
        this.role = role;
        this.createdDate = createdDate;
        this.school = school;
        this.emailId = emailId;
        this.projectDetails = projectDetails;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(String yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", branch='" + branch + '\'' +
                ", campus='" + campus + '\'' +
                ", yearOfPassing='" + yearOfPassing + '\'' +
                ", role=" + role +
                ", createdDate=" + createdDate +
                ", school='" + school + '\'' +
                ", emailId='" + emailId + '\'' +
                ", projectDetails=" + projectDetails +
                '}';
    }
}
