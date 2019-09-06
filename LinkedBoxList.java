//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Storage Unit
// Files: LinkedBoxNode.java, Box.java, LinkedBoxList.java, StorageUnitTests.java
// Course: CS 300, Spring 2019
//
// Author: Aarushi Gupta
// Email: gupta232@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
// This class models a dynamic list to store box objects sorted in a
// descending order with respect to their weights
// the head of the list must refer to the heaviest box stored within the list
public class LinkedBoxList {

  // head of this LinkedBoxList (refers to the element
  // stored at index 0 within this list)
  private LinkedBoxNode head;

  // number of boxes already stored in this list
  private int size = 0;

  // capacity of this LinkedBoxList
  // maximum number of box elements that this LinkedBoxList can store
  private int capacity;

  // Creates an empty LinkedBoxList with a given initial capacity
  public LinkedBoxList(int capacity) {
    this.capacity = capacity;
  }

  // Returns the size of this list
  public int size() {
    return this.size;
  }

  // Return the capacity of this list
  public int getCapacity() {
    return this.capacity;
  }

  // Expands the capacity of this LinkedBoxList with the specified number a of
  // additional elements
  public void expandCapacity(int a) {
    this.capacity += a;
  }

  // Checks whether this LinkedBoxList is empty
  // returns true if this LinkedBoxList is empty, false otherwise
  public boolean isEmpty() {
    if (this.head == null) {
      return true;
    }
    return false;

  }

  // Checks whether this LinkedBoxList is full
  // Returns true if this list is full, false otherwise
  public boolean isFull() {
    if (this.size == this.capacity) {
      return true;
    }
    return false;
  }

  /**
   * Adds a new box into this sorted list
   * Throws IllegalArgumentException if newBox is null
   * Throws IllegalStateException if this list is full
   * 
   * @param box to be added
   * @return void
   */
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException {
    if (newBox == null) {
      // displays error message if the box is null and the exception is thrown
      throw new IllegalArgumentException("Error in input");
    }
    if (isFull()) { //isFull() method checks if the list if the list is full
      //displays error message if the list is full and the exception is thrown
      throw new IllegalStateException("Maximum limit for the capacity reached");
    }
    // if size of list 0 i.e its empty, then it sets the newBox as the head
    if (size == 0) {
      head = new LinkedBoxNode(newBox);
    } else {
      //checks if newBox's weight is greater than the box pointed by head node
      if (newBox.compareTo(head.getBox()) > 0) {
        LinkedBoxNode tempNode1 = new LinkedBoxNode(newBox, head);
        head = tempNode1;  //assigns head with the newBox
        
      //goes to next condition if the newBox's weight is lighter than the box pointed by head node
      } else {
        LinkedBoxNode tempNode2 = head; // a temporary variable which stores values
                                        //of next element in the list
        for (int i = 0; i < size; i++) { //the loop iterates through all the boxes stored i.e size
          // if condition checks if the weight of newBox is less than the current
          // linkedBoxNode's box stored in tempNode2
          if (newBox.compareTo(tempNode2.getBox()) <= 0) {
            // checks for .getNext() null condition so that the comparison
            //is not happening at the last element as it would point to null
            if (tempNode2.getNext() != null) {
              // if the next element of the tempNode2 is not null, it compares weight
              if (newBox.getWeight() > tempNode2.getNext().getBox().getWeight()) {
                LinkedBoxNode tempNode3 = new LinkedBoxNode(newBox, tempNode2.getNext());
                tempNode2.setNext(tempNode3);
                break;
              }
            }
            if (tempNode2.getNext() == null) {
              LinkedBoxNode tempNode4 = new LinkedBoxNode(newBox);
              tempNode2.setNext(tempNode4);
              break;
            }
          }
          tempNode2 = tempNode2.getNext();
        }
      }
    }
    size++; //increases the number of boxes stored in list
  }

  
  /**
   * Checks if this list contains a box that matches with (equals) a specific box
   * object, returns true if this list contains findBox, false otherwise
   * 
   * @param box to be searched
   * @return boolean
   */
  public boolean contains(Box findBox) {
    if (findBox.equals(head.getBox())) { //checks if the findBox is equal to box pointed by head
      return true; //returns true if it is equal
    }
    LinkedBoxNode tempNode1 = head.getNext(); //temporarily stores the node pointed by head's next
    for (int i = 1; i <= size - 1; i++) { //Iterates through the entire list to check other boxes 
      if (tempNode1.getBox().equals(findBox))
        return true; //returns true if the box is equal
      tempNode1 = tempNode1.getNext(); 
      //if not then tempNode1 is used to store reference to next node
    }
    return false;
  }

  /**
   * Returns a box stored in this list given its index
   * Throws IndexOutOfBoundsException if index is out of the range 0..size-1
   * 
   * @param int index of the required box
   * @return Box
   */
  public Box get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > size - 1) { //throws an exception if the index is out of bounds
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) { //returns the box stored by head node
      return head.getBox();
    }
    LinkedBoxNode temp = head.getNext();
    if (index == 1) {
      return temp.getBox();
    }
    for (int i = 2; i <= index; i++) { //iterates through the list to get the box at desired index
      temp = temp.getNext();
    }
    return temp.getBox();
  }

  /**
   * Removes a returns the box stored at index from this LinkedBoxList
   * Throws IndexOutOfBoundsException if index is out of bounds. index should be in
   *  the range of [0.. size()-1]
   * 
   * @param int index
   * @return Box
   */ 
  public Box remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > size - 1) {
      System.out.println("Input out of bound");//throws an exception if the index is out of bounds
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      //removes the head node
      LinkedBoxNode tempNode1 = head; 
      head = head.getNext(); //refers to the node stored after head
      size--; //after removing decreases the size
      return tempNode1.getBox();
    }
    // temporary LinkedBoxNode to store the node
    LinkedBoxNode tempNode2 = head.getNext();
    if (index == 1) {
      // if index is 1, head points to the third node
      // and second node is stored in tempNode2
      // and then returned to the calling method
      head.setNext(tempNode2.getNext());
      size--; //decreases the size
      return tempNode2.getBox(); //retruns the box
    }
    for (int i = 2; i <= index - 1; i++) {
      // loop finds node which is one before the index element
      // and stores it in tempNode2
      tempNode2 = tempNode2.getNext();
    }
    // tempNode2 following node is the one which is the one at the
    // index to be removed
    LinkedBoxNode BoxReturned = tempNode2.getNext();
    // once the returned element is stored, it is skipped and
    // preceeding node points to the later node
    tempNode2.setNext(tempNode2.getNext().getNext());
    size--;
    return BoxReturned.getBox();
  }


  /**
   * Removes all the boxes from this list
   * 
   * @param 
   * @return void
   */ 
  // 
  public void clear() {
    head = null;
    size = 0;
  }

  /**
   * Returns a String representation for this LinkedBoxList
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();
  }
}
