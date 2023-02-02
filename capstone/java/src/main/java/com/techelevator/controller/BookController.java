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

    @RequestMapping (path = "/book", method = RequestMethod.POST)
    public void createBook (@RequestBody  Book book) {
       bookDao.addBook(book);
    }
    @RequestMapping(path = "/book/list", method = RequestMethod.GET)
    public List<Book> listAllBooks (Principal principal) throws UsernameNotFoundException {
        List<Book> allBooks = new ArrayList<>();
        allBooks = bookDao.getBookByUserName(principal.getName());
        return allBooks;
} }
