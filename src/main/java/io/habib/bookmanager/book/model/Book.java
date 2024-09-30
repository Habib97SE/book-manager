package io.habib.bookmanager.book.model;

import java.util.Objects;

public class Book {
    private final Integer id;
    private final String title;
    private final String author;
    private final String isbn;
    private final String publicationDate;
    private final String language;
    private final String description;

    public Book(Integer id, String title, String author, String isbn, String publicationDate, String language, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.language = language;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Objects.equals(publicationDate, book.publicationDate) && Objects.equals(language, book.language) && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, isbn, publicationDate, language, description);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
