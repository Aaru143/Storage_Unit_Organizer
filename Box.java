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
import java.util.Random;

public class Box implements Comparable<Box>{
  
//generator of random numbers
  private static Random randGen = new Random(); 
  
//color of this box
  private int color;
  
//weight of this box in lbs between 1 inclusive and 31 exclusive
  private int weight; 

  /**
   * Creates a new Box and initializes its instance fields color and weight to 
   * random values 
   * the instance field color can be any integer but 
   * weight must be between 1(inclusive) - 31(exclusive)
   * 
   * @param 
   * @return void
   */  
public Box() {
  this.color = randGen.nextInt(); //assigns a random color
  this.weight = randGen.nextInt(30) + 1; //assigns a random weight between 1 and 31 (exclusive)
}
 
/**
 * Creates a new Box and initializes its instance fields color and weight to the
 * specified values
 * Throws IllegalArgumentException if the provided weight value is out of the 
 * range of [1..30]
 * 
 * @param int color, int weight
 * @return void
 */
public Box(int color, int weight) {
  this.color = color;
  this.weight = weight;
  if((weight<1) || (weight>30)) { //gives an error if the weight is not between 1 and 30
    throw new IllegalArgumentException("weight value is out of the range of [1..30]");
  }
}

@Override
/**
 * equals method defined in Object class
 * 
 * @param Object other
 * @return boolean
 */
public boolean equals(Object other) { 
  if(other.getClass() == Box.class) { //checks the class
    if(((Box) other).getColor() == this.color && ((Box) other).getWeight() == this.weight) {
     return true; //compares the color and weight of the boxes
    }
    else
      return false;
  }
    return false;
} 
 
@Override
/**
 * compares the weight of two boxes
 * (compareTo method defined in Comparable<Box> interface)
 * 
 * @param Box otherBox
 * @return int
 */
public int compareTo(Box otherBox) {
  int otherBoxWeight = otherBox.getWeight(); //gets the weight of the other box
  int thisBoxWeight = this.getWeight(); //gets the weight of this box
  
  if(otherBoxWeight > thisBoxWeight) { //if the weight of the other box is greater
                       //than this box then returns negative integer
    return -1 * Math.abs(randGen.nextInt());
  }
  else
  if(otherBoxWeight < thisBoxWeight) {
    return Math.abs(randGen.nextInt());//if the weight of the other box is lesser
    //than this box then returns positive integer
  }
  else
  return 0; // if the weight of both the boxes is equal then returns 0
} 
 
/**
 * Getter for the instance field color of this box
 * 
 * @param 
 * @return color
 */
public int getColor() {
  return this.color;
} 

/**
 * Getter for the instance field weight of this box
 * 
 * @param 
 * @return weight
 */
public int getWeight() { 
  return this.weight;
} 

}
