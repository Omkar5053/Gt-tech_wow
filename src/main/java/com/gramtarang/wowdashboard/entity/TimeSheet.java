package com.gramtarang.wowdashboard.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer timeSheetId;
    private String task;
    private Date startTime;
    private Date endTime;
    @Enumerated(EnumType.ORDINAL)
    private TimeSheetStatus timeSheetStatus;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "project_id")
    private ProjectDetails projectDetails;
}
