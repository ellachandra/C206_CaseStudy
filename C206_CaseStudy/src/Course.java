/**
 * 
 */

/**
 * @author jiaan
 *
 */
public class Course {
	private String courseTitle;
	private String courseCode;
	private String courseDesc;
	private String courseSchool;
	private int courseCap;
	
	public Course(String courseTitle, String courseCode, String courseDesc, String courseSchool, int courseCap) {
		
		this.courseTitle = courseTitle;
		this.courseCode = courseCode;
		this.courseDesc = courseDesc;
		this.courseSchool = courseSchool;
		this.courseCap = courseCap;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getCourseSchool() {
		return courseSchool;
	}

	public void setCourseSchool(String courseSchool) {
		this.courseSchool = courseSchool;
	}

	public  String showAvailability(boolean courseCap) {
		String avail;

		if (courseCap == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
}
