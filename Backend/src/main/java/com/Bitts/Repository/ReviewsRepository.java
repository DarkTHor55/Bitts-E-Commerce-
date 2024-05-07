package com.Bitts.Repository;

import com.Bitts.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewsRepository  extends JpaRepository<Review , Long> {
    @Query("SELECT rw FROM Review rw WHERE rw.product.id =:productId ")
    public List<Review> getAllProductsReviews(@Param("productId")Long productId);
}
