package com.smartjobportal.service;

import com.smartjobportal.dto.ApplicationRequest;
import com.smartjobportal.entity.Job;
import com.smartjobportal.entity.JobApplication;
import com.smartjobportal.entity.User;
import com.smartjobportal.repository.JobApplicationRepository;
import com.smartjobportal.repository.JobRepository;
import com.smartjobportal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationService {

    private final JobApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public ApplicationService(
            JobApplicationRepository applicationRepository,
            UserRepository userRepository,
            JobRepository jobRepository) {

        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    // Apply for a job
    public JobApplication applyForJob(ApplicationRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() ->
                        new RuntimeException("Job not found"));

        JobApplication application = new JobApplication();

        application.setUser(user);
        application.setJob(job);
        application.setStatus("APPLIED");
        application.setAppliedDate(LocalDateTime.now());

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
                        new RuntimeException("Application not found"));
    }

    // Delete application
    public void deleteApplication(Long id) {

        if (!applicationRepository.existsById(id)) {
            throw new RuntimeException("Application not found");
        }

        applicationRepository.deleteById(id);
    }
}