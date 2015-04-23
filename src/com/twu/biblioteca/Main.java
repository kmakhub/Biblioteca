package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initAvailableBooks();
        bibliotecaApp.printWelcomeMessage();
        while(true) {
            bibliotecaApp.printMainMenu();
            bibliotecaApp.respondToUserInput(bibliotecaApp.getUserInput());
        }
    }
}
