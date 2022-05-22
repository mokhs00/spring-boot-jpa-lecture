package com.example.demo.repository;

import com.example.demo.domain.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookInMemoryRepositoryTest {

    @Test
    @DisplayName("success")
    void findAll() {
        // given
        BookInMemoryRepository bookInMemoryRepository = new BookInMemoryRepository();
        long authorId = 1L;
        bookInMemoryRepository.save(new Book("title1", authorId));

        // when
        List<Book> bookList = bookInMemoryRepository.findAll();

        // then
        Assertions.assertEquals(1, bookList.size());
    }

    @Test
    @DisplayName("success")
    void findById() {
        // given
        BookInMemoryRepository bookInMemoryRepository = new BookInMemoryRepository();
        long authorId = 1L;
        bookInMemoryRepository.save(new Book("title1", authorId));
        bookInMemoryRepository.save(new Book("title2", 2L));

        Long expectedBookId = 2L;

        // when
        Book findBook = bookInMemoryRepository.findById(expectedBookId).get();

        // then
        Assertions.assertEquals(expectedBookId, findBook.getId());
    }

    @Test
    @DisplayName("success: 새로운 Book 저장 시 id 자동 추가")
    void save_success_새로운_book_저장_시_id_자동_입력() {
        // given
        BookInMemoryRepository bookInMemoryRepository = new BookInMemoryRepository();
        Book newBook = new Book("update-title", 2L);

        // when
        Book savedBook = bookInMemoryRepository.save(newBook);

        // then
        Assertions.assertEquals(1L, savedBook.getId());
    }

    @Test
    @DisplayName("success")
    void deleteById() {
        // given
        BookInMemoryRepository bookInMemoryRepository = new BookInMemoryRepository();
        bookInMemoryRepository.save(new Book(1L, "update-title", 2L));

        // when
        bookInMemoryRepository.deleteById(1L);
        List<Book> bookList = bookInMemoryRepository.findAll();

        // then
        Assertions.assertEquals(0, bookList.size());
    }

}