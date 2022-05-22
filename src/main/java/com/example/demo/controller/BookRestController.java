package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookResponse;
import com.example.demo.dto.CreateBookRequest;
import com.example.demo.dto.UpdateBookRequest;
import com.example.demo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookResponse> findAll() {
        return this.bookService.findAll().stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookResponse> findById(@PathVariable(name = "bookId") Long bookId) {
        try {
            Book book = this.bookService.findById(bookId);

            return ResponseEntity.ok(new BookResponse(book));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public Long save(@RequestBody CreateBookRequest request) {
        return this.bookService.save(request);
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<Long> updateByBookId(
            @PathVariable(name = "bookId") Long bookId,
            @RequestBody UpdateBookRequest request
    ) {
        try {
            Long savedBookId = this.bookService.updateById(bookId, request);

            return ResponseEntity.ok(savedBookId);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{bookId}")
    public void removeById(@PathVariable(name = "bookId") Long bookId) {
        this.bookService.removeById(bookId);
    }
}
