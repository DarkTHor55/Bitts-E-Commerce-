package com.Bitts.Service.Review;

import com.Bitts.Exception.ProductException;
import com.Bitts.Model.Review;
import com.Bitts.Model.User;
import com.Bitts.Request.ReviewRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest request, User user)throws ProductException;
    public List<Review> getAllProductsReviews(Long productId)throws ProductException;
}
