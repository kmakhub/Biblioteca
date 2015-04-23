package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initAvailableBooks();

        ConsolePrinter consolePrinter = new ConsolePrinter(bibliotecaApp);
        consolePrinter.printWelcomeMessage();

        boolean continueToRun = true;
        while(continueToRun) {
            bibliotecaApp.printMainMenu();
            continueToRun = consolePrinter.respondToUserInput();
        }
    }
}
