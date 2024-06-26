package com.java.jobapp.job.controller;

import com.java.jobapp.job.model.Job;
import com.java.jobapp.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getJobs(){
        List<Job> jobs = jobService.getJobs();
        if(!jobs.isEmpty()) {
            return new ResponseEntity<>(jobs, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> createJob(@RequestBody Job job){
       Job createdJob = jobService.createJob(job);
       return new ResponseEntity<>(createdJob,HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJob(@PathVariable long id){
        Job job = jobService.getJob(id);
        if(job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id){
        boolean isDeleted = jobService.deleteJob(id);
        if(isDeleted){
            return new ResponseEntity<>("Job deleted successfully.",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job updateJob){
        boolean isJobUpdated = jobService.updateJob(id, updateJob);
        if(isJobUpdated){
            return  new ResponseEntity<>("Job updated successfully.",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Job not updated",HttpStatus.NOT_FOUND);
        }
    }
}
