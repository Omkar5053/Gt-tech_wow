package com.gramtarang.wowdashboard.service;

import com.gramtarang.wowdashboard.entity.ProjectDetails;
import com.gramtarang.wowdashboard.entity.ProjectDto;
import com.gramtarang.wowdashboard.entity.User;
import com.gramtarang.wowdashboard.repository.ProjectDetailsRepository;
import com.gramtarang.wowdashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectDetailsService {

    private ProjectDetailsRepository projectRepository;
    private UserService userService;
    private UserRepository userRepository;

    // project list
    public ProjectDetailsService(ProjectDetailsRepository projectRepository, UserService userService, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public List<ProjectDetails> getProjectList() {
        return projectRepository.findAll();
    }

    // project by id
    public ProjectDetails getProjectById(String projectId){
        Optional<ProjectDetails> project = projectRepository.findById(projectId);
        if (project.isPresent()){
            return project.get();
        }
        else {
            return null;
        }
    }

    public List<ProjectDto> getProjectDetails() {
        List<ProjectDetails> projectDetails = projectRepository.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        for(ProjectDetails project : projectDetails)
        {
            projectDtos.add(convertToProjectDto(project));
        }
        return projectDtos;
    }

    private ProjectDto convertToProjectDto(ProjectDetails project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectGuide(project.getProjectGuide());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setEndDate(project.getEndDate());
        projectDto.setNoOfStudents(userService.getNoOfStudnetsByProjectId(project.getProjectId()));
        projectDto.setStudentDetails(userRepository.getUsersByProjectId(project.getProjectId()));
        if(project.isProjectStatus())
            projectDto.setProjectStatus("ACTIVE");
        else
            projectDto.setProjectStatus("INACTIVE");
        return projectDto;
    }

    public List<ProjectDto> getProjectStatus(Integer projectStatus) {
        List<ProjectDetails> projectDetails = projectRepository.getProjectsByStatus(projectStatus);
        List<ProjectDto> projectDtos = new ArrayList<>();
        for(ProjectDetails project : projectDetails)
        {
            projectDtos.add(convertToProjectDto(project));
        }
        return projectDtos;
    }
}
