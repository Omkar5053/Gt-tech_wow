package com.gramtarang.wowdashboard.repository;

import com.gramtarang.wowdashboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user a where a.UserName=:userName AND a.Password =:password", nativeQuery = true)
    public Optional<User> getUserByUserNameAndPassword(String userName, String password);

    public User getUserByUserName(String userName);
    @Query(value = "SELECT * FROM user u where u.project_id=:project_id", nativeQuery = true)
    public List<User> getUsersByProjectId(@Param(value = "project_id") String project_id);

}
