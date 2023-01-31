package com.techelevator.dao;

import com.techelevator.model.Book;

public interface BookDao {
    Book addBook (Book newBook);
    Book getTile (String title);
    Book getAuthor (String author);
    Book getIsbn (String isbn);
    Book getBookById (int bookId);
}
