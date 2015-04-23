package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BibliotecaApp {

    private final  ArrayList<Book> bookList = new ArrayList<Book>();
    private final  ArrayList<Book> checkedoutBooks = new ArrayList<Book>();

    public void initAvailableBooks(){
        bookList.add(new Book("Book 1", "Author 1", "Pub Date 1"));
        bookList.add(new Book("Book 2", "Author 2", "Pub Date 2"));
        bookList.add(new Book("Book 3", "Author 3", "Pub Date 3"));
    }

    public void libraryBookList() {
        for(Book book: bookList) {
            System.out.println(book.toString());
        }
    }

    public void returnBook(String bookTitle) {
        for(Book book: checkedoutBooks){
            if(book.getTitle().equals(bookTitle)){
                bookList.add(book);
                checkedoutBooks.remove(book);
                successfulReturnBook();
                return;
            }
        }
        unsuccessfulReturnBook();
    }
    public void unsuccessfulReturnBook() {
        System.out.println("That is not a valid book to return.");
    }

    public void successfulReturnBook() {
        System.out.println("Thank you for returning the book.");
    }
    public static String getBook() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean checkoutBook(String bookTitle) {
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(bookTitle)) {
                checkedoutBooks.add(book);
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
