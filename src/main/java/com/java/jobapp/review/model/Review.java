package com.java.jobapp.review.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.jobapp.company.model.Company;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
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

    public Review() {
    }

    public Review(long id, String title, String description, String rating, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", company=" + company +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && Objects.equals(title, review.title) && Objects.equals(description, review.description) && Objects.equals(rating, review.rating) && Objects.equals(company, review.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, rating, company);
    }
}
