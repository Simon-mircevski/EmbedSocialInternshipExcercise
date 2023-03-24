package com.example.embedsocial.service;

import com.example.embedsocial.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> minimumRating(int n);
    List<Review> sortbyDate(List<Review> reviews);
    List<Review> sortByText(List<Review> reviews);
    List<Review> sortbyRating(List<Review> reviews);
}
