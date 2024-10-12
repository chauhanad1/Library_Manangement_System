package com.example.library_management_system.Controller;

import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.Entity.Borrowed_Books;
import com.example.library_management_system.ServiceImpl.BorrowedBookServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/borrow")
@CrossOrigin(origins = "http://localhost:5173")
public class BorrowController {

    @Autowired
    private BorrowedBookServiceImpl borrowedBookService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Map<String,Object>>> getBorrowedBooksbyUserId(@PathVariable int userId){
        List<Object[]> borrowedBooksbyUser = borrowedBookService.getBorrowedBooksbyUserId(userId);

        List<Map<String,Object>>  response=  borrowedBooksbyUser.stream().map(record -> {
            Map<String,Object> bookMap = new HashMap<>();
            bookMap.put("borrow_id",record[0]);
            bookMap.put("title",record[1]);
            bookMap.put("borrow_date", record[2]);
            bookMap.put("copy_id", record[3]);
            return bookMap;
        }).toList();
        if(response.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(response);

    }

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
