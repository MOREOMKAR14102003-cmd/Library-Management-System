package library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    public void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void borrowBook(int userId, String isbn) {
        User user = findUser(userId);
        Book book = findBook(isbn);

        if (user != null && book != null && book.isAvailable()) {
            book.setAvailable(false);
            user.borrowBook(book);
            System.out.println(user.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Borrow failed. Book not available or user not found.");
        }
    }

    public void returnBook(int userId, String isbn) {
        User user = findUser(userId);
        if (user != null) {
            for (Book book : user.getBorrowedBooks()) {
                if (book.getIsbn().equals(isbn)) {
                    book.setAvailable(true);
                    user.returnBook(book);
                    System.out.println(user.getName() + " returned " + book.getTitle());
                    return;
                }
            }
        }
        System.out.println("Return failed. Book not found with user.");
    }

    private User findUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) return user;
        }
        return null;
    }

    private Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }
}
