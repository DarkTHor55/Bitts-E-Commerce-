package com.Bitts.Service.Rating;

import com.Bitts.Exception.ProductException;
import com.Bitts.Exception.RatingAndReviewException;
import com.Bitts.Model.Rating;
import com.Bitts.Model.User;
import com.Bitts.Request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {
    public Rating createRating(RatingRequest request , User user) throws ProductException;
    public List<Rating> getProductsRating(Long productId) throws ProductException;


}
