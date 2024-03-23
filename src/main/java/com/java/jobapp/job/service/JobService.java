package com.java.jobapp.job.service;

import com.java.jobapp.job.model.Job;

import java.util.List;

public interface JobService {

    public List<Job> getJobs();

    public Job createJob(Job job);

    boolean deleteJob(Long id);

    Job getJob(long id);

    boolean updateJob(long id, Job updateJob);
}
