package com.twu.biblioteca;

public class ConsolePrinter {
    private BibliotecaApp bibliotecaApp;

    public ConsolePrinter(BibliotecaApp bibliotecaApp) {
        this.bibliotecaApp = bibliotecaApp;
    }


    public boolean responsdToUserInput() {
        switch (bibliotecaApp.getUserInput()){
            case 1: bibliotecaApp.libraryBookList(); break;
            case 2: bibliotecaApp.printCheckoutBook(); break;
            case 3: bibliotecaApp.printReturnBook(); break;
            case 0:
                bibliotecaApp.quitApplication();
                return false;
            default:
                System.out.println("Select a valid option!");
        }
        return true;
    }

}
