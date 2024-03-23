package com.java.jobapp.review.service;

import com.java.jobapp.company.model.Company;
import com.java.jobapp.company.service.CompanyService;
import com.java.jobapp.review.model.Review;
import com.java.jobapp.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

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
