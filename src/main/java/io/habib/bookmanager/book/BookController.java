package io.habib.bookmanager.book;

import io.habib.bookmanager.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;

@RestController

public class BookController {

    private final BookFileReader bookFileReader;

    @Autowired
    public BookController(BookFileReader bookFileReader) {
        this.bookFileReader = bookFileReader;
    }

    @GetMapping("/books")
    public List<Book> getBooks(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String description) {
        List<Book> books = bookFileReader.getBooks();
        if (id != null) {
            books = books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .stream().toList();
        }
        if (description != null) {
            books = books.stream()
                    .filter(book -> book.getDescription().contains(description))
                    .toList();
        }
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookFileReader.getBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookFileReader.getBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }

    @GetMapping("/books/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return bookFileReader.getBooks().stream()
                .filter(book -> book.getTitle().equals(title))
                .toList();
    }

}
