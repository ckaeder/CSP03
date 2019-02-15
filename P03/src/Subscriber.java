//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Subscriber
// Files: Library.java, Librarian.java, Book.java, BookLibraryTests.java
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


/**
 * Subscriber models a subscriber on the Library app. Initializing essential variables and outlining
 * various actions that can or cannot be taken.
 * @author Cecelia
 * @author Ryann
 */
public class Subscriber {
  // static fields
  private final static int MAX_BOOKS_CHECKED_OUT = 10; // maximum number of books to be checked out
                                                       // one subscriber
  private static int nextCardBarCode = 2019000001; // class variable that represents the card bar
                                                   // code of the next subscriber to be created
  // Instance fields
  private int pin; // 4-digits Personal Identification Number to verify the identity of this
                   // subscriber
  private final Integer CARD_BAR_CODE; // card bar code of this subscriber

  private String name; // name of this subscriber
  private String address; // address of this subscriber
  private String phoneNumber; // phone number of this subscriber

  private ArrayList<Book> booksCheckedOut; // list of books checked out by this subscriber and not
                                           // yet
                                           // returned. A subscriber can have at most 10 checked out
                                           // books
  private ArrayList<Book> booksReturned; // list of the books returned by this subscriber

  /**
   * Initializes a Subscriber with no information in parameters
   */
  public Subscriber() {
    this.CARD_BAR_CODE = nextCardBarCode; //set next barcode
    nextCardBarCode++; //increment barcode
    this.booksCheckedOut = new ArrayList<Book>(1); //initialize ArrayLists
    this.booksReturned = new ArrayList<Book>(1);
  }

  /**
   * Initializes a Subscriber with given information
   * @param name
   * @param address
   * @param phoneNumber
   * @param pin
   */
  public Subscriber(String name, String address, String phoneNumber, int pin) {
    this(); //call unparameterized constructor to set variable basics
    this.name = name; //reassign variables to parameters
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.pin = pin;
  }

  /**
   * accessor method for bar code
   * @return CARD_BAR_CODE 
   */
  public Integer getCARD_BAR_CODE() {
    return CARD_BAR_CODE;
  }

  /**
   * accessor method for address
   * @return address 
   */
  public String getAddress() {
    return address;
  }
  
  /**
   * accessor method for name
   * @return name
   */
  public String getName() {
    return name;
  }
  
  /**
   * accessor method for phone number
   * @return phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }
  
  /**
   * accessor method for pin
   * @return pin
   */
  public int getPin() {
    return pin;
  }
  
  /**
   * setter method for address
   * @param newAddress
   */
  public void setAddress(String newAddress) {
    address = newAddress; //reassign address new value
  }
  
  /**
   * setter method for phone number
   * @param newPhoneNumber
   */
  public void setPhoneNumber(String newPhoneNumber) {
    phoneNumber = newPhoneNumber; //reassign phone number new value
  }
  
  /**
   * Checks if this subscriber booksCheckedOut list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksCheckedOut list
   * @return true if booksCheckedOut contains book, false otherwise
   */
  public boolean isBookInBooksCheckedOut(Book book) {
    return booksCheckedOut.contains(book);
  }

  /**
   * Checks if this subscriber booksReturned list contains a given book
   * 
   * @param book book to check if it is within this subscriber booksReturned list
   * @return true if booksReturned contains book, false otherwise
   */
  public boolean isBookInBooksReturned(Book book) {
    return booksReturned.contains(book);
  }

  
  /**
   * Displays the list of the books checked out and not yet returned
   */
  public void displayBooksCheckedOut() {
    if (booksCheckedOut.isEmpty()) // empty list
      System.out.println("No books checked out by this subscriber");
    else
      // Traverse the list of books checked out by this subscriber and display its content
      for (int i = 0; i < booksCheckedOut.size(); i++) {
        System.out.print("Book ID: " + booksCheckedOut.get(i).getID() + " ");
        System.out.print("Title: " + booksCheckedOut.get(i).getTitle() + " ");
        System.out.println("Author: " + booksCheckedOut.get(i).getAuthor());
      }
  }

  /**
   * Displays the history of the returned books by this subscriber
   */
  public void displayHistoryBooksReturned() {
    if (booksReturned.isEmpty()) // empty list
      System.out.println("No books returned by this subscriber");
    else
      // Traverse the list of borrowed books already returned by this subscriber and display its
      // content
      for (int i = 0; i < booksReturned.size(); i++) {
        System.out.print("Book ID: " + booksReturned.get(i).getID() + " ");
        System.out.print("Title: " + booksReturned.get(i).getTitle() + " ");
        System.out.println("Author: " + booksReturned.get(i).getAuthor());
      }
  }

  /**
   * Displays this subscriber's personal information
   */
  public void displayPersonalInfo() {
    System.out.println("Personal information of the subscriber: " + CARD_BAR_CODE);
    System.out.println("  Name: " + name); 
    System.out.println("  Address: " + address);
    System.out.println("  Phone number: " + phoneNumber);
  }
  
  /**
   * Determine if checking out book is possible (under max size, not already checked out, book is 
   * available). If possible, check book out (set not available and add to booksCheckedOut list).
   * @param book
   */
  public void checkoutBook(Book book) {
    if(booksCheckedOut.size() >= MAX_BOOKS_CHECKED_OUT) { //warning when checked out >= max limit
    System.out.println("Checkout Failed: You cannot check out more than "
        + MAX_BOOKS_CHECKED_OUT + " books.");
    }
    else if(booksCheckedOut!=null && booksCheckedOut.contains(book)) { //warning when checked out
    System.out.println("You have already checked out " + book.getTitle() + " book");// by you
    }
    else if(!book.isAvailable()) {
    System.out.println("Sorry, " + book.getTitle() + " is not available."); //warning when 
    }                                                                       //unavailable
    else { //assign barcode to book and add to checked out list
      book.borrowBook(CARD_BAR_CODE);
      booksCheckedOut.add(book);
    }
  }

  /**
   * Determine if returning book is possible (checked out by this person). If possible, return book
   * (set available, remove from booksCheckedOut list, and add to booksReturned list).
   * @param book
   */
  public void returnBook(Book book) {
    if(!isBookInBooksCheckedOut(book)) {
      System.out.println("WARNING: You have not checked out " + book.getTitle() + " book");
    }
    else{
      book.borrowBook(null); //reset barcode to 0
      booksReturned.add(book); //add book to return history
      booksCheckedOut.remove(book); //remove book from checked out list
    }
      
  }
}
