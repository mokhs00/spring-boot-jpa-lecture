package com.example.demo.dto;

import com.example.demo.domain.Book;

public class BookResponse {
    private Long id;
    private String title;
    private Long authorId;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorId = book.getAuthorId();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
