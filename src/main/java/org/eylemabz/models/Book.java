package org.eylemabz.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;
    private List<Book> borrowBooks = new ArrayList<>();


    public Book(String id, String title, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public List<Book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<Book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    public void borrowBook(Book book) {
        borrowBooks.add(book);
    }
}
