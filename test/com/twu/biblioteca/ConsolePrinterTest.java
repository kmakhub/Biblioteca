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


    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
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
}