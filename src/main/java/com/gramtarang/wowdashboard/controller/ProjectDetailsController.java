package com.gramtarang.wowdashboard.controller;

import com.gramtarang.wowdashboard.entity.ProjectDetails;
import com.gramtarang.wowdashboard.entity.ProjectDto;
import com.gramtarang.wowdashboard.service.ProjectDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project/")
public class ProjectDetailsController {
    private ProjectDetailsService projectService;

    public ProjectDetailsController(ProjectDetailsService projectService) {
        this.projectService = projectService;
    }

    @GetMapping ("list")
    public List<ProjectDetails> allProjects() {
        return projectService.getProjectList();
    }

    @GetMapping("get")
    public ProjectDetails getProject(@RequestParam(value = "projectId") String projectId){
        return  projectService.getProjectById(projectId);
    }
    @GetMapping("projectDetails")
    public List<ProjectDto> getProjectDetails()
    {
        return projectService.getProjectDetails();
    }
}
