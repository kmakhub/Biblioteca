package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {
    private  final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private  final ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
    private BibliotecaApp bibliotecaApp;
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        System.setIn(inputStream);
         bibliotecaApp = new BibliotecaApp();
    }

    @After
    public void tearDown() {
        System.setOut(null);

    }

    @Test
    public void shouldShowListOfBooks() {

        bibliotecaApp.initAvailableBooks();
        bibliotecaApp.libraryBookList();
        assertEquals("Book 1, Author 1, Pub Date 1\n" +
                "Book 2, Author 2, Pub Date 2\n" +
                "Book 3, Author 3, Pub Date 3\n", outputStream.toString());
    }

    @Test
    public void shouldAllowUserToSeeListOfAvailableMovies() {

        bibliotecaApp.initAvailableMovies();
        bibliotecaApp.libraryMovieList();
        assertEquals("Movie 1, 2010, Director 1, 1\n" +
                "Movie 2, 2012, Director 2, 4\n" +
                "Movie 3, 1990, Director 3, 8\n",outputStream.toString());
    }

    @Test
    public void shouldCheckIfYearEnteredIsInvalid() {
        bibliotecaApp.initAvailableMovies();
        //assertTrue(.isValidYear());

    }

    @Test
    public void testShouldTestIfUserCanSeeBookDetails(){

        Book book = new Book("Awesome c#", "Jonah", "2015");
        assertEquals("Awesome c#, Jonah, 2015", book.toString());
    }

    @Test
    public void shouldAllowUserToEnterOptionUntilUserQuits()  {
       // BibliotecaApp bibliotecaApp = new BibliotecaApp();
        //bibliotecaApp.quitApplication();
       // assertEquals(true, );

    }

    @Test
    public void shouldBeAbleToCheckoutBooks() {
        bibliotecaApp.initAvailableBooks();
        assertTrue(bibliotecaApp.checkoutBook("Book 1"));
        assertFalse(bibliotecaApp.checkoutBook("Book 4"));
        assertFalse(bibliotecaApp.checkoutBook("Book 1"));
    }

    @Test
    public void shouldBeAbleToCheckoutMovies() {
        bibliotecaApp.initAvailableMovies();
        assertTrue(bibliotecaApp.checkoutMovie("Movie 1"));
        assertFalse(bibliotecaApp.checkoutMovie("Movie 4"));
        assertFalse(bibliotecaApp.checkoutMovie("Movie 1"));
    }


}
