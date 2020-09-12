package data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The study group composed of users and the course that they want to 
 * study about with each other
 * TODO - Need a way to represent meeting time (better way to represent date 
 * and time)
 * @author 
 */
public class StudyGroup {
	
	// Private instance fields

	private boolean full;
	int[][] schedule;



	UUID id;
	ArrayList<User> members = new ArrayList<>();
	
	/**
	 * List of users in the study group
	 */
	private List<User> users;
	
	/**
	 * The course the users want to study with each other about
	 */
	private String category;
	
	// Constructor




	/**
	 * Creates a study group with given course and initialize remaining fields
	 */
	public StudyGroup(String category, int[][] schedule) {
		this.category = category;
		this.users = new ArrayList<User>();
		this.full = false;
		this.schedule = schedule; //new int[7][24];
		this.id = UUID.randomUUID();
	}
	
	// Getter functions
	
	/**
	 * Gets the users of the study group
	 * @return users of the study group
	 */
	public List<User> getUsers() {
		return this.users;
	}

	public int[][] getSchedule() {
		return schedule;
	}

	public String getCategory() {
		return category;
	}


	public boolean isFull() {
		return full;
	}

	public UUID getId() {
		return id;
	}

	public ArrayList<User> getMembers() {
		return members;
	}


	// Setter functions
	
	/**
	 * Sets the course of the study group
	 */
	//public void setCourse(Course course) {
	//	this.course = course;
	//}
	
	// Adder functions
	
	/**
	 * Adds a user into the list of users in the study group
	 * @param user to be added
	 */
	public void addUser(User user) {
		this.users.add(user);
	}

	public void setSchedule(int[][] schedule) {
		this.schedule = schedule;
	}
}
