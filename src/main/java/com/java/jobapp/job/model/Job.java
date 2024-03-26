package com.java.jobapp.job.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.jobapp.company.model.Company;
import jakarta.persistence.*;


@Entity
//@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String minSalary;
    private String maxSalary;
    private String location;

    @JsonIgnoreProperties("jobs")
    @ManyToOne
    private Company company;

    public Job() {
    }

    public Job(Long id, String title, String minSalary, String maxSalary, String location, Company company) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", minSalary='" + minSalary + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                ", location='" + location + '\'' +
                ", company=" + company +
                '}';
    }
}
