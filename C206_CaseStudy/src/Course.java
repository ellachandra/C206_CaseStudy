/**
 * 
 */

/**
 * @author jiaan
 *
 */
public class Course {
	private String courseCode;
	private String courseTitle;
	private String courseDesc;
	private String schedule;
	
	public Course(String courseCode, String courseTitle, String courseDesc, String schedule) {
		
		this.courseCode = courseCode;
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
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

	public String getSchedule() {
		return schedule;
	}
	
	
	
}
