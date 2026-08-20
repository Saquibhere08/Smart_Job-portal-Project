package com.smartjobportal.controller;

import com.smartjobportal.dto.JobApplicationRequest;
import com.smartjobportal.entity.JobApplication;
import com.smartjobportal.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(
            ApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    // Apply for a job
    @PostMapping
    public ResponseEntity<JobApplication> applyForJob(
            @RequestBody JobApplicationRequest request) {

        return ResponseEntity.ok(
                applicationService.applyForJob(request)
        );
    }

    // Get all applications
    @GetMapping
    public ResponseEntity<List<JobApplication>> getAllApplications() {

        return ResponseEntity.ok(
                applicationService.getAllApplications()
        );
    }

    // Get application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getApplicationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                applicationService.getApplicationById(id)
        );
    }

    // Get applications by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<JobApplication>> getApplicationsByUser(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByUser(userId)
        );
    }

    // Get applications by job
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<JobApplication>> getApplicationsByJob(
            @PathVariable Long jobId) {

        return ResponseEntity.ok(
                applicationService.getApplicationsByJob(jobId)
        );
    }

    // Delete application
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(
            @PathVariable Long id) {

        applicationService.deleteApplication(id);

        return ResponseEntity.ok(
                "Application deleted successfully"
        );
    }
}