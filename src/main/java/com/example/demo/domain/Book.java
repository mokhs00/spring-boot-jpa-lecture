package com.example.demo.domain;

public class Book {
    private Long id;
    private String title;
    private Long authorId;

    public Book(Long id, String title, Long authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
    }

    public Book(String title, Long authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public void updateInfo(String title, Long authorId) {
        this.title = title;
        this.authorId = authorId;
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
