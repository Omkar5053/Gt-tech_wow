package com.gramtarang.wowdashboard.repository;

import com.gramtarang.wowdashboard.entity.AttendenceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendenceUserRepository extends JpaRepository<AttendenceUser, Integer> {

    public AttendenceUser getAttendenceUserByUsername(String username);
}
