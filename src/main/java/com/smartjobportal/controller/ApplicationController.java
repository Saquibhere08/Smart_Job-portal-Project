package com.smartjobportal.controller;

import com.smartjobportal.dto.ApplicationRequest;
import com.smartjobportal.entity.JobApplication;
import com.smartjobportal.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Apply for a job
    @PostMapping
    public JobApplication applyForJob(
            @RequestBody ApplicationRequest request) {

        return applicationService.applyForJob(request);
    }

    // Get all applications
    @GetMapping
    public List<JobApplication> getAllApplications() {

        return applicationService.getAllApplications();
    }

    // Get application by ID
    @GetMapping("/{id}")
    public JobApplication getApplicationById(
            @PathVariable Long id) {

        return applicationService.getApplicationById(id);
    }

    // Delete application
    @DeleteMapping("/{id}")
    public String deleteApplication(
            @PathVariable Long id) {

        applicationService.deleteApplication(id);

        return "Application deleted successfully";
    }
}