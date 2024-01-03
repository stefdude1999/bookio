import React, { useEffect, useState } from 'react';
import axios from 'axios';

const BookList = () => {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    const apiUrl = 'http://localhost:8080/api/v1/books';  

    axios.get(apiUrl)
      .then(response => {
        const receivedBooks = response.data;
        setBooks(receivedBooks);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []); 

  return (
    <div>
      <h1>Book List</h1>
      <ul>
        {books.map(book => (
          <li key={book.id.timestamp}>
            <h2>{book.title}</h2>
            <p>Author: {book.author}</p>
            <p>Release Date: {book.releaseDate}</p>
            <img src={book.cover} alt={`${book.title} cover`} style={{ maxWidth: '100px' }} />

            {book.reviewIds.length > 0 && (
              <div>
                <h3>Reviews:</h3>
                <ul>
                  {book.reviewIds.map(reviewId => {
                    const review = JSON.parse(reviewId); 
                    return <li key={review._id.$oid}>{review.body}</li>;
                  })}
                </ul>
              </div>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookList;