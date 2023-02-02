package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Book;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private BookDao bookDao;
// add principal

    @RequestMapping (path = "/book", method = RequestMethod.POST)
    public Book createBook (@RequestBody  Book book, String username) {
        return bookDao.addBook(book, username);
    }

}
