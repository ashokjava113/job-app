package com.java.jobapp.job.service;

import com.java.jobapp.job.model.Job;
import com.java.jobapp.job.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

//    private List<Job> jobs = new ArrayList<>();

    private final JobRepository jobRepository;

    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job getJob(long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(long id, Job updatejob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updatejob.getTitle());
            job.setMinSalary(updatejob.getMinSalary());
            job.setMaxSalary(updatejob.getMaxSalary());
            job.setLocation(updatejob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
