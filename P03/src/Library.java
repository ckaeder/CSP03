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

/**
 * Library is an app that models a Library, its resources and functions. Allowing for adding books,
 * subscribers and librarians.
 * 
 * @author Cecelia
 * @author Ryann
 */
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
    this.books = new ArrayList<Book>(1);
    this.subscribers = new ArrayList<Subscriber>(1);
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
   * Displays a list of books
   * 
   * @param books ArrayList of books
   */
  public void addBook(String title, String author) {

  }


  public void addSubscriber(String name, int pin, String address, String phoneNumber) {

  }


  public Book findBook(Book books) {
    return books;
  }


  public ArrayList<Book> findBookByAuthor(String Author){
    ArrayList booksByAuthor = new ArrayList<Book>(1);
    return booksByAuthor;
  }


  public ArrayList<Book> findBookByTitle(String title){
    ArrayList booksByTitle = new ArrayList<Book>(1);
    return booksByTitle;
  }
  
  
  public Subscriber findSubscriber(int cardBarCode) {
    //return Subscriber
  }
  
  
  public String getAddress() {
    return address;
  }
  
  
  public Librarian getLibrarian() {
    return librarian;
  }
  
  
  public static void main(String args[]) {
    
  }
  
  
  public void readProcessLibrarianCommand(Scanner kbr) {
    
  }
  
  
  public void readProcessUserCommand(Scanner kbr) {
    
  }
  
  
  public Book removeBook(int bookId){
    //return Book
  }
}
