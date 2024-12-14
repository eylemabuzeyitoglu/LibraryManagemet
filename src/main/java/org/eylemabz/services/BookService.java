package org.eylemabz.services;

import org.eylemabz.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        books.add(book);
    }

    public void deleteBook(String bookId){
        books.removeIf(book -> book.getId().equals(bookId));
    }

    public Book findBook(String bookId){
        return books.stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
    }
     public List<Book> listBooks(){
        return books;
     }


}
