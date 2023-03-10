package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
//@JsonIgnoreProperties({"startDate"})
public class SprintDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sprintId;
    private String studentRegNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date endDate;
    private String projectRemarks;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "project_id")
    private ProjectDetails projectDetails;

    public SprintDetails() {
    }

    public SprintDetails(Integer sprintId, String studentRegNo, Date startDate, Date endDate, String projectRemarks, ProjectDetails projectDetails) {
        this.sprintId = sprintId;
        this.studentRegNo = studentRegNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectRemarks = projectRemarks;
        this.projectDetails = projectDetails;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public void setSprintId(Integer sprintId) {
        this.sprintId = sprintId;
    }

    public String getStudentRegNo() {
        return studentRegNo;
    }

    public void setStudentRegNo(String studentRegNo) {
        this.studentRegNo = studentRegNo;
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

    public String getProjectRemarks() {
        return projectRemarks;
    }

    public void setProjectRemarks(String projectRemarks) {
        this.projectRemarks = projectRemarks;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }

    @Override
    public String toString() {
        return "SprintDetails{" +
                "sprintId=" + sprintId +
                ", studentRegNo='" + studentRegNo + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", ProjectRemarks='" + projectRemarks + '\'' +
                ", projectDetails=" + projectDetails +
                '}';
    }
}
