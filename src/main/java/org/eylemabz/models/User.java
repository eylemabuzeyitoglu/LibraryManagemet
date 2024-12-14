package org.eylemabz.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String name;
    private List<Book> borrowBooks = new ArrayList<>();

    public User(String id, String name, List<Book> borrowedBooks) {
        this.id = id;
        this.name = name;
        this.borrowBooks = borrowBooks;
    }


    public User(String string, String userName) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", barrowedBooks=" + borrowBooks +
                '}';
    }


    public void borrowBook(Book book) {
        borrowBooks.add(book);
    }

    public void borrowBooks(Book book) {
    }

    public void returnBook(String bookId) {
        borrowBooks.removeIf(book -> book.getId().equals(bookId));
    }
}
