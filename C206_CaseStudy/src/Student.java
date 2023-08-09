import java.util.ArrayList;
import java.util.List;


public class Student extends User{
	private List<Attendance> attendanceRecords;
	private String educationHistory; // jacky

	public Student(String userId, String password, String name, int number, String email, String EducationHistory) {
        super(userId,password, name, number, email);
        this.attendanceRecords = new ArrayList<>();
        this.educationHistory = EducationHistory; // jacky
    }
	
	
	// all for attendance - ella
	public void markAttendance(String courseCode, boolean isPresent, String lessonNo) {
	    Attendance attendance = new Attendance(courseCode, isPresent, lessonNo);
	    attendanceRecords.add(attendance);
	}

    public List<Attendance> getAttendanceRecords() {
        return attendanceRecords;
    }
    
    public class Attendance {
        private String courseCode;
        private boolean isPresent;
        private String lessonNo; // Add the lesson number

        public Attendance(String courseCode, boolean isPresent, String lessonNo) {
            this.courseCode = courseCode;
            this.isPresent = isPresent;
            this.lessonNo = lessonNo;
        }

        public String getCourseCode() {
            return courseCode;
        }
        public boolean isPresent() {
            return isPresent;
        }
        public String getLessonNo() {
            return lessonNo;
        }
    }
    
    public void deleteAttendance(String courseCode) { //deletes 1 lesson at a time
        for (int i = 0; i < attendanceRecords.size(); i++) {
            Attendance attendance = attendanceRecords.get(i);
            if (attendance.getCourseCode().equals(courseCode)) {
                attendanceRecords.remove(i);
            }
        }
    }
    
    public String getEducationHistory() {
    	return educationHistory;
    }

}
