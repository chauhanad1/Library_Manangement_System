package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Borrowed_Books;

import java.sql.Timestamp;

public interface BorrowedService {
    void borrowBook(int book_id, int user_id);
    void returnBook(int book_id, int user_id);
    Borrowed_Books getBorrowedBooks(int copy_id, int user_id);
}
