package com.java.jobapp.review.service;

import com.java.jobapp.company.model.Company;
import com.java.jobapp.company.service.CompanyService;
import com.java.jobapp.review.model.Review;
import com.java.jobapp.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAllReviewsByCompanyId(long companyId) {
        return reviewRepository.findAllByCompanyId(companyId);
    }

    @Override
    public Review createReview(long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            review.setCompany(company);
            return reviewRepository.save(review);
        }else {
            return null;
        }
    }


}
