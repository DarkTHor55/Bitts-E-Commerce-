package com.Bitts.ServiceImpl;

import com.Bitts.Exception.ProductException;
import com.Bitts.Model.Product;
import com.Bitts.Model.Rating;
import com.Bitts.Model.User;
import com.Bitts.Repository.RatingRepository;
import com.Bitts.Request.RatingRequest;
import com.Bitts.Service.ProductService.ProductService;
import com.Bitts.Service.Rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProductService productService;


    @Override
    public Rating createRating(RatingRequest request, User user) throws ProductException {
        Product product=productService.findProductById(request.getProductId());
        Rating rating=new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(request.getRating());
        rating.setCreatedAt(LocalDateTime.now());

        return ratingRepository.save(rating);

    }

    @Override
    public List<Rating> getProductsRating(Long productId) throws ProductException {
        return ratingRepository.getAllProductsRating(productId);
    }
}
