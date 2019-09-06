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
public class LinkedBoxNode {
  private Box box; // box that represents the data for this Linked node
  private LinkedBoxNode next; // reference to the next Linked Box Node
   
  /**
   * Constructors
   * creates a new LinkedBoxNode object with a given
   * box and without referring to any next LinkedBoxNode
   * 
   * @param Box box
   * @return void
   */
  public LinkedBoxNode(Box box) {
    this.box = box;
  } 
  
  /**
   * creates a new LinkedBoxNode 
   * object and sets its instance fields box and next to the specified ones
   * 
   * @param Box box, LinkedBoxNode next
   * @return void
   */
  public LinkedBoxNode(Box box, LinkedBoxNode next){
   this.box = box;
   this.next = next;
  } 
   
  // getters and setters methods
  public LinkedBoxNode getNext() {
    return next;
  } 
  
  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }
  
  public Box getBox() {
    return box;
  }
  
  public void setBox(Box box) {
    this.box = box;
  }
}
