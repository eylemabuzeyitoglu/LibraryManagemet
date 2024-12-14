package org.eylemabz.services;

import org.eylemabz.models.Book;
import org.eylemabz.models.User;

public class LibraryService {
    private final BookService bookService;
    private final UserService userService;

    public LibraryService(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    public void barrowBook(String userId, String bookId){
          User user = userService.findUser(userId);
          Book book = bookService.findBook(bookId);

          if(user == null){
              System.out.println("User not found");
              return;
          } else if (book == null) {
              System.out.println("Book not found");
              return;
          }

          user.borrowBooks(book);
          System.out.println("Book borrowed successfully");
    }
    public void returnBook(String userId, String bookId) {
        User user = userService.findUser(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        user.returnBook(bookId);
        System.out.println("Book returned successfully!");
    }

}

