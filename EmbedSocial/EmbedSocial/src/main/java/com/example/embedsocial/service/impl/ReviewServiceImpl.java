package com.example.embedsocial.service.impl;

import com.example.embedsocial.model.Review;
import com.example.embedsocial.repository.ReviewRepository;
import com.example.embedsocial.service.ReviewService;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//In this service i created the sorting and filtering functions
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;


    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    //We filter the list by the minimum rating that is entered by the user
    @Override
    public List<Review> minimumRating(int n) {
        List<Review> review = repository.returnReviews().stream().filter(r->r.getRating() >= n).collect(Collectors.toList());
        return review;
    }

    //Using stream and compareTo we sort the list by the date the review has been created
    @Override
    public List<Review> sortbyDate(List<Review> reviews) {
        List<Review> review = (List<Review>) reviews.stream().sorted((p1, p2)-> p1.getReviewCreatedOnDate().compareTo(p2.getReviewCreatedOnDate())).collect(Collectors.toList());
        return review;
    }

    //Using stream and compareTo we sort the list by whether the review contains text or not
    @Override
    public List<Review> sortByText(List<Review> reviews) {
        List<Review> reviewList = reviews.stream().sorted((o1,o2)-> o1.getReviewFullText().compareTo(o2.getReviewFullText())).collect(Collectors.toList());
        Collections.reverse(reviewList);
        return reviewList;
    }

    //Since I couldn't sort the with using comparedTo with both Collections and streams,
    // I just sorted it by ratings using a simple bubble sort
    @Override
    public List<Review> sortbyRating(List<Review> reviews) {
        List<Review> listReviews = reviews;
        for(int i=0;i<listReviews.size()-1;i++){
            for(int j=0;j<listReviews.size()-i-1;j++){
                if(listReviews.get(j).getRating() > listReviews.get(j+1).getRating()){
                    Review temp = listReviews.get(j);
                    listReviews.set(j, listReviews.get(j+1));
                    listReviews.set(j+1, temp);
                }
            }
        }
        return listReviews;
    }

    @Override
    public List<Review> sort(List<Review> reviews, int text, int rating, int date) {
        if(text == 1 && rating == 1 && date == 1) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating).reversed())
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 1 && rating == 1 && date == 0) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating).reversed())
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        if(text == 1 && rating == 0 && date == 1) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating))
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 1 && rating == 0 && date == 0) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating))
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        if(text == 0 && rating == 0 && date == 1) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating)
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 0 && rating == 0 && date == 0) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating)
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        if(text == 0 && rating == 1 && date == 1) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating).reversed()
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 0 && rating == 1 && date == 0) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating).reversed()
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        return reviews;
    }


}
