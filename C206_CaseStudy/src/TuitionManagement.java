import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

/**
 * 
 */

/**
 * @author jiaan
 *
 */

//ella has edited add, view and delete users
public class TuitionManagement {
	private static final int ADMIN_ENROLMENT_DELETE = 3;
	private static final int ADMIN_ENROLMENT_VIEW = 2;
	private static final int ADMIN_ENROLMENT_ADD = 1;
	private static final int ADMIN_ENROLMENT_QUIT = 4;
	private static final int ADMIN_OPTION_QUIT = 7;// jia an
	private static final int ADMIN_OPTION_USER = 1;// jia an
	private static final int ADMIN_OPTION_COURSE = 2;// jia an
	private static final int ADMIN_OPTION_STUDENT = 3;// wei le
	private static final int ADMIN_OPTION_FEE = 4;// jia an
	private static final int ADMIN_OPTION_ENROLMENT = 5;// jia an
	private static final int ADMIN_OPTION_ATTENDANCE = 6; // jia an

	private static final int ADMIN_LOGIN = 1; // jia an
	private static final int STUDENT_LOGIN = 2; // jia an
	private static final int TEACHER_LOGIN = 3; // jia an
	private static final int NO_LOGIN = 4; // jia an

	private static final int ADMIN_COURSE_ADD = 1; // jia an
	private static final int ADMIN_COURSE_VIEW = 2; // jia an
	private static final int ADMIN_COURSE_DELETE = 3; // jia an
	private static final int ADMIN_COURSE_UPDATE = 4; // jia an
	private static final int ADMIN_COURSE_QUIT = 5; // jia an

	private static final int ADMIN_USER_ADD = 1; // ella
	private static final int ADMIN_USER_VIEW = 2; // ella
	private static final int ADMIN_USER_DELETE = 3; // ella
	private static final int ADMIN_USER_QUIT = 4; // ella

	private static final int ADMIN_STUDENT_ADD = 1; // weile
	private static final int ADMIN_STUDENT_VIEW = 2; // weile
	private static final int ADMIN_STUDENT_DELETE = 3; // weile
	private static final int ADMIN_STUDENT_QUIT = 4; // weile

	private static final int ADMIN_ATTENDANCE_ADD = 1; // ella
	private static final int ADMIN_ATTENDANCE_VIEW = 2; // ella
	private static final int ADMIN_ATTENDANCE_DELETE = 3; // ella
	private static final int ADMIN_ATTENDANCE_QUIT = 4; // ella

	private static final int ADMIN_FEE_ADD = 1;// donovan
	private static final int ADMIN_FEE_VIEW = 2;// donovan
	private static final int ADMIN_FEE_DELETE = 3;// donovan
	private static final int ADMIN_FEE_QUIT = 4;// donovan

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Administrator admin = new Administrator("admin123","p4ssword", "John Doe", "john.doe@example.com");
		 
		ArrayList<Administrator> administrators = new ArrayList<>();//jia an
        administrators.add(new Administrator("admin1", "admin123", "Administrator 1", 91122334, "admin1@example.com"));
        administrators.add(new Administrator("admin2", "admin456", "Administrator 2", 92233445, "admin2@example.com"));
        administrators.add(new Administrator("admin3", "admin789", "Administrator 3", 93344556, "admin3@example.com"));
        administrators.add(new Administrator("admin4", "adminabc", "Administrator 4", 94455667, "admin4@example.com"));

        ArrayList<Student> students = new ArrayList<>(); //weile
        students.add(new Student("student1", "student123", "Student 1", 81122334, "student1@example.com", "Programming experience"));
        students.add(new Student("student2", "student456", "Student 2", 81222334, "student2@example.com", "Programming experience"));
        students.add(new Student("student3", "student789", "Student 3", 81322334, "student3@example.com", "Java experience"));
        students.add(new Student("student4", "studentabc", "Student 4", 81422334, "student4@example.com", "Java experience"));
        
		ArrayList<Course> courseList = new ArrayList<Course>();//jia an
		Course c1 = new Course("CS101", "Java Corp", "The Journey of Java", "Programming experience",20, "Mon, Wed 10:00 AM - 11:30 AM");
		//added 1 more course to show eligibility example - ella
		Course c2 = new Course("CS102", "Java Corp 2", "Advanced journey of Java", "Java experience",40, "Tue, Thur 11:00 AM - 12:30 PM");
		courseList.add(c1);
		courseList.add(c2);//ella
		
		ArrayList<Fee> Fees = new ArrayList<Fee>();
		Fees.add(new Fee("A123","tuition fee","8/9/2023",100.60));
		
		
		ArrayList<Enrolment> enrolmentList = new ArrayList<Enrolment>();
		Enrolment e1 = new Enrolment("Student 1", "CS101");
		enrolmentList.add(e1);
		
		// Find a student by their ID - ella
		Student student1 = findStudentById(students, "student1");
		Student student2 = findStudentById(students, "student2");

		// Mark attendance for student1 in course c1 - ella
		student1.markAttendance(c1.getCourseCode(), true, "1");
		student1.markAttendance(c1.getCourseCode(), false, "2");
		student1.markAttendance(c1.getCourseCode(), true, "3");

		// Mark attendance for student1 in course c2 - ella
		student1.markAttendance(c2.getCourseCode(), true, "1");
		student1.markAttendance(c2.getCourseCode(), true, "2");
		student1.markAttendance(c2.getCourseCode(), true, "3");

		// Mark attendance for student2 in course c1 - ella
		student2.markAttendance(c1.getCourseCode(), true, "1");
		student2.markAttendance(c1.getCourseCode(), true, "2");
		student2.markAttendance(c1.getCourseCode(), false, "3");

		// Mark attendance for student2 in course c2 - ella
		student2.markAttendance(c2.getCourseCode(), true, "1");
		student2.markAttendance(c2.getCourseCode(), false, "2");
		student2.markAttendance(c2.getCourseCode(), true, "3");
		
		
	
			int option = 0;

			while (option != NO_LOGIN) {// jia an

				TuitionManagement.loginmenu();
				option = Helper.readInt("Enter an option > ");
			
			
			if (option == ADMIN_LOGIN) {//jia an
				// Code to Login for admin
				boolean loginSuccessful = false;
				String inputUserId = Helper.readString("Enter your userID: ");
                 String inputPassword = Helper.readString("Enter your password: ");
				
				for(Administrator admin: administrators) {
					
	                if (inputUserId.equals(admin.getUserId()) && inputPassword.equals(admin.getPassword())) {
	                    System.out.println("Login successful. Welcome, " + admin.getName() + "!");
	                    // Additional code for admin after login goes here
	                    loginSuccessful = true;
	                    break; // Exit the loop if login is successful
	                }
	            }
				if (!loginSuccessful) {
	                System.out.println("Invalid userID or password. Please try again.");
	            }
				
				if(loginSuccessful == true) {//jia an
					int optionA = 0;
					while (optionA != ADMIN_OPTION_QUIT) {
					TuitionManagement.adminmenu();
					optionA = Helper.readInt("Enter an option > ");
					// ella
						if(optionA == ADMIN_OPTION_USER ) {
							
							int choice = 0;
							
							while (choice != ADMIN_USER_QUIT) {//jia an
								
								TuitionManagement.userTypeMenu(); //menu
								choice = Helper.readInt("Enter an option > ");
								
								if (choice == ADMIN_USER_ADD) { //add user -ella
									TuitionManagement.setHeader("ADD NEW USER");
									
									//Add a user
									Administrator ad = inputUser();
									TuitionManagement.addUser(administrators, ad);
									//print success message
									System.out.println("User added successfully!");
									
								} else if (choice == ADMIN_USER_VIEW) { //view all users - ella
									TuitionManagement.viewAllUsers(administrators);
									
									
								} else if (choice == ADMIN_USER_DELETE) { //delete all users - ella
									TuitionManagement.setHeader("DELETE EXISTING USER");
									String deleteUser = Helper.readString("Enter userID to delete: ");
									
									boolean deleted = TuitionManagement.deleteStudent(students, deleteUser);
									
									if (deleted == true) { //print message - ella
										System.out.println("UserID: " + deleteUser + " has been deleted successfully!");
									} else {
										System.out.println("UserID: " + deleteUser + " cannot be found!");
									}
								}
								
							}
							
						}
						else if(optionA == ADMIN_OPTION_COURSE) {//jia an
						//code for course
							int optionC = 0;
							while(optionC != ADMIN_COURSE_QUIT) {//jia an
									TuitionManagement.courseTypeMenu();
									optionC = Helper.readInt("Enter an option > ");
						
									if(optionC == ADMIN_COURSE_ADD) {//jia an
										TuitionManagement.setHeader("ADD A NEW COURSE");
							
										String courseId = Helper.readString("Enter Course ID: ");
										String courseName = Helper.readString("Enter Course Name: ");
										String courseDescription = Helper.readString("Enter Course Description: ");
										String courseEligibility = Helper.readString("Enter Course Eligibility Criteria: "); // added
																																// eligibility
																																// -
																																// ella
										int courseAvailability = Helper.readInt("Enter Course Availability: "); // jacky
										String schedule = Helper.readString("Enter Course Schedule: ");
										// Create a new Course object with user input
										Course newCourse = new Course(courseId, courseName, courseDescription,
												courseEligibility, courseAvailability, schedule);
										// Add the new course to the ArrayList
										TuitionManagement.addCourse(courseList, newCourse);
										// Print a success message
										System.out.println("Course added successfully!");
									} else if(optionC == ADMIN_COURSE_VIEW) {//jia an
										TuitionManagement.setHeader("VIEW ALL COURSE");
										System.out.println("ALL COURSES:");
										Helper.line(120, "-");
										System.out.println(
							                      "Course Course\tCourse Name\t\tDescription\t\t\tEligibility\tAvailability\t\tSchedule");
										Helper.line(120, "-");
//										for (Course course : courseList) {
//										String courseId = course.getCourseCode();
//										String courseName = course.getCourseTitle();
//										String eligibility = course.getCourseEligibil();
//										int availability = course.getCourseAvailability();
//										String courseDescription = course.getCourseDesc();
//										String schedule = course.getSchedule();
//
//										System.out.printf("%-10s\t%-20s\t%-30s\t%-20s\t%-12d\t%-15s%n", courseId,
//												courseName, courseDescription, eligibility, availability, schedule);
//										
//										
//										
//									}
									TuitionManagement.viewAllCourses(courseList);
									Helper.line(180, "-");
									}
									else if(optionC == ADMIN_COURSE_DELETE) {//jia an
										TuitionManagement.setHeader("DELETE ALL COURSE");
										String courseIdToDelete = Helper.readString("Enter the Course ID to delete:");

										// Delete the course with the given course ID
									    boolean courseDeleted = deleteCourse(courseList, courseIdToDelete);

										// Print the result of the delete operation
									    if (courseDeleted) {
									        System.out.println("Course with ID " + courseIdToDelete + " has been deleted.");
									    } else {
									        System.out.println("Course with ID " + courseIdToDelete + " not found.");
									    }
									}
							}
							
							}
						else if (optionA == ADMIN_OPTION_STUDENT) { //Wei Le
							//code for Student Management
							int optionD = 0;
							while(optionD != ADMIN_STUDENT_QUIT) { //weile
									studentTypeMenu();
									optionD = Helper.readInt("Enter an option > ");
						
									if(optionD == ADMIN_STUDENT_ADD) { //weile
										TuitionManagement.setHeader("ADD A NEW STUDENT");
							
										String studentID = Helper.readString("Enter User ID: ");
										String studentPassword = Helper.readString("Enter a password: ");
										String studentName = Helper.readString("Enter User Name: ");
										int studentNumber = Helper.readInt("Enter User Contact Number: ");
										String studentEmail = Helper.readString("Enter User Email: ");
										String educationHistory = Helper.readString("Enter your past education experience(Programming experience/Java experience): ");

										// Create a new Student object with user input
										Student newStudent = new Student(studentID, studentPassword, studentName, studentNumber, studentEmail, educationHistory);

										// Add the new student to the ArrayList
										TuitionManagement.addStudent(students, newStudent);

										// Print a success message
										System.out.println("Student added successfully!");
							
									}else if(optionD == ADMIN_STUDENT_VIEW) { //weile
										TuitionManagement.setHeader("VIEW ALL STUDENT");
										System.out.println("ALL STUDENTS:");
										Helper.line(120, "-");
										System.out.println(String.format("%-10s %20s %20s %20s\n", "STUDENT ID", "STUDENT NAME", "STUDENT NUMBER", "STUDENT EMAIL")); //need to add eligibility
										Helper.line(120, "-");
										TuitionManagement.viewAllStudent(students);
										Helper.line(120, "-");
									}
									else if(optionD == ADMIN_STUDENT_DELETE) { //weile
										TuitionManagement.setHeader("DELETE EXISTING STUDENT");
										String deleteStudent = Helper.readString("Enter studentID to delete: ");
										
										boolean deleted = TuitionManagement.deleteStudent(students, deleteStudent);
										

										// Print the result of the delete operation
										if (deleted) {
											System.out.println("Course with ID " + deleteStudent + " has been deleted.");
										} else {
											System.out.println("Course with ID " + deleteStudent + " not found.");
										}
									}
							}
						
						}
						else if (optionA == ADMIN_OPTION_FEE) { //donovan
							//code for Fee Management
							int optionE = 0;
							while (optionE != ADMIN_FEE_QUIT) {//donovan
								TuitionManagement.feeTypeMenu();
								optionE = Helper.readInt("Enter an option > ");
								
								if(optionE == ADMIN_FEE_ADD) {//donovan
									TuitionManagement.setHeader("ADD A NEW FEE");
									
									String FeeID = Helper.readString("Enter Fee ID > ");
									String FeeType = Helper.readString("Enter Type of Fee > ");
									String DueDate = Helper.readString("Enter DueDate > ");
									Double Amount = Helper.readDouble("Enter Amount > ");
									
									//create new fee
									Fee newFee = new Fee(FeeID,FeeType,DueDate,Amount);
									
									//add new fee to the arraylist
									TuitionManagement.addFee(Fees, newFee);
									
									System.out.println("Fee Successfully added!");
									
									
									
								}else if(optionE == ADMIN_FEE_VIEW){//donovan
									TuitionManagement.setHeader("VIEW ALL FEE");
									System.out.println("ALL FEES:");
									Helper.line(120, "-");
									System.out.println(String.format("%-12s %-20s %-16s %-10s", "FeeID","FEE TYPE","DUE DATE","AMOUNT"));
									Helper.line(120, "-");
									TuitionManagement.viewAllFee(Fees);
									Helper.line(120,"-");
								}else if(optionE == ADMIN_FEE_DELETE) {//donovan
									TuitionManagement.setHeader("DELETE EXISTING FEE");
									String deleteFee = Helper.readString("Enter FeeID to delete > ");
									
									boolean deleted = TuitionManagement.deleteFee(Fees,deleteFee);
									
									//print output
									if (deleted) {
										System.out.println("Fee ID " + deleteFee + " has been deleted");
									}else {
										System.out.println("Fee ID " + deleteFee + " not found");
									}
								}
								
							}
						}
						else if (optionA == ADMIN_OPTION_ENROLMENT) {
							//code for Enrollment Management
							int choice = 0;
							while (choice != ADMIN_ENROLMENT_QUIT) {
								TuitionManagement.enrolmentTypeMenu();
								choice = Helper.readInt("Enter an option: ");

								if (choice == ADMIN_ENROLMENT_ADD) {
									addEnrolment(courseList, students, enrolmentList);
								} else if (choice == ADMIN_ENROLMENT_VIEW) {
									viewEnrolment(enrolmentList);
								} else if (choice == ADMIN_ENROLMENT_DELETE) {
									deleteEnrolment(enrolmentList);
								} else {
									System.out.println("Invalid Option!");
								}
							}
						}
						else if(optionA == ADMIN_OPTION_ATTENDANCE) { //ella
							//code for Attendance
							int choice = 0;
							while (choice != ADMIN_ATTENDANCE_QUIT) { //ella
								TuitionManagement.attendanceTypeMenu();
								choice = Helper.readInt("Enter an option > ");
								
								if (choice == ADMIN_ATTENDANCE_ADD) { // ella
									TuitionManagement.setHeader("ADD ATTENDANCE");
									
									String studentId = Helper.readString("Enter Student ID: ");
								    Student student = findStudentById(students, studentId);

								    if (student != null) {
								        String courseCode = Helper.readString("Enter Course Code: ");
								        int numOfLessons = Helper.readInt("Enter the number of lessons: ");

								        for (int i = 1; i <= numOfLessons; i++) {
								            String lessonNo = Helper.readString("Enter lesson number for Lesson " + i + ": ");
								            boolean isPresent = Helper.readBoolean("Is the student present for Lesson " + i + "? (true/false): ");

								            student.markAttendance(courseCode, isPresent, lessonNo);
								        }

								        System.out.println("Attendance marked successfully!");
								    } else {
								        System.out.println("Student not found!");
								    }
								    
								} else if (choice == ADMIN_ATTENDANCE_VIEW) { // ella
									 TuitionManagement.setHeader("VIEW ALL ATTENDANCE");
									    String studentId = Helper.readString("Enter Student ID: ");
									    Student student = findStudentById(students, studentId);

									    if (student != null) {
									        System.out.println("ATTENDANCE RECORDS:");
									        Helper.line(120, "-");
									        System.out.println("Course Code\tLesson No.\tIs Present");
									        Helper.line(120, "-");

									        for (Student.Attendance attendance : student.getAttendanceRecords()) {
									            String courseCode = attendance.getCourseCode();
									            String lessonNo = attendance.getLessonNo();
									            boolean isPresent = attendance.isPresent();

									            System.out.printf("%-20s\t%-10s\t%-10s%n", courseCode, lessonNo, isPresent);
									        }
									        Helper.line(120, "-");
									    } else {
									        System.out.println("Student Not Found!");
									    }
										
								} else if (choice == ADMIN_ATTENDANCE_DELETE) { //deletes lesson by lesson - ella
				                    TuitionManagement.setHeader("DELETE STUDENT ATTENDANCE");
				                    String studentId = Helper.readString("Enter Student ID: ");
				                    Student student = findStudentById(students, studentId);

				                    if (student != null) {
				                        String courseCode = Helper.readString("Enter Course Code: ");
				                        student.deleteAttendance(courseCode);
				                        System.out.println("Attendance for student " + studentId + " in course " + courseCode + " has been deleted.");
				                        
				                    } else {
				                        System.out.println("Student not found!");
				                    }
					
								}	
					
							}
						}
				
			
				
				else if (option == STUDENT_LOGIN) {
					//Code for login Student
				}
				else{
					System.out.println("Thank you for visiting Saint Tuition Management!");
				}
			
				}
				}
			}
			}
			
	
	
	
	

		}

	// ================================ OTHER METHODS
	// =======================================================

	public static void adminmenu() {//jia an not so important
		TuitionManagement.setHeader("Tuition Management App");
		System.out.println("1. User Management");
		System.out.println("2. Course Management");
		System.out.println("3. Student Management");
		System.out.println("4. Fee Management");
		System.out.println("5. Enrolment Management");
		System.out.println("6. Attendence Management");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}

	public static void loginmenu() {// jia an
		TuitionManagement.setHeader("WELCOME TO TUITION MANAGEMENT!");
		System.out.println("1. Admin Login");
		System.out.println("2. Student Login");
		System.out.println("3. Teacher Login");
		System.out.println("4. Leave... ");

		Helper.line(80, "-");

	}

	public static void setHeader(String header) {// jiaan
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void courseTypeMenu() {// jia an
		TuitionManagement.setHeader("COURSE MANAGEMENT");
		System.out.println("1. Add a new Course");
		System.out.println("2. View all Courses");
		System.out.println("3. Delete an existing Course");
		System.out.println("4. Update an existing Course");
		System.out.println("5. Quit ");
		Helper.line(80, "-");

	}

	public static void userTypeMenu() { //ella
		TuitionManagement.setHeader("USER MANAGEMENT");
		System.out.println("1. Add a new user");
		System.out.println("2. View all user");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void studentTypeMenu() { //weile
		TuitionManagement.setHeader("STUDENT MANAGEMENT");
		System.out.println("1. Add a new Student");
		System.out.println("2. View all Students");
		System.out.println("3. Delete an existing Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void attendanceTypeMenu() {
		TuitionManagement.setHeader("ATTENDANCE MANAGEMENT");
		System.out.println("1. Add a new Attendance");
		System.out.println("2. View all Attendance");
		System.out.println("3. Delete a students Attendance");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static void feeTypeMenu() {//donovan
		TuitionManagement.setHeader("FEE MANAGEMENT");
		System.out.println("1. Add a new fee");
		System.out.println("2. View all fee");
		System.out.println("3. Delete an existing fee");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	public static void enrolmentTypeMenu() {
		TuitionManagement.setHeader("ENROLMENT MANAGEMENT");
		System.out.println("1. Enrol student");
		System.out.println("2. View all Enrolment");
		System.out.println("3. Delete an existing Enrolment");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	public static Student findStudentById(List<Student> students, String studentId) {//ella
		for (Student student : students) {
			if (student.getUserId().equals(studentId)) {
				return student;
			}
		}
		return null; // Return null if student is not found
	}

	public static Administrator inputUser() { //ella

		String userID = Helper.readString("Enter User ID: ");
		String userPassword = Helper.readString("Enter a password: ");
		String userName = Helper.readString("Enter User Name: ");
		int userNumber = Helper.readInt("Enter User Contact Number: ");
		String userEmail = Helper.readString("Enter User Email: ");

		Administrator ad = new Administrator(userID, userPassword, userName, userNumber, userEmail);
		return ad;

	}

	public static void addUser(ArrayList<Administrator> administrators, Administrator ad) {//ella
		Administrator user;
		for (int i = 0; i < administrators.size(); i++) {
			user = administrators.get(i);
			if (user.getUserId().equalsIgnoreCase(ad.getUserId()))
				return;
		}
		if ((ad.getUserId().isEmpty()) || (ad.getEmail().isEmpty())) {
			return;
		}
		administrators.add(ad);

	}

	public static void addStudent(ArrayList<Student> students, Student stud) { // weile
		Student user;
		String id = stud.getUserId();
		String email = stud.getEmail();
		for (int i = 0; i < students.size(); i++) {
			user = students.get(i);
			if (user.getUserId().equalsIgnoreCase(id))
				return;
		}
		if ((id.isEmpty()) || (email.isEmpty())) {
			return;
		}
		students.add(stud);

	}

	// Course stuff

	// -----------------------------------------------------------------------------------------------------------------------------------------------------------

	public static void addCourse(ArrayList<Course> courseList, Course course) {//jia an
		for (Course existingCourse : courseList) {
			if (existingCourse.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
				return; // Course with the same code already exists
			}
		}

		if (course.getCourseCode().isEmpty() || course.getCourseTitle().isEmpty() || course.getCourseDesc().isEmpty()
				|| course.getCourseAvailability() <= 0 || course.getSchedule().isEmpty()) {
			return; // Course information is incomplete or invalid
		}

		courseList.add(course);
	}

	public static String retrieveCourses(ArrayList<Course> courseList) {//jia an
		String output = "";
		for (Course course : courseList) {
			String courseId = course.getCourseCode();
			String courseTitle = course.getCourseTitle();
			String courseDescription = course.getCourseDesc();
			String eligibility = course.getCourseEligibil();
			int availability = course.getCourseAvailability();
			String schedule = course.getSchedule();

			output += String.format("%-10s\t%-20s\t%-30s\t%-20s\t%-12d\t%-20s%n", courseId, courseTitle,
					courseDescription, eligibility, availability, schedule);
		}
		return output;
	}

	public static void viewAllCourses(ArrayList<Course> courseList) {//jia an
		String output = retrieveCourses(courseList);
		System.out.println(output);
	}

	public static boolean deleteCourse(ArrayList<Course> courseList, String courseCodeToDelete) {//jia an
		boolean deleted = false;

		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			if (course.getCourseCode().equals(courseCodeToDelete)) {
				courseList.remove(i);
				deleted = true;
				break;
			}
		}

		return deleted;
	}
	// -----------------------------------------------------------------------------------------------------------------------------------------------------------

	public static String retrieveStudent(ArrayList<Student> students) { // weile
		String output = "";
		for (Student student : students) {
			String studentId = student.getUserId();
			String studentName = student.getName();
			// add eligibility
			int studentNumber = student.getNumber();
			String studentEmail = student.getEmail();

			output += String.format("%-15s\t%-18s\t%-15s\t%-15s%n", studentId, studentName, studentNumber,
					studentEmail);
		}

		return output;
	}

	public static void viewAllStudent(ArrayList<Student> students) { // weile
		// write your code here
		String output = retrieveStudent(students);
		System.out.println(output);
	}

	public static String retrieveUser(ArrayList<Administrator> administrators) { //ella
		String output = "";
		for (Administrator admin : administrators) {
			String userId = admin.getUserId();
			String password = admin.getPassword();
			String name = admin.getName();
			int number = admin.getNumber();
			String email = admin.getEmail();

			output += String.format("%-10s %-10s %-20s %-10d %-30s\n", userId, password, 
					name, number, email);
		}
		return output;
	}

	public static void viewAllUsers(ArrayList<Administrator> administrators) { //ella
		TuitionManagement.setHeader("VIEW ALL USERS");
		String output = String.format("%-10s %20s %20s %20s\n", "USER ID", "USER NAME", "USER NUMBER", "USER EMAIL");
		output += retrieveUser(administrators);
		System.out.println(output);
	}

	public static boolean deleteUser(ArrayList<Administrator> administrators, String deleteUser) { // ella
		boolean deleted = false;

		for (int i = 0; i < administrators.size(); i++) {
			Administrator admin = administrators.get(i);
			if (admin.getUserId().equals(deleteUser)) { // check against list
				administrators.remove(i); // remove from list
				deleted = true;
				break;
			}
		}
		return deleted;
	}

	public static boolean deleteStudent(ArrayList<Student> students, String deleteUser) { // weile
		boolean deleted = false;

		for (int i = 0; i < students.size(); i++) {
			String s = students.get(i).getUserId();
			if (s.equals(deleteUser)) { // check against list
				students.remove(i); // remove from list
				deleted = true;
				break;
			}
		}
		return deleted;

	}

	public static void addFee(ArrayList<Fee> Fees, Fee FEE) { // donovan
		Fee user;
		for (int i = 0; i < Fees.size(); i++) {
			user = Fees.get(i);
			if (user.getFeeID().equalsIgnoreCase(FEE.getFeeID()))
				return;
		}
		if ((FEE.getFeeID().isEmpty())) {
			return;
		}
		Fees.add(FEE);
	}

	public static String retrieveFee(ArrayList<Fee> Fees) { // donovan
		String output = "";
		for (Fee fee : Fees) {
			String FeeID = fee.getFeeID();
			String FeeType = fee.getFeeType();
			// add eligibility
			String duedate = fee.getDueDate();
			double amount = fee.getAmount();

			output += String.format("%-12s\t %-20s\t %-16s\t %-10.2f%n", FeeID, FeeType, duedate, amount);
		}

		return output;
	}

	public static void viewAllFee(ArrayList<Fee> Fees) { // donovan
		// write your code here
		String output = retrieveFee(Fees);
		System.out.println(output);
	}

	public static boolean deleteFee(ArrayList<Fee> Fees, String deleteFee) { // donovan
		boolean deleted = false;

		for (int i = 0; i < Fees.size(); i++) {
			Fee f = Fees.get(i);
			if (f.getFeeID().equals(deleteFee)) { // check against list
				Fees.remove(i); // remove from list
				deleted = true;
				break;
			}
		}
		return deleted;

	}
	
	// ---------------------- ADD ENROLMENT -----------	
	public static void addEnrolment(ArrayList<Course> courseList, ArrayList<Student> students,
			ArrayList<Enrolment> enrolmentList) {
		String studentName = Helper.readString("Enter Student Name: ");
		String courseCode = Helper.readString("Enter the Course Code you wish to enrol the student: ");
		Enrolment e = new Enrolment(studentName, courseCode);
		
		boolean added = false;
		for (Course C : courseList) {
			if (e.getCourseCode() == C.getCourseCode()) {
				for (Student S : students) {
					if (e.getStudentName() == S.getName()) {
						if (C.getCourseEligibil() == "" || S.getEducationHistory() == C.getCourseEligibil()) {
							added = doAddEnrolment(enrolmentList, e);
						}
					}
				}
			}
		}
		
		if (added) {
			System.out.println("Enrolment created!");
		}else {
			System.out.println("Invalid student name or course code!");
		}
	}

	public static boolean doAddEnrolment(ArrayList<Enrolment> enrolmentList, Enrolment e) {
		// no duplication in list
		for(Enrolment E: enrolmentList) {
			if(e.getStudentName() == E.getStudentName()) {
				return false;
			}
		}
		
		// make sure its not empty
		if((e.getStudentName().isEmpty()) || (e.getCourseCode().isEmpty())) {
			return false;
		}
		enrolmentList.add(e);
		return true;
		
	}
	
	// --------------------------- VIEW ENROLMENT
	// --------------------------------------------------
	
	public static String retrieveAllEnrolment(ArrayList<Enrolment> enrolmentList) {
		String output = "";

		for (Enrolment E : enrolmentList) {
			output += String.format("%-15s %-10s\n", E.getStudentName(), E.getCourseCode());
		}
		return output;
	}

	public static void viewEnrolment(ArrayList<Enrolment> enrolmentList) {
		String output = String.format("%-15s %-10s\n", "Student Name", "Course Code");

		setHeader("VIEW ENROLMENT");
		output += retrieveAllEnrolment(enrolmentList);
		System.out.println(output);

	}

	// ---------------------------- DELETE ENROLMENT
	// --------------------------------------------------------

	public static void deleteEnrolment(ArrayList<Enrolment> enrolmentList) {
		String deleteStudent = Helper.readString("Enter the student name of the enrolment you would like to delete: ");

		for (Enrolment E : enrolmentList) {
			if (E.getStudentName() == deleteStudent) {
				System.out.println("Student Name: " + E.getStudentName());
				System.out.println("Course Code: " + E.getCourseCode());
			}
		}

		String deleteConfirmation = Helper.readString("Confirm delete? (Y/N):");

		if (deleteConfirmation == "Y") {
			doDeleteEnrolment(enrolmentList, deleteStudent);
			System.out.println("Enrolment Deleted!");
		}

	}

	public static void doDeleteEnrolment(ArrayList<Enrolment> enrolmentList, String deleteStudent) {

		for (int i = 0; i < enrolmentList.size(); i++) {
			if (enrolmentList.get(i).getStudentName() == deleteStudent) {
				enrolmentList.remove(i);
			}
		}
	}
	

}
