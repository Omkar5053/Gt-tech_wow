package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
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

}
