package com.smartjobportal.service;

import com.smartjobportal.dto.JobApplicationRequest;
import com.smartjobportal.entity.JobApplication;
import com.smartjobportal.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final JobApplicationRepository applicationRepository;

    public ApplicationService(
            JobApplicationRepository applicationRepository) {

        this.applicationRepository = applicationRepository;
    }

    // Apply for a job
    public JobApplication applyForJob(JobApplicationRequest request) {

        JobApplication application = new JobApplication();

        application.setUserId(request.getUserId());
        application.setJobId(request.getJobId());

        application.setStatus("APPLIED");

        return applicationRepository.save(application);
    }

    // Get all applications
    public List<JobApplication> getAllApplications() {

        return applicationRepository.findAll();
    }

    // Get application by ID
    public JobApplication getApplicationById(Long id) {

        return applicationRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Application not found with ID: " + id
                        ));
    }

    // Get applications of a user
    public List<JobApplication> getApplicationsByUser(Long userId) {

        return applicationRepository.findByUserId(userId);
    }

    // Get applications for a job
    public List<JobApplication> getApplicationsByJob(Long jobId) {

        return applicationRepository.findByJobId(jobId);
    }

    // Delete application
    public void deleteApplication(Long id) {

        if (!applicationRepository.existsById(id)) {

            throw new RuntimeException(
                    "Application not found with ID: " + id
            );
        }

        applicationRepository.deleteById(id);
    }
}