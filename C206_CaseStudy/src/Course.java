/**
 * 
 */

/**
 * @author jiaan
 *
 */
public class Course {//jia an
	private String courseCode;
	private String courseTitle;
	private String courseDesc;
	private String courseEligibil; //ella - added eligibility
	private int courseAvailability; // jacky 
	private String schedule;
	
	public Course(String courseCode, String courseTitle, String courseDesc, String courseEligibil, int courseAvailability, String schedule) {
		
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
		this.courseEligibil = courseEligibil; //ella
		this.courseAvailability = courseAvailability; // jacky
		this.schedule = schedule;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}
	
	public String getCourseEligibil() { //ella
		return courseEligibil; //ella
	}

	public String getSchedule() {
		return schedule;
	}
	
	public int getCourseAvailability() {
		return courseAvailability; // jacky
	}
	
	
}
