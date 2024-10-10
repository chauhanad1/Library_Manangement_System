package com.example.library_management_system.ServiceImpl;

import com.example.library_management_system.Entity.*;
import com.example.library_management_system.Repository.BookCopyRepository;
import com.example.library_management_system.Repository.BorrowedBookRepository;
import com.example.library_management_system.Repository.LibraryTransaction;
import com.example.library_management_system.Service.BookService;
import com.example.library_management_system.Service.BorrowedService;
import com.example.library_management_system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BorrowedBookServiceImpl implements BorrowedService {
    @Autowired
    private BookServiceImpl bookservice;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;
    @Autowired
    private BookCopyRepository bookCopyRepository;
//    @Autowired
//    private Library_Transactions libraryTransactions;
    @Autowired
    private LibraryTransaction librarytransactionrepository;
    Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());


    @Override
    @Transactional
    public void borrowBook(int book_id, int user_id) {
        Users user = userService.getUserbyID(user_id) ;
        //checking borrowed_count
        int borrowed_count = user.getBorrowed_book_count();
        if(borrowed_count>=2){
            throw new RuntimeException("Maximum Borrow limit reached");
        }
        else{
            Books book = bookservice.getBookbyId(book_id);
            //checking available copies
            int available_copies = book.getAvailable_copies();
            if(available_copies<=0){
                throw new RuntimeException("No available copies to borrow");
            }
            else{
                //finding a copy_id that is available
                int copy_id  = bookservice.getBookCopyID(book_id);
                Book_Copies bookCopy = bookCopyRepository.findById(copy_id).get();

                // updating copy_id since book is borrowed.
                bookservice.changeBorrowStatus(true,copy_id);

                //update available copies in Books and borrowed_book_count in users
                bookservice.changeAvailableCopies(available_copies-1,book_id);
                userService.changeBorrowCount(borrowed_count+1,user_id);

                //updating borrowed_books table
                borrowedBookRepository.save(new Borrowed_Books(user,bookCopy));

                //updating Library Transaction table
                Library_Transactions library_transactions = new Library_Transactions(user,bookCopy,Library_Transactions.Action.BORROW);
                librarytransactionrepository.save(library_transactions);

            }
        }
    }

    @Override
    @Transactional
    public void returnBook(int user_id, int copy_id) {

        Users user = userService.getUserbyID(user_id);
        int borrowed_count = user.getBorrowed_book_count();

        Books books = bookservice.getBookbyCopyId(copy_id);
        int available_copies = books.getAvailable_copies();
        int book_id = books.getBook_id();

        //change borrowed_count in users
        userService.changeBorrowCount(borrowed_count-1,user_id);

        //change available copies in books
        bookservice.changeAvailableCopies(available_copies+1,book_id);


        // change is_borrowed status in bookcopy
        bookservice.changeBorrowStatus(false,copy_id);

        //set return date  in borrowed_books
        Borrowed_Books borrowedBooks =getBorrowedBooks(copy_id, user_id);
        borrowedBooks.setReturnDate(currentTimestamp);
        borrowedBookRepository.updateBorrowTable(borrowedBooks.getReturnDate(), copy_id,book_id);



        //add library transaction
        Library_Transactions library_transactions = librarytransactionrepository.getLibraryTransactions(user_id,copy_id);
        library_transactions.setAction(Library_Transactions.Action.RETURN);
        library_transactions.setTimestamp(currentTimestamp);
        librarytransactionrepository.save(library_transactions);



    }

    @Override
    public Borrowed_Books getBorrowedBooks(int copy_id, int user_id) {
        return borrowedBookRepository.getBorrowedBooks(copy_id, user_id);
    }
}
