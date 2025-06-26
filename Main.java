package library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book("1984", "George Orwell", "12345"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "67890"));

        // Register users
        library.registerUser(new User(1, "omkar"));
        library.registerUser(new User(2, "sachin"));

        // Display books
        library.displayBooks();

        // Borrow a book
        library.borrowBook(1, "12345");

        // Display after borrowing
        library.displayBooks();

        // Return the book
        library.returnBook(1, "12345");

        // Display after returning
        library.displayBooks();
    }
}
