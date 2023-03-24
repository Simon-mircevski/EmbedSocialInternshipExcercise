package com.example.embedsocial.service.impl;

import com.example.embedsocial.model.Review;
import com.example.embedsocial.repository.ReviewRepository;
import com.example.embedsocial.service.ReviewService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//Vo servisot gi kreirav funkciite za sortiranje na reviews
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    //Sortirame spored minimalniot vnesen broj od strana na korisnikot
    @Override
    public List<Review> minimumRating(int n) {
        List<Review> review = repository.returnReviews().stream().filter(r->r.getRating() >= n).collect(Collectors.toList());
        return review;
    }

    //So stream i compareTo sortirame spored datumot koga e kreiran samiot review
    @Override
    public List<Review> sortbyDate(List<Review> reviews) {
        List<Review> review = (List<Review>) reviews.stream().sorted((p1, p2)-> p1.getReviewCreatedOnDate().compareTo(p2.getReviewCreatedOnDate())).collect(Collectors.toList());
        return review;
    }

    //So stream i compareTo sortirame spored uslovot dali postoi vnesen text vo samiot review ili ne
    @Override
    public List<Review> sortByText(List<Review> reviews) {
        List<Review> reviewList = reviews.stream().sorted((o1,o2)-> o1.getReviewFullText().compareTo(o2.getReviewFullText())).collect(Collectors.toList());
        Collections.reverse(reviewList);
        return reviewList;
    }

    //Bidejki i preku stream i preku Collections ne mi dozvoluva compareTo da koristam za da ja sortiram listata,
    //spored Ratings ja sortirav listata koristejki bubble sort
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


}
