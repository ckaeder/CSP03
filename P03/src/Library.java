//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Library
// Files: Book.java, Librarian.java, Subscriber.java, BookLibraryTests.java
// Course: CS300 Spring 2019
//
// Author: Cecelia Kaeder
// Email: ckaeder@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Ryann Mahajan
// Partner Email: rmahajan4@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
/////////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.*;

public class Library {
    // instance fields
    private String address; // Street address of this library
    private Librarian librarian; // this library's librarian. This library must have only ONE
    // librarian
    private ArrayList<Book> books; // list of the books in this library
    private ArrayList<Subscriber> subscribers; // list of this library's subscribers

    public Library(String address, String librarianUsername, String librarianLogin) {
        this.address = address;
        this.librarian = new Librarian(librarianUsername, librarianLogin);
        this.books = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public String getAddress() {
        return address;
    }

    // @return a Book given a book identifier if found, and null otherwise.
    public Book findBook(int bookId){
        for (Book book: books) {
            if (book.getID()==bookId) return book;
        }
        System.out.println("Error: this book identifier didn't match any of our books identifiers.");
        return null;
    }

    /*
    * @return the list of books having a given title in this library.
    * The comparison used by this method is case insensitive
    */
    public java.util.ArrayList<Book> findBookByTitle(String title) {
        ArrayList<Book> found = new ArrayList<>();

        for (Book book: books) {
            if (book.getTitle().equalsIgnoreCase(title)) found.add(book);
        }

        return found;
    }

    /*
     * @return the list of books having a given author in this library.
     * The comparison used by this method is case insensitive
     */
    public java.util.ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> found = new ArrayList<>();

        for (Book book: books) {
            if (book.getAuthor().equalsIgnoreCase(author)) found.add(book);
        }

        return found;
    }

    // Adds a new book to the library (to the books list)
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book with Title " + title + " is successfully added to the library.");
    }

    // Removes a book given its identifier from the library (from books list)
    public Book removeBook(int bookId) {
        for (int i=0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getID()==bookId && book.isAvailable()) {
                books.remove(book);
                return book;
            }
        }
        return null;
    }

    // Adds a new subscriber to this library (to subscribers list)
    public void addSubscriber(String name, int pin, String address, String phoneNumber) {
        Subscriber subscriber = new Subscriber(name, pin, address, phoneNumber);
        subscribers.add(subscriber);
        System.out.println("Library card with bar code " + subscriber.getCARD_BAR_CODE() + " is successfully issued to the new subscriber " + name + ".");
    }

    // @return subscriber given its cardBarCode, or null if not found
    public Subscriber findSubscriber(int cardBarCode) {
        for (Subscriber subscriber: subscribers) {
            if (subscriber.getCARD_BAR_CODE()==cardBarCode) return subscriber;
        }

        System.out.println( "Error: this card bar code didn't match any of our records.");
        return null;
    }

    /**
     * Reads and processes the user commands with respect to the menu of this application
     *
     * @param scanner Scanner object used to read the user command lines
     */
    public void readProcessUserCommand(Scanner scanner) {
        final String promptCommandLine = "ENTER COMMAND: ";
        displayMainMenu(); // display the library management system main menu
        System.out.print(promptCommandLine);
        String command = scanner.nextLine(); // read user command line
        String[] commands = command.trim().split(" "); // split user command
        while (commands[0].trim().charAt(0) != '3') { // '3': Exit the application
            switch (commands[0].trim().charAt(0)) {
                case '1': // login as librarian commands[1]: password
                    if (this.librarian.checkPassword(commands[1])) {
                        // read and process librarian commands
                        readProcessLibrarianCommand(scanner);
                    } else { // error password
                        System.out.println("Error: Password incorrect!");
                    }
                    break;
                case '2': // login as subscriber commands[1]: card bar code
                    Subscriber subscriber = this.findSubscriber(Integer.parseInt(commands[1]));
                    if (subscriber != null) {
                        if (subscriber.getPin() == Integer.parseInt(commands[2])) // correct PIN
                            // read and process subscriber commands
                            readProcessSubscriberCommand(subscriber, scanner);
                        else
                            System.out.println("Error: Incorrect PIN.");
                    }
                    break;
            }
            // read and split next user command line
            displayMainMenu(); // display the library management system main menu
            System.out.print(promptCommandLine);
            command = scanner.nextLine(); // read user command line
            commands = command.trim().split(" "); // split user command line
        }
        //displayGoodByeLogoutMessage();
    }

    /**
     * Reads and processes the librarian commands according to the librarian menu
     *
     * @param scanner Scanner object used to read the librarian command lines
     */
    private void readProcessLibrarianCommand(Scanner scanner) {
        final String promptCommandLine = "ENTER COMMAND: ";
        displayLibrarianMenu();
        System.out.print(promptCommandLine);

        String command = scanner.nextLine(); // read user command line
        String[] commands = command.trim().split(" "); // split user command
        while (commands[0].trim().charAt(0) != '9') { // '9': Logout
            switch (commands[0].trim().charAt(0)) {
                case 1: // Add new book
                    addBook(commands[1], commands[2]);
                    break;

                case 2: // Add new subscriber
                    addSubscriber(commands[1], Integer.parseInt(commands[2]),commands[3], commands[4]);
                    break;

                case 3: // Check out book
                    findSubscriber(Integer.parseInt(commands[1])).checkoutBook(findBook(Integer.parseInt(commands[2])));
                    break;

                case 4: // Return book
                    findSubscriber(Integer.parseInt(commands[1])).returnBook(findBook(Integer.parseInt(commands[2])));
                    break;

                case 5: // Display Personal Info of a Subscriber
                    findSubscriber(Integer.parseInt(commands[1])).displayPersonalInfo();
                    break;

                case 6: // Display Books Checked out by a Subscriber
                    findSubscriber(Integer.parseInt(commands[1])).displayBooksCheckedOut();
                    break;

                case 7: // Display All Books
                    displayBooks(books);
                    break;

                case 8: // Remove a Book
                    removeBook(Integer.parseInt(commands[1]));
                    break;

                case 9: // Logout
                    displayMainMenu();
                    continue;
            }

            // read and split next user command line
            displayLibrarianMenu(); // display the library management system librarian menu
            System.out.print(promptCommandLine);
            command = scanner.nextLine(); // read user command line
            commands = command.trim().split(" "); // split user command line
        }

    }

    /**
     * Reads and processes the subscriber commands according to the subscriber menu
     *
     * @param subscriber Current logged in subscriber
     * @param scanner Scanner object used to read the librarian command lines
     */
    private void readProcessSubscriberCommand(Subscriber subscriber, Scanner scanner) {
        final String promptCommandLine = "ENTER COMMAND: ";
        displaySubscriberMenu();
        System.out.print(promptCommandLine);

        String command = scanner.nextLine(); // read user command line
        String[] commands = command.trim().split(" "); // split user command
        while (commands[0].trim().charAt(0) != '9') { // '9': Logout
            switch (commands[0].trim().charAt(0)) {
                case 1: // Check out book
                    subscriber.checkoutBook(findBook(Integer.parseInt(commands[1])));
                    break;

                case 2: // Return book
                    subscriber.returnBook(findBook(Integer.parseInt(commands[1])));
                    break;

                case 3: // Search a Book by title
                    displayBooks(findBookByTitle(commands[1]));
                    break;

                case 4: // Search a Book by author
                    displayBooks(findBookByAuthor(commands[1]));
                    break;

                case 5: // Print list of books checked out
                    subscriber.displayBooksCheckedOut();
                    break;

                case 6: // Print history of returned books
                    subscriber.displayHistoryBooksReturned();
                    break;

                case 7: // Update address
                    subscriber.setAddress(commands[1]);
                    break;

                case 8: // Update phone number
                    subscriber.setPhoneNumber(commands[1]);
                    break;

                case 9: // Logout
                    displayMainMenu();
                    continue;
            }

            // read and split next user command line
            displaySubscriberMenu(); // display the library management system librarian menu
            System.out.print(promptCommandLine);
            command = scanner.nextLine(); // read user command line
            commands = command.trim().split(" "); // split user command line
        }
    }



    /**
     * Displays a list of books
     *
     * @param books ArrayList of books
     */
    public static void displayBooks(ArrayList<Book> books) {
        // Traverse the list of books and display book id, title, author, and availability of each book
        for (int i = 0; i < books.size(); i++) {
            System.out.print("<Book ID>: " + books.get(i).getID() + " ");
            System.out.print("<Title>: " + books.get(i).getTitle() + " ");
            System.out.print("<Author>: " + books.get(i).getAuthor() + " ");
            System.out.println("<Is Available>: " + books.get(i).isAvailable());
        }
    }

    /**
     * Main method that represents the driver for this application
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a scanner object to read user inputs
        // create a new library object
        Library madisonLibrary = new Library("Madison, WI", "april", "abc");
        // read and process user command lines
        madisonLibrary.readProcessUserCommand(scanner);
        displayGoodByeLogoutMessage(); // display good bye message
        scanner.close();// close this scanner
    }

    /**
     * Displays the main menu for this book library application
     */
    private static void displayMainMenu() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("     Welcome to our Book Library Management System");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter one of the following options:");
        System.out.println("[1 <password>] Login as a librarian");
        System.out.println("[2 <card bar code> <4-digits pin>] Login as a Subscriber");
        System.out.println("[3] Exit"); // Exit the application
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Displays the menu for a Subscriber
     */
    private static void displaySubscriberMenu() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("    Welcome to Subscriber's Space");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter one of the following options:");
        System.out.println("[1 <book ID>] Check out a book");
        System.out.println("[2 <book ID>] Return a book");
        System.out.println("[3 <title>] Search a Book by title");
        System.out.println("[4 <author>] Search a Book by author");
        System.out.println("[5] Print list of books checked out");
        System.out.println("[6] Print history of returned books");
        System.out.println("[7 <address>] Update address");
        System.out.println("[8 <phone number>] Update phone number");
        System.out.println("[9] Logout");
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Displays the menu for the Librarian
     */
    private static void displayLibrarianMenu() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("    Welcome to Librarian's Space");
        System.out.println("--------------------------------------------------------");
        System.out.println("Enter one of the following options:");
        System.out.println("[1 <title> <author>] Add new Book");
        System.out.println("[2 <name> <pin> <address> <phone number>] Add new subscriber");
        System.out.println("[3 <card bar code> <book ID>] Check out a Book");
        System.out.println("[4 <card bar code> <book ID>] Return a Book for a subscriber");
        System.out.println("[5 <card bar code>] Display Personal Info of a Subscriber");
        System.out.println("[6 <card bar code>] Display Books Checked out by a Subscriber");
        System.out.println("[7] Display All Books");
        System.out.println("[8 <book ID>] Remove a Book");
        System.out.println("[9] Logout");
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Display the Application GoodBye and logout message.
     */
    private static void displayGoodByeLogoutMessage() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("       Thanks for Using our Book Library App!!!!");
        System.out.println("--------------------------------------------------------");
    }
}
