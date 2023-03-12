package com.gramtarang.wowdashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class ProjectDto {
    private String projectGuide;
    private Integer noOfStudents;
    private Date startDate;
    private Date endDate;

    private String projectStatus;
    private List<User> studentDetails;

}
