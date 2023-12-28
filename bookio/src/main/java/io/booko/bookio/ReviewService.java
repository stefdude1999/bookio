package io.booko.bookio;

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
    public Review createReview(String reviewBody, String ISBN) {
        Review review = new Review(reviewBody);

        reviewRepository.insert(review);

        mongoTemplate.update(Book.class)
                .matching(Criteria.where("ISBN").is(ISBN))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
