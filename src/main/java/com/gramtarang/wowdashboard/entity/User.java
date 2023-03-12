package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Data
@ToString
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
    @Enumerated(EnumType.ORDINAL)
    private ROLES role;
    private boolean status;
    private String emailId;
    private String mobile;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy hh:mm:ss")
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private ProjectDetails projectDetails;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//    @JsonManagedReference
    private List<TimeSheet> timeSheets;

}
