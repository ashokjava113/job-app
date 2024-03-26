package com.java.jobapp.review.controller;

import com.java.jobapp.review.model.Review;
import com.java.jobapp.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public ResponseEntity<List<Review>> findAllReviewsByCompanyId(@PathVariable long companyId){
        List<Review> reviews = reviewService.findAllReviewsByCompanyId(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@PathVariable long companyId, @RequestBody Review review){
        Review createdReview = reviewService.createReview(companyId, review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
