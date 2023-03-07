package com.gramtarang.wowdashboard.service;

import com.gramtarang.wowdashboard.entity.SprintDetails;
import com.gramtarang.wowdashboard.repository.SprintDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class SprintDetailsService {

    private SprintDetailsRepository sprintDetailsRepository;

    public SprintDetailsService(SprintDetailsRepository sprintDetailsRepository) {
        this.sprintDetailsRepository = sprintDetailsRepository;
    }


    public SprintDetails projectDetails(String projectId) {
        return sprintDetailsRepository.getSprintDetails(projectId);
    }

    public SprintDetails addSprintToProject(SprintDetails sprintDetails) {
        return sprintDetailsRepository.save(sprintDetails);
    }
}
