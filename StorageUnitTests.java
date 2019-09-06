
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

public class StorageUnitTests {
  static LinkedBoxList linkedList = new LinkedBoxList(30);// new linked list of capacity 30
  static Random randGen = new Random(); 
  
  /**
   * Checks whether the behavior of equals method is correct
   * 
   * @param 
   * @return boolean
   */
public static boolean testBoxEquals(){
	boolean TestPassed = false;
	Box box1 = new Box(1442583041, 20); //the weight of the boxes is not equal
	Box box2 = new Box(1442583041, 25);
	boolean BoxEquals = box1.equals(box2);
	if(BoxEquals == false) {
		TestPassed = true;
	}
	return TestPassed;
  }

/**
 * Checks whether the behavior of compareTo method is correctly implemented
 * 
 * @param 
 * @return boolean
 */
public static boolean testBoxCompareTo(){
	boolean TestPassed = false;
	Box box1 = new Box(1442583041, 20); //weight of box2 is greater than box1
	Box box2 = new Box(1442583041, 25);
	int CompareTo = box1.compareTo(box2);
	if (CompareTo < 0) { //since weight of box2 is greater than box1 so the int should be negative
		TestPassed = true;
	}
	else
		TestPassed = false;
  return TestPassed; 
}


/**
 * Checks whether remove method defined in your LinkedBoxList works correctly
 * 
 * @param 
 * @return boolean
 */
public static boolean testLinkedBoxListRemove() {
//removing any box with index 3
  Box box1 = new Box(1442583041, 20); //adds four boxes to the list
  Box box2 = new Box(1442583041, 10);
  Box box3 = new Box(1442583041, 5);
  Box box4 = new Box(1442583041, 15);
  
  linkedList.add(box1);
  linkedList.add(box2);
  linkedList.add(box3);
  linkedList.add(box4);
  Box box5 = linkedList.get(3);
  Box box6 = linkedList.remove(3); 
  if (box5.equals(box6)) //checks if the box removed form index 3 equal to the
    //box stored at index 3
    return true;
  else
    return false;
}

/**
 * Checks whether the behavior of add method is correct add boxes to LinkedBoxList till full
 * capacity
 * 
 * @param 
 * @return boolean
 * 
 */
public static boolean testLinkedBoxAdd() {
  Box newbox;
  while (!linkedList.isFull()) {
    newbox = new Box(randGen.nextInt(100), randGen.nextInt(30) + 1);
    linkedList.add(newbox);
  }
  // returns true if expected value matches with actual value
  if (linkedList.size() == linkedList.getCapacity())
    return true;
  else
    return false;
}

/**
 * checks whether clear method defined in LinkedBoxList works correctly
 * 
 * @param 
 * @return boolean
 * 
 */
public static boolean testLinkedBoxListClear() {
  linkedList.clear();
  // returns true if actual result equals to expected result
  if (linkedList.size() == 0)
    return true;
  else
    return false;
}

/**
 * checks whether expandCapacity method in LinkedList works correctly
 * 
 * @param 
 * @return boolean
 * 
 */
public static boolean testLinkedBoxListExpandCapacity() {
  // add newCapacity 40 into old capacity
  int newCapacity = 40;
  int oldCapacity = linkedList.getCapacity();
  linkedList.expandCapacity(newCapacity);
  // returns true if actual result equals to expected result
  if (linkedList.getCapacity() == newCapacity + oldCapacity)
    return true;
  else
    return false;
}

public static void main(String[] args) {
System.out.println("The value of TestPassed after calling testBoxEquals: " + testBoxEquals());
System.out.println("The value of TestPassed after calling testBoxCompareTo: " + testBoxCompareTo());
System.out.println("The value of TestPassed after calling "
    + "testLinkedBoxListRemove: " + testLinkedBoxListRemove());
System.out.println("The value of TestPassed after calling "
    + "testLinkedBoxAdd: " + testLinkedBoxAdd());
System.out.println("The value of TestPassed after calling "
    + "testLinkedBoxListClear: " + testLinkedBoxListClear());
System.out.println("The value of TestPassed after "
    + "calling testLinkedBoxListExpandCapacity: " + testLinkedBoxListExpandCapacity());


} 

}
