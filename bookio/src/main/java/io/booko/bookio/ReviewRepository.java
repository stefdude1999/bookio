package io.booko.bookio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository<ObjectId> extends MongoRepository<Review, ObjectId> {

}
