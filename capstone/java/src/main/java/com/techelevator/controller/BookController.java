package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private BookDao bookDao;
// add principal

    @RequestMapping (path = "/addBook", method = RequestMethod.POST)
    public void createBook (@RequestBody  Book book) {
       bookDao.addBook(book);
    }

    @RequestMapping(path = "/deleteBook/{isbn}", method = RequestMethod.DELETE)
    public void deleteBook (@PathVariable String isbn) {
        bookDao.deleteBook(isbn);
    }

//    @RequestMapping(path = "/book/list", method = RequestMethod.GET)
//    public List<Book> listAllBooks (Principal principal) throws UsernameNotFoundException {
//        List<Book> allBooks = new ArrayList<>();
//        allBooks = bookDao.getBookByUsername(principal.getName());
//        return allBooks;
//}

    @RequestMapping(path = "/books/list")
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @RequestMapping(path = "/books/list/{username}")
    public List<Book> getBooksByUsername(@PathVariable String username) {
        return bookDao.getBooksByUsername(username);
    }

    // do we need getBooksByUserId? getBooksByFamilyId?

    @RequestMapping(path = "/books/{title}")
    public Book getByTile (@PathVariable String title) {
        Book book = bookDao.getByTile(title);
        return book;
    }

    @RequestMapping(path = "/books/{isbn}")
    public Book getByIsbn (@PathVariable String isbn) {
        Book book = bookDao.getByIsbn(isbn);
        return book;
    }

    @RequestMapping(path = "/books/{bookId}")
    public Book getById (@PathVariable int bookId) {
        Book book = bookDao.getBookById(bookId);
        return book;
    }

    @RequestMapping(path = "/books/{author}")
    public Book getByAuthor (@PathVariable String author) {
        Book book = bookDao.getByAuthor(author);
        return book;
    }






}
