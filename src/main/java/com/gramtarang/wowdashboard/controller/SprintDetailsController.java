package com.gramtarang.wowdashboard.controller;

import com.gramtarang.wowdashboard.entity.SprintDetails;
import com.gramtarang.wowdashboard.service.SprintDetailsService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprint/")
public class SprintDetailsController {

    private SprintDetailsService sprintDetailsService;

    public SprintDetailsController(SprintDetailsService sprintDetailsService) {
        this.sprintDetailsService = sprintDetailsService;
    }
    @GetMapping("SprintByProjectId")
    public List<SprintDetails> getSprintDetailsByProjectId(@RequestParam(value = "projectId") String projectId)
    {
        return sprintDetailsService.projectDetails(projectId);
    }

    @PostMapping("addSprintToProject")
    public SprintDetails addSprint(@RequestBody SprintDetails sprintDetails)
    {
        return sprintDetailsService.addSprintToProject(sprintDetails);
    }

}
