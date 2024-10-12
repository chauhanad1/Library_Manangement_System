package com.example.library_management_system;


import com.example.library_management_system.Controller.ReturnController;
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
public class ReturnControllerTest {

    @InjectMocks
    private ReturnController returnController;

    @Mock
    private BorrowedBookServiceImpl borrowedBookService;

    @Test
    public void testReturnBook() {
        Mockito.doNothing().when(borrowedBookService).returnBook(1, 1);

        ResponseEntity<String> response = returnController.returnbook(1, 1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Book returned Successfully", response.getBody());
    }
}
