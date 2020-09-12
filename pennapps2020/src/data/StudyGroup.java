package data;

import java.util.ArrayList;
import java.util.UUID;

/**
 * The study group composed of members and the category that they want to 
 * study about with each other
 * @author 
 */
public class StudyGroup {
	
	// Private instance fields

	/**
	 * Indicates whether the study group is full or not
	 */
	private boolean full;
	
	/**
	 * The combined availability schedule of all the members in the study group
	 */
	private int[][] schedule;
	
	/**
	 * A unique id of the study group
	 */
	private UUID id;
	
	/**
	 * List of members in the study group
	 */
	private ArrayList<User> members;
	
	/**
	 * The category the users want to study with each other about
	 */
	private String category;
	
	// Constructor

	/**
	 * Creates a study group with given category and schedule, and 
	 * initialize remaining fields
	 */
	public StudyGroup(String category, int[][] schedule) {
		this.category = category;
		this.full = false;
		this.schedule = schedule; // new int[7][24];
		this.id = UUID.randomUUID();
		this.members = new ArrayList<>();
	}
	
	// Getter functions

	/**
	 * Gets the schedule of the study group
	 * @return schedule of the study group
	 */
	public int[][] getSchedule() {
		return this.schedule;
	}

	/**
	 * Gets the category of the study group
	 * @return category of the study group
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * Gets whether the study is full
	 * @return full or not full
	 */
	public boolean isFull() {
		return this.full;
	}

	/**
	 * Gets the unique id of the study group
	 * @return id of the study group
	 */
	public UUID getId() {
		return this.id;
	}

	/**
	 * Gets all the members in the study group
	 * @return members of the study group
	 */
	public ArrayList<User> getMembers() {
		return this.members;
	}

	// Setter functions
	
	/**
	 * Sets the schedule of the study group
	 * @param schedule of the study group
	 */
	public void setSchedule(int[][] schedule) {
		this.schedule = schedule;
	}
	
	/**
	 * Sets the study group to be full
	 * @param full study group
	 */
	public void setFull(boolean full) {
		this.full = full;
	}
	
	// Adder functions
	
	/**
	 * Adds a member into the list of members in the study group
	 * @param member to be added
	 */
	public void addMember(User member) {
		this.members.add(member);
	}
}
