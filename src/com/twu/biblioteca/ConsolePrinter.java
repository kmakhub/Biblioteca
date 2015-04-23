package com.twu.biblioteca;

public class ConsolePrinter {
    private BibliotecaApp bibliotecaApp;
    private final String message = "Welcome to Biblioteca Application";

    public ConsolePrinter(BibliotecaApp bibliotecaApp) {
        this.bibliotecaApp = bibliotecaApp;
    }

    public void printWelcomeMessage() {
        System.out.println(message);
    }


    public boolean respondToUserInput() {
        switch (bibliotecaApp.getUserInput()){
            case 1: bibliotecaApp.libraryBookList(); break;
            case 2: bibliotecaApp.printCheckoutBook(); break;
            case 3: bibliotecaApp.printReturnBook(); break;
            case 0:
                return false;
            default:
                System.out.println("Select a valid option!");
        }
        return true;
    }

}
