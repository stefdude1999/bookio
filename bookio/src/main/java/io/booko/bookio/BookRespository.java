package io.booko.bookio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRespository extends MongoRepository<Book, ObjectId> {
    Optional<Book> findBookByISBN(String ISBN);
}
