package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private  final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private  final ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());



    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);


    }

    @After
    public void tearDown() {
        System.setOut(null);

    }

    @Test
    public void shouldPrintWelcomeMessage(){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();

        String message = "Welcome to Biblioteca Application";
        bibliotecaApp.printWelcomeMessage();

        assertEquals(message + "\n", outputStream.toString());

    }

    @Test
    public void shouldShowListOfBooks() {

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.initAvailableBooks();
        bibliotecaApp.libraryBookList();
        assertEquals("Book 1 , Author 1 , Pub Date 1\n" +
                "Book 2 , Author 2 , Pub Date 2\n" +
                "Book 3 , Author 3 , Pub Date 3\n", outputStream.toString());
    }

    @Test
    public void testShouldTestIfUserCanSeeBookDetails(){

        Book book = new Book("Awesome c#", "Jonah", "2015");
        assertEquals("Awesome c#, Jonah, 2015", book.toString());
    }

    @Test
    public void shouldHaveAMenu(){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.printMainMenu();
        assertEquals("\nMain Menu\n" + "1. List Books\n" +
                "0. Quit", outputStream.toString());
    }

    @Test
    public void shouldCheckForInvalidEntry(){

        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.getUserInput();
        //assertEquals("Select a valid option!", outputStream.toString());


    }

    @Test
    public void shouldAllowUserToEnterOptionUntilUserQuits()  {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.quitApplication();
        // bibliotecaApp.respondToUserInput(bibliotecaApp.getUserInput());
        assertEquals("Thank you! Goodbye!", outputStream.toString());

    }
}
