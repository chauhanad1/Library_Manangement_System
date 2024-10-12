package com.example.library_management_system;

import com.example.library_management_system.Controller.BorrowController;
import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.Repository.BookCopyRepository;
import com.example.library_management_system.Repository.BookRepository;
import com.example.library_management_system.ServiceImpl.BookServiceImpl;
import com.example.library_management_system.ServiceImpl.BorrowedBookServiceImpl;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookCopyRepository bookCopyRepository;

    @Test
    public void testGetAllBooks() {
        List<Books> books = new ArrayList<>();
        books.add(new Books());

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        List<Books> result = bookService.getAllBooks();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testSaveBook() {
        Books book = new Books();
        Mockito.when(bookRepository.save(book)).thenReturn(book);

        Books result = bookService.saveBook(book);

        assertNotNull(result);
        Mockito.verify(bookRepository, Mockito.times(1)).save(book);
    }
}
