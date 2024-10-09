package com.example.library_management_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Library_Transactions")
public class Library_Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "copy_id")
    private Book_Copies bookCopies;
    @Enumerated
    @Column(nullable = false)
    private Action action;
    @Column(name = "timestamp", nullable = false, updatable = false)
    private Timestamp timestamp;

    public enum Action{
        BORROW,
        RETURN
    }

    public Library_Transactions(Users user, Book_Copies bookCopies,Action action){
        this.users = user;
        this.bookCopies = bookCopies;
        this.action = action;
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
