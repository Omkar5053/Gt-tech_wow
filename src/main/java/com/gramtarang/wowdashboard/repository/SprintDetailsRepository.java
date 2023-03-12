package com.gramtarang.wowdashboard.repository;


import com.gramtarang.wowdashboard.entity.SprintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SprintDetailsRepository extends JpaRepository<SprintDetails, Integer> {

    @Query(value = "SELECT * FROM sprint_details sd where sd.project_id=:project_id", nativeQuery = true)
    public SprintDetails getSprintDetails(@Param(value = "project_id") String project_id);

}
