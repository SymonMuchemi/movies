package com.symonmuchemi.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview (String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));


         /* updating the Movie collection by adding a
           new reviewsId to the Movie identified with imbdId
          */
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))// Specifies which movie to update
                .apply(new Update().push("reviewsId").value(review))
                .first();

        return review;
    }
}
