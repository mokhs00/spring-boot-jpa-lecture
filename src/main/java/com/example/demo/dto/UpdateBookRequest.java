package com.example.demo.dto;

public class UpdateBookRequest {
    private String title;
    private Long authorId;

    public UpdateBookRequest(String title, Long authorId) {
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
