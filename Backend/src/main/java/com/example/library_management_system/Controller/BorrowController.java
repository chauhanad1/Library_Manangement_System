package com.example.library_management_system.Controller;

import com.example.library_management_system.Entity.Borrowed_Books;
import com.example.library_management_system.ServiceImpl.BorrowedBookServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowedBookServiceImpl borrowedBookService;

    @PostMapping("/{bookId}/{userId}")
    public ResponseEntity<String> borrowBook(@PathVariable int bookId, @PathVariable int userId){
        try{
            borrowedBookService.borrowBook(bookId,userId);
            return new ResponseEntity<>("Book borrowed Successfully", HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
