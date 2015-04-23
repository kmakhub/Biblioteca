package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private final String message = "Welcome to Biblioteca Application";
    private final static ArrayList<Book> bookList = new ArrayList<Book>();
    private final String[] options = {"List Books", "Checkout Book", "Return Book"};


    public static void initAvailableBooks(){
        bookList.add(new Book("Book 1", "Author 1", "Pub Date 1"));
        bookList.add(new Book("Book 2", "Author 2", "Pub Date 2"));
        bookList.add(new Book("Book 3", "Author 3", "Pub Date 3"));
    }

    public void printWelcomeMessage() {
        System.out.println(message);
    }

    public static void libraryBookList() {
        for(Book book: bookList){

            System.out.println(book.toString());
        }
    }

    public void printMainMenu() {
        System.out.println("\nMain Menu:");
        int iterator = 1;
        for(String option: options){
            System.out.println(iterator+". "+option);
            iterator++;
        }
        System.out.println("0. Quit");
    }
}
