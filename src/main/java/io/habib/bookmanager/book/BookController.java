package io.habib.bookmanager.book;

import io.habib.bookmanager.book.DTO.BookDTO;
import io.habib.bookmanager.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String description) {
        if (id == null && description == null) {
            return bookService.getBooks();
        }
        return bookService.getBooks().stream()
                .filter(book -> id == null || Objects.equals(book.getId(), id))
                .filter(book -> description == null || book.getDescription().contains(description))
                .toList();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/books/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.getBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }

    @GetMapping("/books/title/{title}")
    public List<Book> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooks().stream()
                .filter(book -> book.getTitle().equals(title))
                .toList();
    }

    @PostMapping("/books")
    public Map<String, String> addBook (@RequestBody BookDTO bookDTO) {
        Book book = bookService.addBook(bookDTO);
        return Map.of("message", "Book added successfully", "book", book.toString());
    }

}
