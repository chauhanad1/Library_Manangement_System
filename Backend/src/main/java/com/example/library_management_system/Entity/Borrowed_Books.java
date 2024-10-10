package com.example.library_management_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

 
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Borrowed_Books")
public class Borrowed_Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private int borrow_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "copy_id")
    private Book_Copies bookcopy;
    @Column(name = "borrow_date", nullable = false)
    private Timestamp borrowDate;
    @Column(name = "return_date")
    private Timestamp returnDate;

    public Borrowed_Books(){
        this.borrowDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public Borrowed_Books(Users user, Book_Copies bookcopy){
        this.user = user;
        this.bookcopy = bookcopy;
        this.borrowDate = Timestamp.valueOf(LocalDateTime.now());
    }


}
