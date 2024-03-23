package com.java.jobapp.job.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.jobapp.company.model.Company;
import jakarta.persistence.*;
import lombok.*;


@Entity
//@Table(name = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
