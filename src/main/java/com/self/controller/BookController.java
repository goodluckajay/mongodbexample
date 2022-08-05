package com.self.controller;

import com.self.model.Book;
import com.self.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/savebook")
    public String saveBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return "Book has been saved.";
    }

    @GetMapping("/findallbooks")
    public List<Book> getAllBooks(){

        return bookRepository.findAll();
    }

    @GetMapping("/findbookbyid/{id}")
    public Book getBook(@PathVariable int id){

       Optional<Book> book =  bookRepository.findById(id);
       return book.get();
    }

    @DeleteMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable int id){

        bookRepository.deleteById(id);
        return "book with ID as " + id + " has deleted.";
    }


}
