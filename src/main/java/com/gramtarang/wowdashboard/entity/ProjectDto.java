package com.gramtarang.wowdashboard.entity;

import java.util.Date;
import java.util.List;

public class ProjectDto {
    private String projectGuide;
    private Integer noOfStudents;
    private Date startDate;
    private Date endDate;
    private List<User> studentDetails;

    public ProjectDto() {
    }

    public ProjectDto(String projectGuide, Integer noOfStudents, Date startDate, Date endDate, List<User> studentDetails) {
        this.projectGuide = projectGuide;
        this.noOfStudents = noOfStudents;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentDetails = studentDetails;
    }

    public String getProjectGuide() {
        return projectGuide;
    }

    public void setProjectGuide(String projectGuide) {
        this.projectGuide = projectGuide;
    }

    public Integer getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(Integer noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<User> getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(List<User> studentDetails) {
        this.studentDetails = studentDetails;
    }
}
