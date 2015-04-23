package com.twu.biblioteca;

public class LibraryUser {
    private String libraryNumber;
    private String userPassword;

    public LibraryUser(String libraryNumber, String userPassword) {

        this.libraryNumber = libraryNumber;
        this.userPassword = userPassword;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
