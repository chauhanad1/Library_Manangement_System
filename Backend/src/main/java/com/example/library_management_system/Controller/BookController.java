package com.example.library_management_system.Controller;

import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.Repository.BookCopyRepository;
import com.example.library_management_system.Service.BookService;
import com.example.library_management_system.ServiceImpl.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;




//    @Operation(summary= "", description = "")
    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){
        List<Books> books = bookService.getAllBooks();
        if(books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable int id){
        Books book = bookService.getBookbyId(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Books> addBook(@RequestBody Books book){
    Books newBook = bookService.saveBook(book);
    return new ResponseEntity<>(newBook,HttpStatus.CREATED);
    }
}

