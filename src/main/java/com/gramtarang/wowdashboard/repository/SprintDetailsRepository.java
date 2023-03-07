package com.gramtarang.wowdashboard.repository;


import com.gramtarang.wowdashboard.entity.SprintDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SprintDetailsRepository extends JpaRepository<SprintDetails, Integer> {

    @Query(value = "SELECT * FROM sprint_details sd where sd.projectid=:projectid", nativeQuery = true)
    public SprintDetails getSprintDetails(String projectid);

}
