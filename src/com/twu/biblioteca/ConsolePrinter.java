package com.twu.biblioteca;

import java.util.Scanner;

public class ConsolePrinter {
    private BibliotecaApp bibliotecaApp;
    private final String message = "Welcome to Biblioteca Application";
    private final String[] options = {"List Books", "Checkout Book", "Return Book"};

    public ConsolePrinter(BibliotecaApp bibliotecaApp) {
        this.bibliotecaApp = bibliotecaApp;
    }

    public void printWelcomeMessage() {
        System.out.println(message);
    }


    public boolean respondToUserInput() {
        switch (getUserInput()){
            case 1: bibliotecaApp.libraryBookList(); break;
            case 2: printCheckoutBook(); break;
            case 3: printReturnBook(); break;
            case 0:
                return false;
            default:
                System.out.println("Select a valid option!");
        }
        return true;
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

    public void printReturnBook() {
        System.out.print("Please enter book to return:");
        String option = bibliotecaApp.getBook();
        bibliotecaApp.returnBook(option);
    }

    public void printCheckoutBook() {
        System.out.print("Please enter book to checkout:");
        String option = bibliotecaApp.getBook();
        checkoutBookWithMessage(option);
    }

    public void checkoutBookWithMessage(String bookTitle) {
        if (bibliotecaApp.checkoutBook(bookTitle))
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available.");
    }

}
