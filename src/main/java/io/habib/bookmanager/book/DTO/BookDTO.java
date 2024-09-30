package io.habib.bookmanager.book.DTO;

public class BookDTO {
    private String title;
    private String author;
    private String isbn;
    private String publicationDate;
    private String language;
    private String description;

    public BookDTO() {
    }

    public BookDTO(String title, String author, String description, String isbn, String language, String publicationDate) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.language = language;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
