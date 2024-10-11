package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.Entity.Borrowed_Books;

import java.sql.Timestamp;
import java.util.List;

public interface BorrowedService {
    void borrowBook(int book_id, int user_id);
    void returnBook(int book_id, int user_id);
    Borrowed_Books getBorrowedBooks(int copy_id, int user_id);

    List<Object[]> getBorrowedBooksbyUserId(int userId);
}
