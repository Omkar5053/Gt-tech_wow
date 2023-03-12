package com.gramtarang.wowdashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class StudentDetails {
    private String fullName;
    private String regNo;
    private String branch;
    private String school;
    private String campus;

    private ProjectDetails projectDetails;

}
