//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Librarian
// Files: Library.java, Book.java, Subscriber.java, BookLibraryTests.java
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
 * Librarian models a Librarian on the Library app. Initializing essential variables and outlining
 * various actions that can or cannot be taken.
 * @author Cecelia
 * @author Ryann
 */
public class Librarian {
  // instance fields
  private String username; // librarian's username
  private String password; // librarian password to have access to this application

  /*
   * Librarian constructor creates a Librarian with assigned name and password
   */
  public Librarian(String username, String password) { // set username and password
    this.username = username;
    this.password = password;
  }

  /**
   * checkPassword determines if input is the equivalence of the password assigned at construction
   * @param password input from driver class
   * @return key true if password matches input, false otherwise
   */
  public boolean checkPassword(String password) {
    boolean key = false;
    if (this.password.equals(password)) { // check that input equals password
      key = true;
    }
    return key;
  }
  /**
   * Getter method for username
   * @return username of the librarian requested
   */
  public String getUsername() {
    return username;
  }

}
