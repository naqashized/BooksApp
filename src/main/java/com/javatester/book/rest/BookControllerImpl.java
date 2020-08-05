package com.javatester.book.rest;

import com.javatester.book.dao.BookService;
import com.javatester.book.pojo2.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookControllerImpl implements BookController{
    @Autowired
    private BookService bookService;

    @Override
    @GetMapping("")
    public List<Book> get() {
        return bookService.get();
    }

    @Override
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> get(@PathVariable("isbn") Long isbn) {
        Book book = bookService.get(isbn);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> delete(@PathVariable("isbn") Long isbn) {

        int result = bookService.delete(isbn);
        return new ResponseEntity<String>("Book deleted successfully", HttpStatus.OK);
    }
}
