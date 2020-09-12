package data;

/**
 * The CIT course that the user is enrolled in
 * @author
 */
public class Course {
	
	// Private instance fields
	
	/**
	 * The number of the course
	 */
	private int courseNum;
	
	/**
	 * The name of the course
	 */
	private String courseName;
	
	// Constructor
	
	/**
	 * Creates a course with given number and name
	 * @param courseNum of course
	 * @param CourseName of course
	 */
	public Course(int courseNum, String courseName) {
		this.setCourseNum(courseNum);
		this.setCourseName(courseName);
	}
	
	// Getter functions
	
	/**
	 * Gets the course number
	 * @return courseNum of course
	 */
	public int getCourseNum() {
		return this.courseNum;
	}
	
	/**
	 * Gets the course name
	 * @return courseName of course
	 */
	public String getCourseName() {
		return this.courseName;
	}
	
	// Setter functions
	
	/**
	 * Sets the course number
	 * @param courseNum of course
	 */
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	
	/**
	 * Sets the course name
	 * @param courseName of course
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
