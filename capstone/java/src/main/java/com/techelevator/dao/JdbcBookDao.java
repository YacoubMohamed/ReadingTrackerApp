package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcBookDao implements BookDao {
    JdbcTemplate jdbcTemplate;


    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book addBook(Book newBook) {
        String sql = "INSERT INTO book (author, title, isbn) VALUES (?,?,?)";

        // this sql statements needs a RETURNING
        // the return gives you back the new book_id that got created

        // we want to use the jdbctemplate to run the above sql

        // we're going to take that book_id and pass it to the getBookId()
        // method which gives you a back a Book object.






        return ;
    }

    @Override
    public Book getTile(String title) {
        return null;
    }

    @Override
    public Book getAuthor(String author) {
        return null;
    }

    @Override
    public Book getIsbn(String isbn) {
        return null;
    }

    @Override
    public Book getBookId(int bookId) {

        // make a sql that returns a row where bookid =

        // save the result of the query into a rowset.

        // from within the row set extract the columns that you need
        // and make a Book object

        // return the book object
        return null;
    }


}
