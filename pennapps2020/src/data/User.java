package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeSet;

/**
 * The user trying to book a time and date for a study group
 * TODO - Make time and date into integer values
 * TODO - Need a more fluid data structure to add and remove time blocks
 * TODO - Need to account for booking at the end of the month/year
 * TODO - Maybe find a better way to represent time and date to solve above 
 * 		  problems (Consider Calendar and Date class)
 * @author 
 */
public class User {

	// Private instance fields
	
	/**
	 * The name of the user
	 */
	private String name;
	
	/**
	 * The email of the user
	 */
	private String email;
	
	/**
	 * The local date and time of the user
	 */
	private String localDateTime;
	
	/**
	 * A standard date and time based on a fixed time zone to use for 
	 * matching users together for a study group
	 */
	private String standardDateTime;
	
	/**
	 * The time blocks the user is available to meet
	 */
	private List<TimeBlock> timeBlocks;

	public int[][] getSchedule() {
		return schedule;
	}

	//User has Schedule
	int[][] schedule;
	
	/**
	 * The courses the user are taking
	 */
	private Set<Course> courses;
	
	// Constructor
	
	/**
	 * Creates an user with given name and email, and initialize all fields
	 */
	public User(String name, String email) {
		this.setName(name);
		this.setEmail(email);
		
		this.timeBlocks = new ArrayList<TimeBlock>();
		this.courses = new TreeSet<Course>();
		
		this.setlocalTimeDate();
		this.setStandardTimeDate();
	}
	
	// Getter functions
	
	/**
	 * Gets the name of the user
	 * @return name of the user
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the email of the user
	 * @return email of the user
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Gets the local time and date of the user
	 * @return localDateTime of the user
	 */
	public String getLocalTimeDate() {
		return this.localDateTime;
	}
	
	/**
	 * Gets the standard date and time (based on a fixed time zone GMT) of 
	 * the user
	 * @return standardDateTime of the user
	 */
	public String getStandardTimeDate() {
		return this.standardDateTime;
	}
	
	/**
	 * Gets the time blocks the user is available to meet
	 * @return timeBlocks of the user
	 */
	public List<TimeBlock> getTimeBlocks(){
		return this.timeBlocks;
	}
	
	/**
	 * Gets the courses of the user
	 * @return courses of the user
	 */
	public Set<Course> getCourses(){
		return this.courses;
	}
	
	// Setter functions
	
	/**
	 * Sets the name of the user
	 * @param name of the user
	 */
	public void setName(String name) {
		this.name = name.strip();
	}
	
	/**
	 * Sets the email of the user
	 * @param email of the user
	 */
	public void setEmail(String email) {
		this.email = email.strip();
	}
	
	/**
	 * Sets the local date and time of the user
	 */
	public void setlocalTimeDate() {
	    DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
	    this.localDateTime = df.format(new Date());
	}
	
	/**
	 * Sets the standard date and time (based on a fixed time zone GMT) of 
	 * the user
	 */
	public void setStandardTimeDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		this.standardDateTime = df.format(new Date()); 
	}
	
	// Adder functions
	
	/**
	 * Adds a time block into a list of time blocks
	 * @param timeBlock to be added
	 */
	public void addTimeBlocks(TimeBlock timeBlock) {
		this.timeBlocks.add(timeBlock);
	}
	
	/**
	 * Adds a course into a set of courses
	 * @param course to be added
	 */
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
}
