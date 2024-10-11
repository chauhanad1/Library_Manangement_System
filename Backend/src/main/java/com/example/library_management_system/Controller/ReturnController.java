package com.example.library_management_system.Controller;

import com.example.library_management_system.ServiceImpl.BorrowedBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/return")
@CrossOrigin(origins = "http://localhost:5173")
public class ReturnController {
    @Autowired
    private BorrowedBookServiceImpl borrowedBookService;

    @PostMapping("/{copyId}/{userId}")
    public ResponseEntity<String> returnbook(@PathVariable int copyId, @PathVariable int userId){
        try{
            borrowedBookService.returnBook(userId,copyId);
            return new ResponseEntity<>("Book returned Successfully", HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
