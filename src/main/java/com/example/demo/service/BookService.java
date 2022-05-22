package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.CreateBookRequest;
import com.example.demo.dto.UpdateBookRequest;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    public Book findById(Long bookId) {
        return this.bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("not exist book id: '" + bookId + "'"));
    }

    public Long save(CreateBookRequest request) {
        Book book = new Book(request.getTitle(), request.getAuthorId());
        Book savedBook = this.bookRepository.save(book);
        return savedBook.getId();
    }

    public Long update(Long bookId, UpdateBookRequest request) {
        Book book = this.findById(bookId);
        book.updateInfo(request.getTitle(), request.getAuthorId());

        Book savedBook = this.bookRepository.save(book);
        return savedBook.getId();
    }

    public void removeById(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }

}
