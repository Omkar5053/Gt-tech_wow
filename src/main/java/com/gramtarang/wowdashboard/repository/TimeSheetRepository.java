package com.gramtarang.wowdashboard.repository;

import com.gramtarang.wowdashboard.entity.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {
    @Query(value = "SELECT * FROM time_sheet ts WHERE ts.user_id = :user_id",nativeQuery = true)
    public List<TimeSheet> getTimeSheetsByUserId(@Param(value = "user_id") Integer user_id);
}
