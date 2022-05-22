package com.example.demo.repository;

import com.example.demo.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book findById(Long id);

    Book save(Book book);

    void deleteById(Long id);
}
