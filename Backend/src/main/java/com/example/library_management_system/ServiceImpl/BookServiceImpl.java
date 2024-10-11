package com.example.library_management_system.ServiceImpl;

import com.example.library_management_system.Entity.Book_Copies;
import com.example.library_management_system.Entity.Books;
import com.example.library_management_system.Repository.BookCopyRepository;
import com.example.library_management_system.Repository.BookRepository;
import com.example.library_management_system.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    public BookServiceImpl() {
    }

    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books getBookbyId(int bookId) {

        return bookRepository.findById((Integer)bookId).orElseThrow(() -> new RuntimeException("No Book with given book id"));
    }

    @Override
    public int getBookCopyID(int bookId) {
        return  bookCopyRepository.getAvailableCopyID(bookId);
    }

    @Override
    public void changeBorrowStatus(boolean borrowed_status, int copy_id) {
        bookCopyRepository.updateBorrowStatus(borrowed_status,copy_id);
    }

    @Override
    public void changeAvailableCopies(int available_copies, int book_id) {
        bookRepository.changeAvailableCopies(available_copies,book_id);
    }

    @Override
    public Books saveBook(Books book) {
        Books savedBook =  bookRepository.save(book);
        for (int i = 0; i < book.getTotal_copies(); i++) {
            Book_Copies bookCopy = new Book_Copies(book);
            Book_Copies saveCopy = bookCopyRepository.save(bookCopy);
        }
        return savedBook;

    }

    @Override
    public Books getBookbyCopyId(int copy_id) {
        return bookRepository.getBookbyCopyId(copy_id);
    }


}
