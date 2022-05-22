package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookInMemoryRepository implements BookRepository{
    private final List<Book> bookList = new ArrayList<>();
    private Long bookNextId = 1L;

    public BookInMemoryRepository() {
        init();
    }

    public void init() {
        this.bookList.clear();
        this.bookNextId = 1L;
        this.save(new Book("스프링 완전 정복", 1L));
    }

    @Override
    public List<Book> findAll() {
        return this.bookList;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public Book save(Book book) {
        Optional<Book> bookOptional = this.findById(book.getId());
        if (bookOptional.isPresent()) {
            Book targetBook = bookOptional.get();
            targetBook.updateInfo(book.getTitle(), book.getAuthorId());

            return targetBook;
        }

        Book savedBook = new Book(bookNextId++, book.getTitle(), book.getAuthorId());
        this.bookList.add(savedBook);

        return savedBook;
    }

    @Override
    public void deleteById(Long id) {
        this.bookList.removeIf(book -> book.getId().equals(id));
    }
}
