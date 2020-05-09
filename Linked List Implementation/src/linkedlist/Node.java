package linkedlist;

import java.util.Objects;

public class Node<E> {
	
	/* ------------------------------------------------------------------
	 * 				Instance Variables and Constructor
	 * ------------------------------------------------------------------
	 */
	
	private E data;
	private Node<E> next;
	private Node<E> previous;
	
	
	public Node(E data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
	
	/* ------------------------------------------------------------------
	 * 							Getters and Setters
	 * ------------------------------------------------------------------
	 */

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

	public Node<E> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<E> previous) {
		this.previous = previous;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Node<?> node = (Node<?>) o;
		return Objects.equals(data, node.data) &&
				Objects.equals(next, node.next) &&
				Objects.equals(previous, node.previous);
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, next, previous);
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
