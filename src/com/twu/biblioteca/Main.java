package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printWelcomeMessage();
        bibliotecaApp.initAvailableBooks();
        bibliotecaApp.libraryBookList();
    }
}
