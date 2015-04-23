package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private final String message = "Welcome to Biblioteca Application";
    private final static ArrayList<Book> bookList = new ArrayList<Book>();
    private final static ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
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

    public int getUserInput() {
        System.out.print("Please enter selection:");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        try {

            option =  scanner.nextInt();
            while (option < 0 || option > 3) {
                System.out.print("Select a valid option:");
                option = scanner.nextInt();
            }
        }
        catch(Exception ex) {

            System.out.println("Select a valid option:");
            option = scanner.nextInt();
        }

        return option;
    }

    public void quitApplication() {
        System.exit(1);
    }

    public void checkoutBook(String bookTitle) {

        for(Book book: bookList){
            if(book.getTitle().equals(bookTitle)){
                checkedoutBooks.add(book);
                bookList.remove(book);
                System.out.println("Thank you! Enjoy the book");
                break;

            }

        }
        System.out.println("That book is not available.");

    }

    public void returnBook(String bookTitle) {
        for(Book book: checkedoutBooks){
            if(book.getTitle().equals(bookTitle)){
                bookList.add(book);
                checkedoutBooks.remove(book);
                successfulReturnBook();
                break;
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

    public void respondToUserInput(int option) {
        switch (option){
            case 1: libraryBookList(); break;
            case 2: printCheckoutBook(); break;
            case 3: printReturnBook(); break;
            case 0: quitApplication(); break;
            default:
                System.out.println("Select a valid option!");
        }
    }
    private void printReturnBook() {

        System.out.print("Please enter book to return:");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        returnBook(option);
    }

    private void printCheckoutBook() {
        System.out.print("Please enter book to checkout:");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        checkoutBook(option);


    }
}
