package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initAvailableBooks();
        bibliotecaApp.initLibraryUsers();
        bibliotecaApp.initAvailableMovies();

        ConsolePrinter consolePrinter = new ConsolePrinter(bibliotecaApp);

        consolePrinter.printWelcomeMessage();

        while ( bibliotecaApp.loginIn() != true)
        {
            System.out.println("Invalid library number or password!");
        }
           if(bibliotecaApp.loginIn()){
               boolean continueToRun = true;
               while(continueToRun) {
                   consolePrinter.printMainMenu();
                   continueToRun = consolePrinter.respondToUserInput();
               }

           }


    }


}
