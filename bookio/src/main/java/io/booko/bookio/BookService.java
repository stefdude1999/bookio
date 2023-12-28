package io.booko.bookio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRespository bookRespository;
    public List<Book> allBooks() {
        return bookRespository.findAll();
    }

    public Optional<Book> singleBook(String ISBN) {
        return bookRespository.findBookByISBN(ISBN);
    }
}
