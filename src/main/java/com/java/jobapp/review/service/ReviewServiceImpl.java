package com.java.jobapp.review.service;

import com.java.jobapp.company.model.Company;
import com.java.jobapp.company.service.CompanyService;
import com.java.jobapp.review.model.Review;
import com.java.jobapp.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Review getReviewById(long companyId, long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review updateReview(long companyId, long id, Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if(reviewOptional.isPresent()){
            Review review1 = reviewOptional.get();
            review1.setTitle(review.getTitle());
            review1.setDescription(review.getDescription());
            review1.setRating(review.getRating());
            Company company = companyService.getCompanyById(companyId);
            review1.setCompany(company);
            return reviewRepository.save(review1);
        }
        return null;
    }

    @Override
    public boolean deleteReviewById(long id) {
        try{
            reviewRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println("Review Delete Exception: "+e);
        }
        return false;
    }


}
