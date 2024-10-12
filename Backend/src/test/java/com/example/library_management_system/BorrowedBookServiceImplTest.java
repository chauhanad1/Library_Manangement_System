package com.example.library_management_system;

import com.example.library_management_system.Controller.BorrowController;
import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.Entity.Users;
import com.example.library_management_system.Repository.BookCopyRepository;
import com.example.library_management_system.Repository.BorrowedBookRepository;
import com.example.library_management_system.Repository.LibraryTransaction;
import com.example.library_management_system.ServiceImpl.BookServiceImpl;
import com.example.library_management_system.ServiceImpl.BorrowedBookServiceImpl;
import com.example.library_management_system.ServiceImpl.UserServiceImpl;
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
public class BorrowedBookServiceImplTest {

    @InjectMocks
    private BorrowedBookServiceImpl borrowedBookService;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private BookServiceImpl bookService;

    @Mock
    private BookCopyRepository bookCopyRepository;

    @Mock
    private BorrowedBookRepository borrowedBookRepository;

    @Mock
    private LibraryTransaction libraryTransactionRepository;

//    @Test
//    public void testBorrowBook() {
//        Users user = new Users();
//        user.setBorrowed_book_count(1);
//
//        Books book = new Books();
//        book.setAvailable_copies(1);
//
//        Mockito.when(userService.getUserbyID(1)).thenReturn(user);
//        Mockito.when(bookService.getBookbyId(1)).thenReturn(book);
//        Mockito.when(bookService.getBookCopyID(1)).thenReturn(1);
//
//        borrowedBookService.borrowBook(1, 1);
//
//        Mockito.verify(userService, Mockito.times(1)).getUserbyID(1);
//        Mockito.verify(bookService, Mockito.times(1)).getBookbyId(1);
//        Mockito.verify(bookService, Mockito.times(1)).changeBorrowStatus(true, 1);
//    }
//
//    @Test
//    public void testReturnBook() {
//        Users user = new Users();
//        user.setBorrowed_book_count(1);
//
//        Books book = new Books();
//        book.setAvailable_copies(1);
//
//        Mockito.when(userService.getUserbyID(1)).thenReturn(user);
//        Mockito.when(bookService.getBookbyCopyId(1)).thenReturn(book);
//
//        borrowedBookService.returnBook(1, 1);
//
//        Mockito.verify(userService, Mockito.times(1)).changeBorrowCount(0, 1);
//        Mockito.verify(bookService, Mockito.times(1)).changeBorrowStatus(false, 1);
//    }
}