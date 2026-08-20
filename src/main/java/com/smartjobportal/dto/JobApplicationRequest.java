package com.smartjobportal.dto;

public class JobApplicationRequest {

    private Long userId;
    private Long jobId;

    public JobApplicationRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
}