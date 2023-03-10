package com.gramtarang.wowdashboard.entity;

public class UserInfo {
    private String name;
    private String dept;
    private String project;
    private String campus;
    private String username;

    public UserInfo() {
    }

    public UserInfo(String name, String dept, String project, String campus, String username) {
        this.name = name;
        this.dept = dept;
        this.project = project;
        this.campus = campus;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", project='" + project + '\'' +
                ", campus='" + campus + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
