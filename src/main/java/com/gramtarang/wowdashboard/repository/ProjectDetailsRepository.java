package com.gramtarang.wowdashboard.repository;

import com.gramtarang.wowdashboard.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, String> {

    @Query(value = "SELECT * FROM project_details pd WHERE pd.project_status =:project_status",nativeQuery = true)
    public List<ProjectDetails> getProjectsByStatus(@Param(value = "project_status") Integer project_status);
}
