package io.habib.bookmanager.book;

import io.habib.bookmanager.book.DTO.BookDTO;
import io.habib.bookmanager.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private BookFileReader bookFileReader;

    @Autowired
    public BookService(
            BookFileReader bookFileReader
    ) {
        this.bookFileReader = bookFileReader;
    }

    public List<Book> getBooks() {
        return this.bookFileReader.getBooks();
    }

    public List<Book> getByAuthor(String author) {
        return this.getBooks().stream()
                .filter(book -> book.getAuthor().equals(author))
                .toList();
    }

    public Book getByIsbn(String isbn) {
        for (Book book : getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        throw new IllegalArgumentException("Book not found");
    }

    public Book getById(Integer id) {
        for (Book book : getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new IllegalArgumentException("Book not found");
    }

    public List<Book> getBooksByTitle(String title) {
        List<Book> books = new ArrayList<>();
        for (Book book : getBooks()) {
            if (book.getTitle().equals(title)) {
                books.add(book);
            }
        }
        return books;
    }

    public Book addBook(BookDTO bookDTO) {
        List<Book> books = this.getBooks();
        Book book = new BookBuilder()
                .setAuthor(bookDTO.getAuthor())
                .setTitle(bookDTO.getTitle())
                .setDescription(bookDTO.getDescription())
                .setIsbn(bookDTO.getIsbn())
                .setId(books.get(books.size() - 1).getId() + 1)
                .build();
        books.add(book);
        Boolean result = bookFileReader.addBook(book);
        if (result) {
            return book;
        }
        throw new IllegalArgumentException("Book not added");
    }
}
