package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ProjectDetails {
    @Id
    private String projectId;
    @Column(unique = true)
    private String projectName;
    private String branch;

    private String campus;
    private String projectGuide;
    private String guideContact;
    private String guideEmail;
    private String projectCoordinator;
    private String coordinatorContact;
    private boolean projectStatus;
    private Date startDate;
    private Date endDate;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "projectDetails")
    @JsonManagedReference
    private List<User> users;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "projectDetails")
    @JsonManagedReference
    private List<SprintDetails> sprintDetails;

    public ProjectDetails() {
    }

    public ProjectDetails(String projectId, String projectName, String branch, String projectGuide, String guideContact, String guideEmail, String projectCoordinator, String coordinatorContact, boolean projectStatus, Date startDate,String campus, Date endDate, List<User> users, List<SprintDetails> sprintDetails) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.branch = branch;
        this.projectGuide = projectGuide;
        this.guideContact = guideContact;
        this.guideEmail = guideEmail;
        this.projectCoordinator = projectCoordinator;
        this.coordinatorContact = coordinatorContact;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.users = users;
        this.sprintDetails = sprintDetails;
        this.campus = campus;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getProjectGuide() {
        return projectGuide;
    }

    public void setProjectGuide(String projectGuide) {
        this.projectGuide = projectGuide;
    }

    public String getGuideContact() {
        return guideContact;
    }

    public void setGuideContact(String guideContact) {
        this.guideContact = guideContact;
    }

    public String getGuideEmail() {
        return guideEmail;
    }

    public void setGuideEmail(String guideEmail) {
        this.guideEmail = guideEmail;
    }

    public String getProjectCoordinator() {
        return projectCoordinator;
    }

    public void setProjectCoordinator(String projectCoordinator) {
        this.projectCoordinator = projectCoordinator;
    }

    public String getCoordinatorContact() {
        return coordinatorContact;
    }

    public void setCoordinatorContact(String coordinatorContact) {
        this.coordinatorContact = coordinatorContact;
    }

    public boolean isProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(boolean projectStatus) {
        this.projectStatus = projectStatus;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<SprintDetails> getSprintDetails() {
        return sprintDetails;
    }

    public void setSprintDetails(List<SprintDetails> sprintDetails) {
        this.sprintDetails = sprintDetails;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", branch='" + branch + '\'' +
                ", projectGuide='" + projectGuide + '\'' +
                ", guideContact='" + guideContact + '\'' +
                ", guideEmail='" + guideEmail + '\'' +
                ", projectCoordinator='" + projectCoordinator + '\'' +
                ", coordinatorContact='" + coordinatorContact + '\'' +
                ", projectStatus=" + projectStatus +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", users=" + users +
                ", sprintDetails=" + sprintDetails +
                '}';
    }
}
