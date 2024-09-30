package io.habib.bookmanager.book;

import io.habib.bookmanager.book.model.Book;

public class BookBuilder {
    private Integer id = 0;
    private String title = "";
    private String author = "";
    private String isbn = "";
    private String publicationDate = "";
    private String language = "";
    private String description = "";

    public BookBuilder() {
    }

    public BookBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public BookBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }

    public BookBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Book build() {
        return new Book(id, title, author, isbn, publicationDate, language, description);
    }


}
