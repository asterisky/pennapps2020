package data;

/**
 * The request made by the user to book a meeting time for the study group 
 * about a specific course
 * TODO - Need a way to represent the deadline (better way to represent time 
 * and date)
 * @author 
 */
public class Request {
	
	// Private instance fields
	
	/**
	 * The user making the request
	 */
	private User user;
	
	/**
	 * The course the user wants to study with others about
	 */
	private Course course;
	
	// Constructor
	
	/**
	 * Creates a request with given user and course to be studied about
	 * @param user
	 */
	public Request(User user, Course course) {
		this.setUser(user);
		this.setCourses(course);
	}
	
	// Getter functions
	
	/**
	 * Gets the user making the request
	 * @return user of the request
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * Gets the course the user wants to study with others about
	 * @return course being studied in meeting
	 */
	public Course getCourses(){
		return this.course;
	}
	
	// Setter functions
	
	/**
	 * Sets the user making the request
	 * @param user of the request
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Sets the course the user wants to study with others about
	 * @param course being studied in meeting
	 */
	public void setCourses(Course course) {
		this.course = course;
	}
}
