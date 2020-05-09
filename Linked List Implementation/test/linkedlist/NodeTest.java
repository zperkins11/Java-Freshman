package test.linkedlist;
import linkedlist.Node;
import linkedlist.Student;
import org.junit.Test;


public class NodeTest {
	
	@Test
	public void testSetNextandGetNext() {
		// Create two students
		Student s1 = new Student(1, "a");
		Student s2 = new Student(2, "b");
		
		// Create two nodes
		Node<Student> n1 = new Node<Student>(s1);
		Node<Student> n2 = new Node<Student>(s2);
		
		// Make the link n1 -> n2 in n1
		n1.setNext(n2);
		
		// Verify the link is created in n1
		assert(n1.getNext().equals(n2));

	}
	
	@Test
	public void testSetPreviousandGetPrevious() {
		Student s1 = new Student(1, "a");
		Student s2 = new Student(2, "b");
		
		Node<Student> n1 = new Node<Student>(s1);
		Node<Student> n2 = new Node<Student>(s2);
		
		// make the link n1 -> n2 in n2
		n2.setPrevious(n1);
		assert(n2.getPrevious().equals(n1));
	}
	
	
	
	

}
