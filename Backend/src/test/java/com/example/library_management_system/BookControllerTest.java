package com.example.library_management_system;

import com.example.library_management_system.Controller.BookController;
import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.ServiceImpl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @InjectMocks
    private BookController bookcontroller;
    @Mock
    private BookServiceImpl bookService;

    @Test
    public void testGetAllBooks(){
        List<Books> books = new ArrayList<>();
        books.add(new Books());

        Mockito.when(bookService.getAllBooks()).thenReturn(books);
        ResponseEntity<List<Books>> response = bookcontroller.getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void testGetBookById() {
        Books book = new Books();
        Mockito.when(bookService.getBookbyId(1)).thenReturn(book);

        ResponseEntity<Books> response = bookcontroller.getBookById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testAddBook() {
        Books book = new Books();
        Mockito.when(bookService.saveBook(book)).thenReturn(book);

        ResponseEntity<Books> response = bookcontroller.addBook(book);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}

