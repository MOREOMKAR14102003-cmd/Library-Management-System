package library;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
