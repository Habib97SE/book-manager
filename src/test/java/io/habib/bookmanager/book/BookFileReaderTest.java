package io.habib.bookmanager.book;

import io.habib.bookmanager.book.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookFileReaderTest {

    @Autowired
    private BookFileReader bookFileReader;


    @Test
    void shouldReturnBookData() {
        // arrange
        int expected = 3;
        // act

        List<Book> books = bookFileReader.getBooks();

        // assert
        assertEquals(expected, books.size());
    }

    @Test
    void shouldReturnBookByAuthor() {
        // arrange
        Book book = new Book(1, "The Catcher in the Rye", "J.D. Salinger", "9780316769488", "1951-07-16", "English", "The Catcher in the Rye is a novel by J. D. Salinger");
        List<Book> books = new ArrayList<>();
        books.add(book);
        // act
        List<Book> actual = bookFileReader.getBooksByAuthor("J.D. Salinger");
        // assert
        assertEquals(books, actual);
    }

    @Test
    void shouldReturnBookByTitle () {
        // arrange
        List<Book> books = List.of(new Book(1, "The Catcher in the Rye", "J.D. Salinger", "9780316769488", "1951-07-16", "English", "The Catcher in the Rye is a novel by J. D. Salinger"));
        // act
        List<Book> actual = bookFileReader.getBooksByTitle("The Catcher in the Rye");
        // assert
        assertEquals(books, actual);
    }

    @Test
    void shouldReturnBookByISBN () {
        // arrange
        Book expected = new Book(1, "The Catcher in the Rye", "J.D. Salinger", "9780316769488", "1951-07-16", "English", "The Catcher in the Rye is a novel by J. D. Salinger");
        // act
        Book actual = bookFileReader.getBookByIsbn("9780316769488");
        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBookById () {
        // arrange
        Book expected = new Book(1, "The Catcher in the Rye", "J.D. Salinger", "9780316769488", "1951-07-16", "English", "The Catcher in the Rye is a novel by J. D. Salinger");
        // act
        Book actual = bookFileReader.getBookById(1);
        // assert
        assertEquals(expected, actual);
    }

}