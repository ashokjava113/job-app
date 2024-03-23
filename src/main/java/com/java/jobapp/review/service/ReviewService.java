package com.java.jobapp.review.service;

import com.java.jobapp.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviewsByCompanyId(long companyId);

    Review createReview(long companyId, Review review);
}
