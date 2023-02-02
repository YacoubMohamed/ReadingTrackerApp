package com.techelevator.dao;

import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBookDao implements BookDao {
    JdbcTemplate jdbcTemplate;


    public JdbcBookDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book addBook(Book newBook, String username) {
        String userIdSql = "SELECT username FROM users WHERE username = ?;";
        int userId = jdbcTemplate.queryForObject(userIdSql, Integer.class, username);


        String sql = "INSERT INTO book (author, title, isbn, user_id) VALUES (?,?,?,?) RETURNING book_id";
        Integer newBookId;
        newBookId = jdbcTemplate.queryForObject(sql, Integer.class, newBook.getAuthor(), newBook.getTitle(), newBook.getIsbn(), userId);
        return getBookById(newBookId);

        // this sql statements needs a RETURNING
        // the return gives you back the new book_id that got created

        // we want to use the jdbctemplate to run the above sql

        // we're going to take that book_id and pass it to the getBookId()
        // method which gives you a back a Book object.

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
    public Book getBookById(int bookId) {
        Book book;

        // make a sql that returns a row where bookid =
        String sql = "SELECT * FROM book WHERE book_id = ?; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,bookId);
        if (rowSet.next()) {
            book = mapRowToBook (rowSet);
            return book;
        }  else return null;

        // save the result of the query into a rowset.

        // from within the row set extract the columns that you need
        // and make a Book object

        // return the book object

    }

    @Override
    public List<Book> getBookByUserName(String username) {
        List <Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book JOIN users ON book.user_id = user.user_id WHERE user_name = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
        while (rowSet.next()) {
            Book book2 = mapRowToBook(rowSet);
            books.add(book2);
        } return books;
    }

    private Book mapRowToBook (SqlRowSet rs) {
        Book book = new Book();
        book.setBookId(rs.getInt("book_Id"));
        book.setAuthor(rs.getString("author"));
        book.setTitle(rs.getString("title"));
        book.setIsbn(rs.getString("isbn"));
        return book;
    }

}
