package com.example.library_management_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book_Copies")
public class Book_Copies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "copy_id")
    private int copy_id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books book;
    @Column(name = "is_borrowed",nullable = false)
    private boolean is_borrowed;
}
