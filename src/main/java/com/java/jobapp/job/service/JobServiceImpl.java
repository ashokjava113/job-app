package com.java.jobapp.job.service;

import com.java.jobapp.job.model.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class JobServiceImpl implements JobService{

    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> getJobs() {
        return jobs;
    }

    @Override
    public String createJob(Job job) {
        jobs.add(job);
        return "Job added successfully.";
    }

    @Override
    public boolean deleteJob(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Job getJob(long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }
}
