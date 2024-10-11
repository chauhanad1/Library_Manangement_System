package com.example.library_management_system.Service;

import com.example.library_management_system.Entity.Books;

 
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Books> getAllBooks();
    Books getBookbyId(int bookId);
    int getBookCopyID(int bookId);
    void changeBorrowStatus(boolean borrowed_status, int copy_id);
    void changeAvailableCopies(int available_copies, int book_id);

    Books saveBook(Books book);

    Books getBookbyCopyId(int copy_id);
}
