package com.example.library_management_system.ServiceImpl;

import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.Service.BookService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Books> getAllBooks() {
        return null;
    }

    @Override
    public Book getBookbyId(int bookId) {
        return null;
    }
}
