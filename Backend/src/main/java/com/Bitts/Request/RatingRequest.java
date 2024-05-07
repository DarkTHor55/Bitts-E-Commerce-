package com.Bitts.Request;

public class RatingRequest {
    private Long ProductId;
    private double rating;

    public Long getProductId() {
        return ProductId;
    }

    public RatingRequest() {
    }

    public RatingRequest(Long productId, double rating) {
        ProductId = productId;
        this.rating = rating;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
