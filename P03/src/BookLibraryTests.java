//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P03 Book Library Tests
// Files: Library.java, Librarian.java, Subscriber.java, Book.java
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
 * Test that all the constructors in the book class are functioning correctly
 * @author Cecelia
 * @author Ryann
 */
public class BookLibraryTests {
  public static boolean testBookConstructorGetters() {
    boolean testPassed = true;
    Book Book1 = new Book("Ender's Game", "Orson Scott Card");
    Book Book2 = new Book("Cardinal of the Kremlin", "Tom Clancy");
    if (!Book1.getAuthor().equals("Orson Scott Card")) {
      testPassed = false;
      System.out.println("WARNING: Author of Book1 was not correctly assigned.");
    }
    if (!Book1.getTitle().equals("Ender's Game")) {
      testPassed = false;
      System.out.println("WARNING: Title of Book1 was not correctly assigned.");
    }
    if (!Book2.getAuthor().equals("Tom Clancy")) {
      testPassed = false;
      System.out.println("WARNING: Author of Book2 was not correctly assigned.");
    }
    if (!Book2.getTitle().equals("Cardinal of the Kremlin")) {
      testPassed = false;
      System.out.println("WARNING: Title of Book2 was not correctly assigned.");
    }
    if (!Book1.isAvailable()) {
      testPassed = false;
      System.out.println("WARNING: New book Book1 is not available.");
    }
    if (!Book2.isAvailable()) {
      testPassed = false;
      System.out.println("WARNING: New book Book2 is not available.");
    }
    if (Book1.getID() != 1) {
      testPassed = false;
      System.out.println("WARNING: Book1 should have ID 1.");
    }
    if (Book2.getID() != 2) {
      testPassed = false;
      System.out.println("WARNING: Book2 should have ID 2.");
    }
    return testPassed;
  }

  /**
   * test that returning a book resets the borrowerBarCode to null
   */
  public static boolean testBookReturnBook() {
    boolean testPassed = true;
    Book Book3 = new Book("Green Eggs and Ham", "Dr. Seuss");
    Book3.borrowBook(000000);
    if (Book3.isAvailable()) {
      testPassed = false;
      System.out.println("WARNING: Book3 should not be available.");
    }
    Book3.returnBook();
    if (!Book3.isAvailable()) {
      testPassed = false;
      System.out.println("WARNING: Book3 should be available.");
    }
    return testPassed;
  }

  /**
   * test that checking out a book functions correctly (adding to
   */
  public static boolean testSubscriberCheckoutBook() {
    boolean testPassed = true;
    Subscriber person1 = new Subscriber();
    Book Book4 = new Book("Crooked Kingdom", "Leigh Bardugo");
    person1.checkoutBook(Book4);
    person1.checkoutBook(Book4);
    if (Book4.isAvailable()) {
      System.out.println("WARNING: Book4 has not been marked unavailable.");
    }
    if (!person1.isBookInBooksCheckedOut(Book4)) {
      System.out.println("WARNING: Book4 was not added to booksCheckedOut.");
    }
    for (int i = 0; i < 11; i++) {
      person1.checkoutBook(new Book("Oh, The Places I'll Go", "Dr. Seuss"));
    }
    person1.displayBooksCheckedOut();
    return testPassed;
  }


  public static boolean testReturnBook() {
    boolean testPassed = true;
    Subscriber person2 = new Subscriber();
    Book Book5 = new Book("Another Day", "David Leviathan");
    Book Book6 = new Book("Divergent", "Veronica Roth");
    person2.checkoutBook(Book5);
    person2.returnBook(Book6);
    if (!person2.isBookInBooksCheckedOut(Book5)) {
      System.out.println("WARNING: Book5 was not added to booksCheckedOut.");
    }
    person2.returnBook(Book5);
    if (!person2.isBookInBooksReturned(Book5)) {
      System.out.println("WARNING: Book5 was not added to booksReturned.");
    }
    if (person2.isBookInBooksCheckedOut(Book5)) {
      System.out.println("WARNING: Book5 was not removed from booksCheckedOut.");
    }
    if (!Book5.isAvailable()) {
      System.out.println("WARNING: Book5 was not marked available.");
    }
    return testPassed;
  }

  public static boolean testGetterSetter() {
    boolean testPassed = true;
    Subscriber person3 =
        new Subscriber("Romeo Montague", "1 Montague Estate Verona, Italy", "0123456789", 1122);
    if (!person3.getAddress().equals("1 Montague Estate Verona, Italy")) {
      System.out.println("WARNING: person3's address not initialized correctly.");
      testPassed = false;
    }
    if (!person3.getCARD_BAR_CODE().equals(2019000003)) {
      System.out.println("WARNING: person3's barcode not initialized correctly.");
      testPassed = false;
    }
    if (!person3.getName().equals("Romeo Montague")) {
      System.out.println("WARNING: person3's name not initialized correctly.");
      testPassed = false;
    }
    if (!person3.getPhoneNumber().equals("0123456789")) {
      System.out.println("WARNING: person3's phone number not initialized correctly.");
      testPassed = false;
    }
    if (person3.getPin() != 1122) {
      System.out.println("WARNING: person3's pin not initialized correctly.");
      testPassed = false;
    }
    person3.setAddress("Montague Cemetery Verona, Italy");
    if (!person3.getAddress().equals("Montague Cemetery Verona, Italy")) {
      System.out.println("WARNING: person3's address was not changed correctly.");
      testPassed = false;
    }
    person3.setPhoneNumber("6666666666");
    if (!person3.getPhoneNumber().equals("6666666666")) {
      System.out.println("WARNING: person3's phone number was not changed correctly.");
      testPassed = false;
    }
    return testPassed;
  }
  
  public static boolean testLibrarian() {
    boolean testPassed = true;
    Librarian libr1 = new Librarian("Jekyll","Hyde");
    if(!libr1.getUsername().equals("Jekyll")) {
      System.out.println("WARNING: libr1's username was initialized incorrectly.");
      testPassed = false;
    }
    if(!libr1.checkPassword("Hyde")) {
      System.out.println("WARNING: libr1's password was initialized incorrectly.");
      testPassed = false;
    }
    if(libr1.checkPassword("password")) {
      System.out.println("WARNING: password was incorrectly identified.");
      testPassed = false;
    }
    return testPassed;
  }

  // driver class for tests
  public static void main(String args[]) {
    testBookConstructorGetters();
    testBookReturnBook();
    testSubscriberCheckoutBook();
    testReturnBook();
    testGetterSetter();
    testLibrarian();
  }
}
