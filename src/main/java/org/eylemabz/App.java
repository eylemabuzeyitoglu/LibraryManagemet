package org.eylemabz;

import org.eylemabz.models.Book;
import org.eylemabz.models.User;
import org.eylemabz.services.BookService;
import org.eylemabz.services.LibraryService;
import org.eylemabz.services.UserService;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        BookService bookService = new BookService();
        UserService userService = new UserService();
        LibraryService libraryService = new LibraryService(bookService,userService);
        Scanner sn = new Scanner(System.in);

        bookService.addBook(new Book("111", "Java Programing","Eylem",true));
        bookService.addBook(new Book("112","Spring Framework","Eylem1",true));
        userService.registerUser(new User("0001","Eylem"));
        userService.registerUser(new User("0002","Ronahi"));


        while(true){
            System.out.println("\n------ Kütüphane Yönetim Sistemi ------");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Sil");
            System.out.println("3. Kitapları Listele");
            System.out.println("4. Kitap Ödünç Al");
            System.out.println("5. Kitap İade Et");
            System.out.println("6. Kullanıcı Listele");
            System.out.println("7. Çıkış");
            System.out.println("Seçiminizi yapın: ");

            int choice = sn.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Kitap detaylarını sırasıyla girin (id-başlık-yazar)");
                    String bookId = String.valueOf(System.currentTimeMillis()); // dinamik ID oluştururur
                    String bookTitle = sn.nextLine();
                    String bookAuthor = sn.nextLine();
                    Book newBook = new Book(bookId,bookTitle,bookAuthor,true);
                    bookService.addBook(newBook);
                    System.out.println("Kitap başarıyla eklendi");
                    continue;
                case 2:
                    System.out.println("Silmek istediğiniz kitabın id sini girin");
                    String bookToDeleteId = sn.nextLine();
                    bookService.deleteBook(bookToDeleteId);
                    System.out.println("Kitap başarıyla silindi");
                    break;
                case 3:
                    System.out.println("Mevcut Kitaplar");
                    for(Book book: bookService.listBooks()){
                        System.out.println("ID: " + book.getId() + "| başlık: " + book.getTitle());
                    }
                    break;
                case 4:
                    System.out.println("Ödünç almak isteyen Kullanıcı Id sini girin: ");
                    String userId = sn.nextLine();
                    System.out.println("Ödünç almak istediğiniz kitap Id sini giriniz: ");
                    String borrowBookId = sn.nextLine();
                    libraryService.barrowBook(userId,borrowBookId);
                    break;
                case 5:
                    System.out.println("Kitap iade etmek isteyen Kullanıcı Id sini girin: ");
                    String userIdToReturn =  sn.nextLine();
                    System.out.println("İade etmek istediğiniz Kitap Id sini girin: ");
                    String bookIdToReturn = sn.nextLine();
                    libraryService.returnBook(userIdToReturn,bookIdToReturn);
                    break;
                case 6:
                    System.out.println("Mevcut Kullanıcılar: ");
                    for(User user :  userService.listUser()){
                        System.out.println("ID" + user.getId() + "| isim: " + user.getName() );
                    }
                    break;
                case 7:
                    System.out.println("Çıkılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }

    }
}
