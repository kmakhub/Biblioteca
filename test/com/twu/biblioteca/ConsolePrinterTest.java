package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ConsolePrinterTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private ConsolePrinter consolePrinter;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        bibliotecaApp = new BibliotecaApp();
         consolePrinter = new ConsolePrinter(bibliotecaApp);
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void shouldReturnFalseWhenQuitApplication() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("0".getBytes());
        System.setIn(inputStream);
        assertFalse(consolePrinter.respondToUserInput());
    }

    @Test
    public void shouldReturnTrueIfNotQuitingApplication() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputStream);
        assertTrue(consolePrinter.respondToUserInput());

    }

    @Test
    public void shouldPrintWelcomeMessage(){
        String message = "Welcome to Biblioteca Application";
        consolePrinter.printWelcomeMessage();
        assertEquals(message + "\n", outputStream.toString());

    }

    @Test
    public void shouldHaveAMenu(){

        consolePrinter.printMainMenu();
        assertEquals("\n" +
                "Main Menu:\n" +
                "1. List Books\n" +
                "2. List Movies\n" +
                "3. Checkout Book\n" +
                "4. Checkout Movie\n" +
                "5. Return Book\n" +
                "0. Quit\n", outputStream.toString());
    }

    @Test
    public void shouldSeeWhoCheckoutABook()  {
        bibliotecaApp.initLibraryUsers();
       // bibliotecaApp.loginIn();
        assertEquals("xxx-xxxx", bibliotecaApp.whoCheckedOutBook());
       // assertEquals("xxx-xxxy", bibliotecaApp.whoCheckedOutBook());

    }

    @Test
    public void shouldCheckForInvalidEntry(){
        // consolePrinter.getUserInput();
       // assertEquals("Select a valid option!", outputStream.toString());
    }
    @Test
    public void shouldPrintMessageWhenCheckingOutBooks() {
        bibliotecaApp.initAvailableBooks();
        consolePrinter.checkoutBookWithMessage("Book 1");
        assertEquals("Thank you! Enjoy the book\n", outputStream.toString());

        consolePrinter.checkoutBookWithMessage("Book 1");
        assertEquals("Thank you! Enjoy the book\nThat book is not available.\n", outputStream.toString());
    }
    @Test
    public void shouldBeAbleToReturnBook()  {

        bibliotecaApp.initAvailableBooks();
        consolePrinter.checkoutBookWithMessage("Book 1");
        bibliotecaApp.returnBook("Book 1");
        assertEquals("Thank you! Enjoy the book\nThank you for returning the book.\n", outputStream.toString());

        bibliotecaApp.returnBook("Book 1");
        assertEquals("Thank you! Enjoy the book\nThank you for returning the book.\nThat is not a valid book to return.\n", outputStream.toString());
    }


}