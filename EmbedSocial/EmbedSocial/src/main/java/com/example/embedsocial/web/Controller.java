package com.example.embedsocial.web;


import com.example.embedsocial.model.Review;
import com.example.embedsocial.repository.ReviewRepository;
import com.example.embedsocial.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Controller
@RequestMapping("/new")
public class Controller {
    private final ReviewService reviewService;
    private final ReviewRepository repository;

    public Controller(ReviewService reviewService, ReviewRepository repository) {
        this.reviewService = reviewService;
        this.repository = repository;
    }

    //If the session is empty we put the list of reviews in the session, otherwise we return the filtered list
    @GetMapping("/api")
    public String getReviews(HttpServletRequest req,Model model){
        if(req.getSession().getAttribute("reviews") == null){
            List<Review> reviews = repository.returnReviews();
            req.getSession().setAttribute("reviews", reviews);
        }

        return "home";
    }


    @PostMapping("/filter")
    public String filterReviews(@RequestParam int ratingValue,
                                @RequestParam int minimumRating,
                                @RequestParam int dateValue,
                                @RequestParam int textValue,
                                HttpServletRequest request){
        //We take the list from the session
        List<Review> filteredList = (List<Review>) request.getSession().getAttribute("reviews");
        //We filter it first by the minimum review rating
        filteredList = reviewService.minimumRating(minimumRating);

        filteredList = reviewService.sort(filteredList, textValue,ratingValue,dateValue);
        request.getSession().setAttribute("reviews",filteredList);
        return "redirect:/new/api";
    }
}
