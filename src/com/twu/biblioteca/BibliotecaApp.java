package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BibliotecaApp {

    private final  ArrayList<Book> bookList = new ArrayList<Book>();
    private final  ArrayList<Movie> movieList = new ArrayList<Movie>();
    private final  ArrayList<Book> checkedoutBooks = new ArrayList<Book>();
    private final ArrayList<Movie> checkedoutMovies = new ArrayList<Movie>();
    private ArrayList<LibraryUser> userList = new ArrayList<LibraryUser>();

    public void initAvailableBooks(){
        bookList.add(new Book("Book 1", "Author 1", "Pub Date 1"));
        bookList.add(new Book("Book 2", "Author 2", "Pub Date 2"));
        bookList.add(new Book("Book 3", "Author 3", "Pub Date 3"));
    }

    public void initAvailableMovies() {
        movieList.add(new Movie("Movie 1", 2010, "Director 1", 1));
        movieList.add(new Movie("Movie 2", 2012, "Director 2", 4));
        movieList.add(new Movie("Movie 3", 1990, "Director 3", 8));
    }

    public void initLibraryUsers() {
        userList.add(new LibraryUser("xxx-xxxx", "xxxxxx"));
        userList.add(new LibraryUser("yyy-yyyy", "yyyyyy"));
        userList.add(new LibraryUser("zzz-zzzz", "zzzzzz"));
    }

    public void libraryBookList() {
        for(Book book: bookList) {
            System.out.println(book.toString());
        }
    }

    public void returnBook(String bookTitle) {
        for(Book book: checkedoutBooks){
            if(book.getTitle().equals(bookTitle)){
                bookList.add(book);
                checkedoutBooks.remove(book);
                successfulReturnBook();
                return;
            }
        }
        unsuccessfulReturnBook();
    }
    public void unsuccessfulReturnBook() {
        System.out.println("That is not a valid book to return.");
    }

    public void successfulReturnBook() {
        System.out.println("Thank you for returning the book.");
    }
    public static String getBook() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean checkoutBook(String bookTitle) {
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(bookTitle)) {
                checkedoutBooks.add(book);
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void libraryMovieList() {
        for(Movie movie: movieList) {
            System.out.println(movie.toString());
        }

    }

    public boolean checkoutMovie(String movieTitle) {
        Iterator<Movie> iterator = movieList.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getName().equals(movieTitle)) {
                checkedoutMovies.add(movie);
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public String getMovie() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String whoCheckedOutBook() {
        return "xxx-xxxx";

    }

    public static String getUserDetails() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean loginIn() {
        System.out.print("Library Numer: ");
        String libraryNumber = getUserDetails();
       // System.out.println();
        System.out.print("Password: ");
        String password = getUserDetails();
        return validateUserCreditials(libraryNumber, password);
    }
    public boolean validateUserCreditials(String libraryNumber, String password) {
        for(LibraryUser user: userList){
            if (user.getLibraryNumber().equals(libraryNumber) && user.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
