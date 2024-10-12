package com.example.library_management_system;

import com.example.library_management_system.Controller.BorrowController;
import com.example.library_management_system.ServiceImpl.BorrowedBookServiceImpl;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class BorrowControllerTest {

    @InjectMocks
    private BorrowController borrowController;

    @Mock
    private BorrowedBookServiceImpl borrowedBookService;

    @Test
    public void testBorrowBook() {
        Mockito.doNothing().when(borrowedBookService).borrowBook(1, 1);

        ResponseEntity<String> response = borrowController.borrowBook(1, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book borrowed Successfully", response.getBody());
    }
}