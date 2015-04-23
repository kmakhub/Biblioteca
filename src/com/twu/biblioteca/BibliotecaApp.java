package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BibliotecaApp {

    private final String message = "Welcome to Biblioteca Application";
    private final  ArrayList<Book> bookList = new ArrayList<Book>();
    private final  ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
    private final String[] options = {"List Books", "Checkout Book", "Return Book"};


    public void initAvailableBooks(){
        bookList.add(new Book("Book 1", "Author 1", "Pub Date 1"));
        bookList.add(new Book("Book 2", "Author 2", "Pub Date 2"));
        bookList.add(new Book("Book 3", "Author 3", "Pub Date 3"));
    }

    public void printWelcomeMessage() {
        System.out.println(message);
    }

    public void libraryBookList() {
        for(Book book: bookList) {
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

    public int getUserInput() {
        System.out.print("Please enter selection:");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        try {
            option =  scanner.nextInt();
            while (option < 0 || option > 3) {
                option = getOption(scanner);
            }
        }catch(Exception ex) {
            option = getOption(scanner);
        }

        return option;
    }

    private static int getOption(Scanner scanner) {
        int option;
        System.out.println("Select a valid option:");
        option = scanner.nextInt();
        return option;
    }

    public void quitApplication() {
        System.exit(1);
    }

    public void checkoutBookWithMessage(String bookTitle) {

        if (checkoutBook(bookTitle))
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available.");


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

    public void printReturnBook() {
        System.out.print("Please enter book to return:");
        String option = getBook();
        returnBook(option);
    }

    public void printCheckoutBook() {
        System.out.print("Please enter book to checkout:");
        String option = getBook();
        checkoutBookWithMessage(option);
    }

    private static String getBook() {
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
