//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Book
// Files: Library.java, Librarian.java, Subscriber.java, BookLibraryTests.java
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

/**
 * Book initializes an object book and gives it identifying information and actions
 * @author Cecelia
 * @author Ryann
 */
public class Book {
  // class/static fields
  private static int nextId = 1; // class variable that represents the identifier of the next
                                 // book
  // Instance fields
  private final int ID; // unique identifier of this book
  private String author; // name of the author of this book
  private String title; // title of this book
  private Integer borrowerCardBarCode; // card bar code of the borrower of this book
                                       // When borrowerCardBarCode == null, the book is available
                                       // (no one has the book)

  /**
   * Book constructs a book and initializes id to next id. 
   * All other data to be null
   */
  public Book() {
    author = null;
    title = null;
    borrowerCardBarCode = null;
    ID = nextId;
    nextId++;
  }

  /**
   * Book(title, author) constructs a book and initializes id to next id 
   * Title and author are initialized to that of the parameters
   * @param title of the book
   * @param author of the book
   */
  public Book(String title, String author) {
    this.author = author;
    this.title = title;
    borrowerCardBarCode = null;
    ID = nextId;
    nextId++;
  }

  /**
   * borrowBook changes the borrowerBarCode from null to the identifier of a subscriber's account
   * to show that the book is no longer available
   * @param borrowerCardBarCode identifies borrower from library database 
   */
  public void borrowBook(Integer borrowerCardBarCode) {
    this.borrowerCardBarCode = borrowerCardBarCode;
  }

  /**
   * getAuthor returns the name of the author of the book
   * @return author of the book
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * getID returns the unique id of the book
   * @return id of the book
   */
  public int getID() {
    return this.ID;
  }

  /**
   * getTitle returns the title of the book / accessor method
   * @return title of the book
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * isAvailable returns the status of availability of the book, dependent on borrowerBarCode
   * @return available the availability of the book
   */
  public boolean isAvailable() {
    boolean available = false;
    if (this.borrowerCardBarCode == null) {
      available = true;
    }
    return available;
  }

  /**
   * returnBook sets the variable borrowerBarCode to null and therefore availability to true
   */
  public void returnBook() {
    this.borrowerCardBarCode = null;
  }

}
