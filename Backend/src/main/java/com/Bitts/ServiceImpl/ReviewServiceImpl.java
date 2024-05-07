package com.Bitts.ServiceImpl;

import com.Bitts.Exception.ProductException;
import com.Bitts.Model.Product;
import com.Bitts.Model.Review;
import com.Bitts.Model.User;
import com.Bitts.Repository.ProductRepository;
import com.Bitts.Repository.ReviewsRepository;
import com.Bitts.Request.ReviewRequest;
import com.Bitts.Service.ProductService.ProductService;
import com.Bitts.Service.Review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewsRepository reviewsRepository;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Review createReview(ReviewRequest request, User user) throws ProductException {
        Product product=productService.findProductById(request.getProductId());
        Review review=new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(request.getReview());
        review.setCreatedAt(LocalDateTime.now());
        return reviewsRepository.save(review);
    }

    @Override
    public List<Review> getAllProductsReviews(Long productId) throws ProductException {
        return reviewsRepository.getAllProductsReviews(productId);
    }
}
