package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<Books> getAllBooks();
    Book getBookbyId(int bookId);
}
