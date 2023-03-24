package com.example.embedsocial.repository;

import com.example.embedsocial.dataholder.DataHolder;
import com.example.embedsocial.model.Review;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
//Kreirav repository za da moze da se listat site reviews
@Repository
public class ReviewRepository {
    public List<Review> returnReviews() {
        return DataHolder.reviewsList;
    }
}
