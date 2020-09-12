package data;

import java.util.ArrayList;
import java.util.List;

/**
 * The study group composed of users and the course that they want to 
 * study about with each other
 * TODO - Need a way to represent meeting time (better way to represent date 
 * and time)
 * @author 
 */
public class StudyGroup {
	
	// Private instance fields
	
	/**
	 * List of users in the study group
	 */
	private List<User> users;
	
	/**
	 * The course the users want to study with each other about
	 */
	private Course course;
	
	// Constructor
	
	/**
	 * Creates a study group with given course and initialize remaining fields
	 */
	public StudyGroup(Course course) {
		this.setCourse(course);
		this.users = new ArrayList<User>();
	}
	
	// Getter functions
	
	/**
	 * Gets the users of the study group
	 * @return users of the study group
	 */
	public List<User> getUsers() {
		return this.users;
	}
	
	/**
	 * Gets the course the users want to study with each other about
	 * @return course of the study group
	 */
	public Course getCourse() {
		return this.course;
	}
	
	// Setter functions
	
	/**
	 * Sets the course of the study group
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
	
	// Adder functions
	
	/**
	 * Adds a user into the list of users in the study group
	 * @param user to be added
	 */
	public void addUser(User user) {
		this.users.add(user);
	}
	
}
