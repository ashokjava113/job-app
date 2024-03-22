package com.java.jobapp.job.model;

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

}
