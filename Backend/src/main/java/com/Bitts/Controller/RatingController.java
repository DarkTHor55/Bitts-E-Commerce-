package com.Bitts.Controller;

import com.Bitts.Exception.ProductException;
import com.Bitts.Exception.UserException;
import com.Bitts.Model.Rating;
import com.Bitts.Model.User;
import com.Bitts.Request.RatingRequest;
import com.Bitts.Service.Rating.RatingService;
import com.Bitts.ServiceImpl.UserServiceaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private UserServiceaImpl userService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody RatingRequest request, @RequestHeader("Authorization")String jwt) throws ProductException, UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Rating rating =ratingService.createRating(request,user);

        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }
    @GetMapping("products/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating(@PathVariable Long productId, @RequestHeader("Authorization")String jwt) throws ProductException, UserException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Rating> ratings =ratingService.getProductsRating(productId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
