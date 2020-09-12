package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * The user trying to book a time and date for a study group
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
	 * The schedule of the user
	 */
	private int[][] schedule;
	
	// Constructor
	
	/**
	 * Creates an user with given name and email, and initialize all fields
	 */
	public User(String name, String email) {
		this.setName(name);
		this.setEmail(email);
		
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
	 * Gets the schedule of the user
	 * @return schedule of the user
	 */
	public int[][] getSchedule() {
		return schedule;
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
	
}
