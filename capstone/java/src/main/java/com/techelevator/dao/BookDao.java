package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {
    Book addBook (Book newBook, String username);
    Book getTile (String title);
    Book getAuthor (String author);
    Book getIsbn (String isbn);
    Book getBookById (int bookId);
    List<Book> getBookByUserName (String username);
}
