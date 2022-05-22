package com.example.demo.dto;

public class CreateBookRequest {
    private String title;
    private Long authorId;

    public CreateBookRequest(String title, Long authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public Long getAuthorId() {
        return authorId;
    }
}
