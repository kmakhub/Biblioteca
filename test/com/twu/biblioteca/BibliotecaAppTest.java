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
}
