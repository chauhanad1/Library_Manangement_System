package com.example.library_management_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Library_Transactions")
public class Library_Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;
    @ManyToMany
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToMany
    @JoinColumn(name = "copy_id")
    private Book_Copies bookCopies;
    @Enumerated
    @Column(nullable = false)
    private Action action;
    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp;

    public enum Action{
        BORROW,
        RETURN
    }
}
