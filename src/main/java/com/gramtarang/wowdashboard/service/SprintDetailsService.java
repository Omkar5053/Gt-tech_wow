package com.gramtarang.wowdashboard.service;

import com.gramtarang.wowdashboard.entity.SprintDetails;
import com.gramtarang.wowdashboard.entity.User;
import com.gramtarang.wowdashboard.repository.SprintDetailsRepository;
import com.gramtarang.wowdashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SprintDetailsService {

    private SprintDetailsRepository sprintDetailsRepository;
    private UserRepository userRepository;

    public SprintDetailsService(SprintDetailsRepository sprintDetailsRepository, UserRepository userRepository) {
        this.sprintDetailsRepository = sprintDetailsRepository;
        this.userRepository = userRepository;
    }


    public SprintDetails projectDetails(String projectId) {
        return sprintDetailsRepository.getSprintDetails(projectId);
    }

    public SprintDetails addSprintToProject(SprintDetails sprintDetails) {
        sprintDetails.setStartDate(new Date());
        return sprintDetailsRepository.save(sprintDetails);
    }
}
