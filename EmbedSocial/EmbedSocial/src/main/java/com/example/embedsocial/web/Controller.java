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
@org.springframework.stereotype.Controller
@RequestMapping("/new")
public class Controller {
    private final ReviewService reviewService;
    private final ReviewRepository repository;

    public Controller(ReviewService reviewService, ReviewRepository repository) {
        this.reviewService = reviewService;
        this.repository = repository;
    }

    //Ako e prazna sesijata setirame celosna lista na reviews, ako postoi sesija ja vrakjame filtriranata lista
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
        //Ja vleceme listata od sesija
        List<Review> filteredList = (List<Review>) request.getSession().getAttribute("reviews");
        //Pocnuvame od minimalen Rating za da ja filtrirame listata
        filteredList = reviewService.minimumRating(minimumRating);
        //Vo slucaj ako treba spored najstar rating da sortirame
        if(dateValue == 1){
            filteredList = reviewService.sortbyDate(filteredList);
        }
        //Sortirame Spored najvisok ili najnizok rating
        if(ratingValue == 1){
            filteredList = reviewService.sortbyRating(filteredList);
            Collections.reverse(filteredList);
        }else {
            filteredList = reviewService.sortbyRating(filteredList);
        }
        //Sortirame spored text
        if(textValue == 1){
            filteredList = reviewService.sortByText(filteredList);
        }
        //Stavame novo kreiranata lista vo sesija
        request.getSession().setAttribute("reviews",filteredList);
        return "redirect:/new/api";
    }
}
