package com.Bitts.Controller;

import com.Bitts.Exception.ProductException;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.Rating;
import com.Bitts.Model.Review;
import com.Bitts.Model.User;
import com.Bitts.Request.ReviewRequest;
import com.Bitts.ServiceImpl.ReviewServiceImpl;
import com.Bitts.ServiceImpl.UserServiceaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewService;
    @Autowired
    private UserServiceaImpl userService;
    @PostMapping("/create")
    public ResponseEntity<Object> createReview(@RequestBody ReviewRequest request,@RequestHeader("Authorization")String jwt) throws ProductException, UserException {

        User user = userService.findUserProfileByJwt(jwt);
        Review review =reviewService.createReview(request,user);

        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
    @GetMapping("products/{productId}")
    public ResponseEntity<List<Review>> getProductsReviews(@PathVariable Long productId, @RequestHeader("Authorization")String jwt) throws ProductException, UserException {
        List<Review> reviews = reviewService.getAllProductsReviews(productId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
