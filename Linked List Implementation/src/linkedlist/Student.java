package linkedlist;

public class Student {
	
	/* ------------------------------------------------------------------
	 * 				Instance Variables and Constructor
	 * ------------------------------------------------------------------
	 */
	
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	
	/* ------------------------------------------------------------------
	 * 							Getters and Setters
	 * ------------------------------------------------------------------
	 */
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}