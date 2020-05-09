package linkedlist;

import java.util.Arrays;
import java.util.Objects;

public class LinkedList<E> {
	
	/* ------------------------------------------------------------------
	 * 				Instance Variables and Constructor
	 * ------------------------------------------------------------------
	 */
	
	// TODO: add instance variables
	private int size;
	private Node<E> first;
	private Node<E> last;
	
	public LinkedList() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}
	
	/* ------------------------------------------------------------------
	 * 							Gets and Setters
	 * ------------------------------------------------------------------
	 */

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node<E> getFirst() {
		return first;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	public Node<E> getLast() {
		return last;
	}

	public void setLast(Node<E> last) {
		this.last = last;
	}

	/* ------------------------------------------------------------------
	 * 						Instance Methods
	 * ------------------------------------------------------------------
	 */
	
	
	/* add(e) method
	 * Adds an element at the end of the list and returns true
	 */
	public boolean add(E object) {
		Node<E> newNode = new Node<>(object);
		if (this.getFirst() != null) {
			this.getLast().setNext(newNode);
			newNode.setPrevious(this.getLast());
		}
		else {
			this.setFirst(newNode);
		}
		this.setLast(newNode);
		this.size++;
		return true;
	}
	
	
	/* getElement(i) method
	 * Returns the data (not the node) at position i. 
	 * If there is no such position, returns null. 
	 * Indexing/positions start at 0.
	 */
	public E getElement(int index) {
		Node<E> currentNode = this.getFirst();
		if (index >= 0 && index < this.getSize()) {
			for (int i = 0; index != i; i++) {
				currentNode = currentNode.getNext();
			}
			return currentNode.getData();
		}
		return null;
	}
	
	
	
	/* delete(i) method
	 * Deletes the element at position i. returns true if successful,
	 * and false otherwise (i.e. there is no such element). 
	 * Indexing/positions start at 0.
	 */
	public boolean delete(int index) {
		if (this.getSize() > index) {
			Node<E> currentNode = this.getFirst();
			for (int i = 0; i != index; i++) {
				currentNode = currentNode.getNext();
			}
			if (this.size > 1 && index == 0) {
				currentNode.getNext().setPrevious(null);
				this.setFirst(currentNode.getNext());
			}
			else if (this.size > 1 && index != this.getSize() - 1) {
				currentNode.getPrevious().setNext(currentNode.getNext());
				currentNode.getNext().setPrevious(currentNode.getPrevious());
			}
			else if (this.size > 1) {
				currentNode.getPrevious().setNext(null);
				this.setLast(currentNode.getPrevious());
			}
			else {
				this.setFirst(null);
				this.setLast(null);
			}
			this.size--;
			return true;
		}
		return false;
	}
	
	
	/* insert(i, e) method
	 * inserts element e at position i. Returns true if successful, 
	 * and false otherwise (i.e. if the list does not have i elements in it). 
	 * Indexing/positions start at 0.
	 */
	public boolean insert(int index, E object) {
		Node<E> newNode = new Node<>(object);
		Node<E> currentNode = this.getFirst();
		if (index >= 0 && index < this.getSize()) {
			for (int i = 0; index != i; i++) {
				currentNode = currentNode.getNext();
			}
			if (!currentNode.equals(this.getFirst())) {
				currentNode.getPrevious().setNext(newNode);
				newNode.setPrevious(currentNode.getPrevious());
				currentNode.setPrevious(newNode);
				newNode.setNext(currentNode);
			}
			else if (this.getSize() >= 1) {
				currentNode.setPrevious(newNode);
				newNode.setNext(currentNode);
				this.setFirst(newNode);
			}
			this.size++;
			return true;
		}
		if (index == this.getSize()) {
			for (int i = 0; index > (i + 1); i++) {
				currentNode = currentNode.getNext();
			}
			if (this.getSize() > 0) {
				currentNode.setNext(newNode);
				newNode.setPrevious(currentNode);
			}
			else {
				this.setFirst(newNode);
			}
			this.setLast(newNode);
			this.size++;
			return true;
		}
		return false;
	}
	
	
	/* search(e) method
	 * Returns the position of element e in the list. 
	 * Returns -1 if element e is not in the list.
	 * Indexing/positions start at 0.
	 */
	public int search(E object) {
		Node<E> currentNode = this.getFirst();
		for (int i = 0; i < this.getSize(); i++) {
			if (currentNode.getData().equals(object)) {
				return i;
			}
			currentNode = currentNode.getNext();
		}
		return -1;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LinkedList<E> that = (LinkedList<E>) o;
		Node<E> currentNode = this.getFirst();
		Node<E> thatCurrentNode = that.getFirst();
		if (this.getSize() != that.getSize()) {
			return false;
		}
		for (int i = 0; i < this.getSize(); i++) {
			if (!currentNode.getData().equals(thatCurrentNode)) {
				return false;
			}
			currentNode = currentNode.getNext();
			thatCurrentNode = thatCurrentNode.getNext();
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(size, first, last);
	}

	@Override
	public String toString() {
		String[] elements = new String[this.getSize()];
		Node<E> currentNode = this.getFirst();
		for (int i = 0; i < this.getSize(); i++) {
			elements[i] = currentNode.toString();
			currentNode = currentNode.getNext();
		}
		return Arrays.toString(elements);
	}
}
