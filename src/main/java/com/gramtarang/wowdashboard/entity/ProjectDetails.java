package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
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
    private boolean projectStatus;
    private Date startDate;
    private Date endDate;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "projectDetails")
//    @JsonManagedReference
    private List<User> users;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "projectDetails")
//    @JsonManagedReference
    private List<SprintDetails> sprintDetails;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "projectDetails")
//    @JsonManagedReference
    private List<TimeSheet> timeSheets;


}
