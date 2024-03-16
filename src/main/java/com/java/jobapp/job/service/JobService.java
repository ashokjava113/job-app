package com.java.jobapp.job.service;

import com.java.jobapp.job.model.Job;

import java.util.List;

public interface JobService {

    public List<Job> getJobs();

    public String createJob(Job job);

    boolean deleteJob(Long id);

    Job getJob(long id);
}
