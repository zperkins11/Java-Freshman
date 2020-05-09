package test.linkedlist;

// Imports
// JUnit
// General
import linkedlist.LinkedList;
import linkedlist.Student;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.ArrayList;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinkedListTest {
	
	/* -------------------------------------------------------------
	 * 							Setup 
	 * -------------------------------------------------------------
	 */
	final int n_students = 10;
	LinkedList<Student> L;
	List<Student> students;
	
	/*
	 * Method for generating objects used during the test
	 */
    @Before
    public void setUp() throws Exception {
    	// Create an empty list of integers
    	L = new LinkedList<Student>();
    	
    	// Create some students
    	students = new ArrayList<Student>();
    	for(int i = 0; i < n_students; i++) {
    		students.add(new Student(i, "s" + i));
    	}
    }
    
    /*
     * Method for printing Students
     */
    public static String printStudent(Student s) {
    	return "{" + s.getId() + ", " + s.getName() + "}";
    }
    
    /*
     * Methods for printing expected verses received output
     */
    public static String expectedOutput(Student exp, Student rec) {
    	String exp_string = "null";
    	String rec_string = "null";
    	if (exp != null) {
    		exp_string = printStudent(exp);
    	}
    	if (rec != null) {
    		rec_string = printStudent(rec);
    	}
    	return expectedOutput(exp_string, rec_string);
    }
    
    public static String expectedOutput(int exp, int rec) {
    	return expectedOutput(Integer.toString(exp), Integer.toString(rec));
    }
    
    public static String expectedOutput(String exp, String rec) {
    	return "Expected: " + exp + " but received " + rec;
    }

    
    
    
		
	/* -------------------------------------------------------------
	 * 			getSize() and getElement() after add() Tests
	 * -------------------------------------------------------------
	 */
	
    
	@Test
	public void addEmptyList() {	
		// Add a single element
		assert(L.add(students.get(0))) : "add() method should return true";
		
		// Assert the size of the linked list is non-zero
		assert(L.getSize() == 1) : expectedOutput(1, L.getSize());
	}
	
	
	@Test
	public void addNonEmptyList() {
		// Create an empty list of integers
		LinkedList<Integer> L = new LinkedList<Integer>();
		
		// Add integers 0 through 9 to the list
		for(int i = 0; i < 10; i ++) {
			L.add(i);
			assert(L.getSize() == i+1) : expectedOutput(i+1, L.getSize());
		}
	}
	

	@Test
	public void getElementEmptyList() {
		assert(L.getElement(0) == null);
	}
	
	
	@Test
	public void getElementSingletonList() {	
		Student expected = students.get(0);
		
		// Add a single element
		L.add(expected);
		
		// Assert the only element in the list is the Student s
		Student received = L.getElement(0);
		assert(expected.equals(received)) : expectedOutput(expected, received);
		
		// Verify there are no other elements in the list
		assert(L.getElement(1) == null);
	}
	


	
	
	
	/* -------------------------------------------------------------
	 * 			size() and getElement() after delete() Tests
	 * -------------------------------------------------------------
	 */
	
	@Test
	public void deleteEmptyList() {
		assert(!L.delete(0)) : "delete should return false when no element is removed";
	}
	
	
	@Test
	public void deleteSingletonList() {
		Student s = students.get(3);
		// Add the student to the list
		L.add(s);
		
		// Remove it
		assert(L.delete(0)) : "expected True but received false";
		
		// Make sure it's still not in the list
		assert(L.getSize() == 0) : expectedOutput(0, L.getSize());
		for(int i = 0; i < L.getSize(); i++) {
			assert(L.getElement(i) != s);
		}
	}
	
	
	@Test
	public void deleteMultiElementListFront() {
		Student s0 = students.get(2);
		Student s1 = students.get(4);
		Student s2 = students.get(6);
		
		// Add the students to the list
		L.add(s0);
		L.add(s1);
		L.add(s2);
		
		// Delete s0 from the list
		assert(L.delete(0)) : "expected true but was false";
		
		// Verify the size of the list
		assert(L.getSize() == 2) : expectedOutput(2, L.getSize());
		
		// Verify the order of the elements in the list
		Student rec0 = L.getElement(0);
		assert(s1.equals(rec0)) : expectedOutput(s1, rec0);
		
		Student rec1 = L.getElement(1);
		assert(s2.equals(rec1)) : expectedOutput(s2, rec1);
	}
	
	
	@Test
	public void deleteMultiElementListEnd() {
		Student s0 = students.get(2);
		Student s1 = students.get(4);
		Student s2 = students.get(6);
		
		// Add the students to the list
		L.add(s0);
		L.add(s1);
		L.add(s2);
		
		// Delete s2 from the list
		assert(L.delete(2)) : "expected true but was false";
		
		// Verify the size of the list
		assert(L.getSize() == 2) : expectedOutput(2, L.getSize());
		
		// Verify the order of the elements in the list
		Student rec0 = L.getElement(0);
		assert(s0.equals(rec0)) : expectedOutput(s0, rec0);
		
		Student rec1 = L.getElement(1);
		assert(s1.equals(rec1)) : expectedOutput(s1, rec1);
	}
	
	
	
	/* -------------------------------------------------------------
	 * 			size() and getElement() after insert() Tests
	 * -------------------------------------------------------------
	 */
	
	@Test
	public void insertEmptyListIndexEquals0() {
		Student exp = students.get(7);
		
		// Insert a single element into the list
		L.insert(0, exp);
		
		// Verify the size increases
		assert(L.getSize() == 1) : expectedOutput(1, L.getSize());
		
		// Verify the element was added correctly
		Student rec = L.getElement(0);
		assert(exp.equals(rec)) : expectedOutput(exp, rec);
	}
	
	
	@Test
	public void insertEmptyListIndexTooLarge() {
		Student exp = students.get(7);
		
		// Insert a single element into the list
		assert(!L.insert(15, exp)) : "insert should return false when index is too large";
		
		// Verify the size increases
		assert(L.getSize() == 0) : expectedOutput(0, L.getSize());
		
		// Verify the element is not in the list
		Student rec = L.getElement(0);
		assert(rec == null);
	}
	
	
	@Test 
	public void insertSingletonListIndexTooLarge() {
		Student exp = students.get(8);
		
		// Insert an element in L
		L.add(students.get(4));
		
		// Try to insert at index 100
		assert(!L.insert(100, exp)) : "insert should return false when index is too large";
			
		// Verify the size of the list
		assert(L.getSize() == 1) : expectedOutput(1, L.getSize());
		
		// Verify the element wasnt added to the list
		for(int i = 0; i < L.getSize(); i++) {
			assert(!exp.equals(L.getElement(i))) : "found element that shouldnt be in the list!";
		}
	}
	
	
	@Test 
	public void insertSingletonListAtEnd() {
		Student exp0 = students.get(3);
		Student exp1 = students.get(5);
		
		// Add an element into the list
		L.add(exp0);
		
		// Insert at the front
		L.insert(1, exp1);
		
		// Verify the order of the list
		Student rec0 = L.getElement(0);
		assert(exp0.equals(rec0)) : expectedOutput(exp0, rec0);
		
		Student rec1 = L.getElement(1);
		assert(exp1.equals(rec1)) : expectedOutput(exp1, rec1);
	}
	
	
	
	@Test 
	public void insertMiddleMultiElementList() {
		Student s0 = students.get(3);
		Student s1 = students.get(5);
		Student s2 = students.get(7);
		
		// Add two elements into the list
		L.add(s0);
		L.add(s1);
		
		// Insert s2 in between s0 and s1
		L.insert(1, s2);
		
		// Verify the order of the list
		Student rec0 = L.getElement(0);
		assert(s0.equals(rec0)) : expectedOutput(s0, rec0);
		
		Student rec1 = L.getElement(1);
		assert(s2.equals(rec1)) : expectedOutput(s2, rec1);
		
		Student rec2 = L.getElement(2);
		assert(s1.equals(rec2)) : expectedOutput(s1, rec2);
	}
	

	
	/* -------------------------------------------------------------
	 * 						search() Tests
	 * -------------------------------------------------------------
	 */
	@Test
	public void searchEmptyList() {
		Student s = students.get(5);
		int i = L.search(s);
		assert(i == -1) : expectedOutput(-1, i);
	}
	
	
	@Test
	public void searchSingletonListWithElement() {
		Student s = students.get(5);
		
		// Add the element to the list
		L.add(s);
		
		// Search for the element in the list
		int i = L.search(s);
		assert(i == 0) : expectedOutput(0, i);
	}
	
	@Test
	public void searchSingletonListWithoutElement() {
		Student s1 = students.get(5);
		Student s2 = students.get(8);
		
		// Add the element to the list
		L.add(s1);
		
		// Search for the element in the list
		int i = L.search(s2);
		assert(i == -1) : expectedOutput(-1, i);
	}

	
	@Test
	public void searchMultipleCopies() {
		Student s1 = students.get(5);
		Student s2 = students.get(8);
		Student s3 = students.get(3);
		
		// Add some students to the list including multiple duplicates
		L.add(s1);
		L.add(s2);
		L.add(s1);
		L.add(s3);
		L.add(s3);
		L.add(s2);

		// Search for each student and ensure we find the right index
		int i1 = L.search(s1);
		assert(i1 == 0) : expectedOutput(0, i1);
		
		int i2 = L.search(s2);
		assert(i2 == 1) : expectedOutput(1, i2);
		
		int i3 = L.search(s3);
		assert(i3 == 3) : expectedOutput(3, i3);
	}	
	
	
	
	/* -------------------------------------------------------------
	 * 					mixed Tests
	 * -------------------------------------------------------------
	 */

	@Test
	public void mixedDeleteLastThenAdd() {
		Student s0 = students.get(2);
		Student s1 = students.get(4);
		Student s2 = students.get(6);
		Student s3 = students.get(9);
		
		// Add the students to the list
		L.add(s0);
		L.add(s1);
		L.add(s2);
		
		// Delete s2 from the list
		L.delete(2);
		
		// Add s3 to the end of the list
		assert(L.add(s3)) : "expected true but was false";
		
		// Verify the size of the list
		
		// Verify the order of the elements in the list
		Student rec0 = L.getElement(0);
		assert(s0.equals(rec0)) : expectedOutput(s0, rec0);
		
		Student rec1 = L.getElement(1);
		assert(s1.equals(rec1)) : expectedOutput(s1, rec1);
		
		Student rec2 = L.getElement(2);
		assert(s3.equals(rec2)) : expectedOutput(s3, rec2);
	}
	
	
	@Test
	public void mixedDeleteLastThenInsertEnd() {
		Student s0 = students.get(2);
		Student s1 = students.get(4);
		Student s2 = students.get(6);
		Student s3 = students.get(9);
		
		// Add the students to the list
		L.add(s0);
		L.add(s1);
		L.add(s2);
		
		// Delete s2 from the list
		L.delete(2);
		
		// Add s3 to the end of the list
		assert(L.insert(2, s3)) : "expected true but was false";
		
		// Verify the size of the list
		
		// Verify the order of the elements in the list
		Student rec0 = L.getElement(0);
		assert(s0.equals(rec0)) : expectedOutput(s0, rec0);
		
		Student rec1 = L.getElement(1);
		assert(s1.equals(rec1)) : expectedOutput(s1, rec1);
		
		Student rec2 = L.getElement(2);
		assert(s3.equals(rec2)) : expectedOutput(s3, rec2);
	}

	
	@Test
	public void mixedSearchDeleteSearch() {
		Student s0 = students.get(2);
		Student s1 = students.get(4);
		Student s2 = students.get(6);
		
		// Add the students to the list
		L.add(s0);
		L.add(s1);
		L.add(s2);
		
		// Search for s1
		assert(L.search(s1) == 1) : expectedOutput(1, L.search(s1));
		
		// Delete s1 from the list
		L.delete(1);
		
		// Search for s1 again and find nothing
		assert(L.search(s1) == -1) : expectedOutput(-1, L.search(s1));
	}
}