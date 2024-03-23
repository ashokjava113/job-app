package com.java.jobapp.review.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.jobapp.company.model.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String rating;

    @JsonIgnoreProperties("reviews")
    @ManyToOne
    private Company company;
}
