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
    public Book addBook(Book newBook) {
        String sql = "INSERT INTO book (author, title, isbn) VALUES (?,?,?) RETURNING book_id";
        Integer newBookId;
        newBookId = jdbcTemplate.queryForObject(sql, Integer.class, newBook.getAuthor(), newBook.getTitle(), newBook.getIsbn());
        return getBookById(newBookId);
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
        String sql = "SELECT * FROM book WHERE book_id = ?; ";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,bookId);
        if (rowSet.next()) {
            book = mapRowToBook (rowSet);
            return book;
        }  else return null;
    }

    @Override
    public List<Book> getBookByUserName(String username) {
        List <Book> books = new ArrayList<>();
        String sql = "SELECT title FROM book JOIN book_users ON book_users.book_id = book.book_id JOIN users ON book_users.user_id = users.user_id WHERE username = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
        while (rowSet.next()) {
            Book book2 = mapRowToBook(rowSet);
            books.add(book2);
        } return books;
    }
    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            books.add(mapRowToBook(rowSet));
        }
        return books;
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
