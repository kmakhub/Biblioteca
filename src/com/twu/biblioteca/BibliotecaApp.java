package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BibliotecaApp {

    private final  ArrayList<Book> bookList = new ArrayList<Book>();
    private final  ArrayList<Movie> movieList = new ArrayList<Movie>();
    private final  ArrayList<Book> checkedoutBooks = new ArrayList<Book>();

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
}
