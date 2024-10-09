package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Borrowed_Books;

public interface BorrowedService {
    Borrowed_Books borrowBook(int book_id);
}
