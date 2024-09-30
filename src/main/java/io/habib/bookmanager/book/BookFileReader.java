package io.habib.bookmanager.book;

import io.habib.bookmanager.book.model.Book;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookFileReader {
    private final URI filePath = BookFileReader.class.getClassLoader().getResource("data/books.txt").toURI();
    private final String bookData;

    public BookFileReader() throws URISyntaxException, IOException {
        this.bookData = readBookData();
    }

    private String readBookData() throws IOException {
        StringBuilder data = new StringBuilder();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        boolean firstLine = true;
        while ((line = bufferedReader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            // Append the line and add a newline character
            data.append(line).append("\n");
        }
        bufferedReader.close();
        return data.toString();
    }


    public String getBookData() {
        return bookData;
    }

    public URI getFilePath() {
        return filePath;
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        System.out.println(bookData);
        String[] bookDataArray = bookData.split("\n");
        System.out.println(bookDataArray.length);
        for (String bookData : bookDataArray) {
            String[] bookDataFields = bookData.split(",");
            // Create book object using BookBuilder
            Book book = new BookBuilder()
                    .setId(Integer.parseInt(bookDataFields[0]))
                    .setTitle(bookDataFields[1])
                    .setAuthor(bookDataFields[2])
                    .setIsbn(bookDataFields[3])
                    .setPublicationDate(bookDataFields[4])
                    .setLanguage(bookDataFields[5])
                    .setDescription(bookDataFields[6])
                    .build();
            books.add(book);
        }
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = new ArrayList<>();
        for (Book book : getBooks()) {
            if (book.getAuthor().equals(author)) {
                books.add(book);
            }
        }
        return books;
    }

    public Book getBookById(Integer id) {
        for (Book book : getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book getBookByIsbn(String isbn) {
        for (Book book : getBooks()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

}
