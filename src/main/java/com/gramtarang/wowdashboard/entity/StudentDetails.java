package com.gramtarang.wowdashboard.entity;

public class StudentDetails {
    private String fullName;
    private String regNo;
    private String branch;
    private String school;
    private String campus;

    private ProjectDetails projectDetails;

    public StudentDetails() {
    }


    public StudentDetails(String fullName, String regNo, String branch, String school, String campus, ProjectDetails projectDetails) {
        this.fullName = fullName;
        this.regNo = regNo;
        this.branch = branch;
        this.school = school;
        this.campus = campus;
        this.projectDetails = projectDetails;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }
}
