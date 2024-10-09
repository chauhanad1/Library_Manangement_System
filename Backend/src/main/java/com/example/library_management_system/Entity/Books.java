package com.example.library_management_system.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int book_id;
    @Column(name = "title",nullable = false,length = 255)
    private String title;
    @Column(name = "author", length = 100)
    private String author;
    @Column(name = "publisher",length = 100)
    private String publisher;
    @Column(name = "published_year")
    private int published_year;
    @Column(name = "category",length = 100)
    private String category;
    @Column(name = "total_copies")
    private int total_copies;
    @Column(name = "available_copies")
    private int available_copies;
}
