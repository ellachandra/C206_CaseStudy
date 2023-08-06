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
	private static final int ADMIN_OPTION_QUIT = 7;// jia an
	private static final int ADMIN_OPTION_USER = 1;// jia an
	private static final int ADMIN_OPTION_COURSE = 2;// jia an
	private static final int ADMIN_OPTION_STUDENT = 3;// jia an
	private static final int ADMIN_OPTION_FEE = 4;// jia an
	private static final int ADMIN_OPTION_ENROLMENT = 5;// jia an
	private static final int ADMIN_OPTION_ATTENDANCE = 6; // jia an
	
	
	private static final int ADMIN_LOGIN = 1; // jia an
	private static final int STUDENT_LOGIN= 2; // jia an
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Administrator admin = new Administrator("admin123","p4ssword", "John Doe", "john.doe@example.com");
		 
		ArrayList<Administrator> administrators = new ArrayList<>();
        administrators.add(new Administrator("admin1", "admin123", "Administrator 1", 91122334, "admin1@example.com"));
        administrators.add(new Administrator("admin2", "admin456", "Administrator 2", 92233445, "admin2@example.com"));
        administrators.add(new Administrator("admin3", "admin789", "Administrator 3", 93344556, "admin3@example.com"));
        administrators.add(new Administrator("admin4", "adminabc", "Administrator 4", 94455667, "admin4@example.com"));

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("student1", "student123", "Student 1", 81122334, "student1@example.com"));
        students.add(new Student("student2", "student456", "Student 2", 81222334, "student2@example.com"));
        students.add(new Student("student3", "student789", "Student 3", 81322334, "student3@example.com"));
        students.add(new Student("student4", "studentabc", "Student 4", 81422334, "student4@example.com"));
        
		ArrayList<Course> courseList = new ArrayList<Course>();
		Course c1 = new Course("CS101", "Java Corp", "The Journey of Java", "", "Mon, Wed 10:00 AM - 11:30 AM");
		//added 1 more course to show eligibility example - ella
		Course c2 = new Course("CS102", "Java Corp 2", "Advanced journey of Java", "Requires CS101", "Tue, Thur 11:00 AM - 12:30 PM");
		courseList.add(c1);
		courseList.add(c2);//ella
	
	
			int option = 0;

			while (option != NO_LOGIN) {// jia an

				TuitionManagement.loginmenu();
				option = Helper.readInt("Enter an option > ");
			
			
			if (option == ADMIN_LOGIN) {
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
				
				if(loginSuccessful == true) {
					int optionA = 0;
					while (optionA != ADMIN_OPTION_QUIT) {
					TuitionManagement.adminmenu();
					optionA = Helper.readInt("Enter an option > ");
					// ella
						if(optionA == ADMIN_OPTION_USER ) {
							
							int choice = 0;
							
							while (choice != ADMIN_USER_QUIT) {
								
								TuitionManagement.userTypeMenu(); //menu
								choice = Helper.readInt("Enter an option > ");
								
								if (choice == ADMIN_USER_ADD) { //add user
									TuitionManagement.setHeader("ADD NEW USER");
									
									String userID = Helper.readString("Enter User ID: ");
									String userPassword = Helper.readString("Enter a password: ");
									String userName = Helper.readString("Enter User Name: ");
									int userNumber = Helper.readInt("Enter User Contact Number: ");
									String userEmail = Helper.readString("Enter User Email: ");
									
									//add to ArrayList
									administrators.add(new Administrator(userID, userPassword, userName, userNumber, userEmail));
									//print success message
									System.out.println("User added successfully!");
									
								} else if (choice == ADMIN_USER_VIEW) { //view all users
									TuitionManagement.setHeader("VIEW ALL USERS");
									
									System.out.printf("%-10s %20s %20s %20s", "USER ID", "USER NAME", "USER NUMBER", "USER EMAIL\n");
									Helper.line(120, "-");
									
									for ( Administrator a : administrators ) {
										String userID = a.getUserId();
										String userName = a.getUserId();
										int userNumber = a.getNumber();
										String userEmail = a.getEmail();
										
										System.out.printf("%-10s %17s %20d %30s\n", userID, userName, userNumber, userEmail);
									}
									
									
								} else if (choice == ADMIN_USER_DELETE) { //delete all users
									TuitionManagement.setHeader("DELETE EXISTING USER");
									String deleteUser = Helper.readString("Enter userID to delete: ");
									
									boolean deleted = false;
									for (int i = 0; i < administrators.size(); i++) {
										Administrator a = administrators.get(i);
										if (a.getUserId().equals(deleteUser)) { //check against list
											administrators.remove(i); //remove from list
											deleted = true;
											break;
										}
									}
									
									if (deleted == true) { //print message
										System.out.println("UserID: " + deleteUser + " has been deleted successfully!");
									} else {
										System.out.println("UserID: " + deleteUser + " cannot be found!");
									}
								}
								
							}
							
						}
						else if(optionA == ADMIN_OPTION_COURSE) {
						//code for course
							int optionC = 0;
							while(optionC != ADMIN_COURSE_QUIT) {
									TuitionManagement.courseTypeMenu();
									optionC = Helper.readInt("Enter an option > ");
						
									if(optionC == ADMIN_COURSE_ADD) {
										TuitionManagement.setHeader("ADD A NEW COURSE");
							
										String courseId = Helper.readString("Enter Course ID: ");
										String courseName = Helper.readString("Enter Course Name: ");
										String courseDescription = Helper.readString("Enter Course Description: ");
										String courseEligibility = Helper.readString("Enter Course Eligibility Criteria: "); // added eligibility - ella
										String schedule = Helper.readString("Enter Course Schedule: ");

										// Create a new Course object with user input
										Course newCourse = new Course(courseId, courseName, courseDescription, courseEligibility, schedule);

										// Add the new course to the ArrayList
										courseList.add(newCourse);

										// Print a success message
										System.out.println("Course added successfully!");
							
									}else if(optionC == ADMIN_COURSE_VIEW) {
										TuitionManagement.setHeader("VIEW ALL COURSE");
										System.out.println("ALL COURSES:");
										Helper.line(120, "-");
										System.out.println("Course Course\tCourse Name\t\tDescription\t\t\tSchedule"); //need to add eligibility
										Helper.line(120, "-");
										for (Course course : courseList) {
											String courseId = course.getCourseCode();
											String courseName = course.getCourseTitle();
											//add eligibility
											String courseDescription = course.getCourseDesc();
											String schedule = course.getSchedule();

											System.out.printf("%-10s\t%-20s\t%-30s\t%-20s%n", courseId, courseName, courseDescription, schedule);
										}
										Helper.line(120, "-");
									}
									else if(optionC == ADMIN_COURSE_DELETE) {
										TuitionManagement.setHeader("VIEW ALL COURSE");
										String courseIdToDelete = Helper.readString("Enter the Course ID to delete:");

										// Delete the course with the given course ID
										boolean courseDeleted = false;
										for (int i = 0; i < courseList.size(); i++) {
											Course course = courseList.get(i);
											if (course.getCourseCode().equals(courseIdToDelete)) {
												courseList.remove(i);
												courseDeleted = true;
												break;
											}
										}

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
							while(optionD != ADMIN_STUDENT_QUIT) {
									TuitionManagement.studentTypeMenu();
									optionD = Helper.readInt("Enter an option > ");
						
									if(optionD == ADMIN_STUDENT_ADD) {
										TuitionManagement.setHeader("ADD A NEW STUDENT");
							
										String studentID = Helper.readString("Enter User ID: ");
										String studentPassword = Helper.readString("Enter a password: ");
										String studentName = Helper.readString("Enter User Name: ");
										int studentNumber = Helper.readInt("Enter User Contact Number: ");
										String studentEmail = Helper.readString("Enter User Email: ");
										

										// Create a new Student object with user input
										Student newStudent = new Student(studentID, studentPassword, studentName, studentNumber, studentEmail);

										// Add the new student to the ArrayList
										students.add(newStudent);

										// Print a success message
										System.out.println("Student added successfully!");
							
									}else if(optionD == ADMIN_STUDENT_VIEW) {
										TuitionManagement.setHeader("VIEW ALL STUDENT");
										System.out.println("ALL STUDENTS:");
										Helper.line(120, "-");
										System.out.println(String.format("%-10s %20s %20s %20s\n", "STUDENT ID", "STUDENT NAME", "STUDENT NUMBER", "STUDENT EMAIL")); //need to add eligibility
										Helper.line(120, "-");
										for (Student student : students) {
											String studentId = student.getUserId();
											String studentName = student.getName();
											//add eligibility
											int studentNumber = student.getNumber();
											String studentEmail = student.getEmail();

											System.out.printf("%-10s\t%-20s\t%-30s\t%-20s%n", studentId, studentName, studentNumber, studentEmail);
										}
										Helper.line(120, "-");
									}
									else if(optionD == ADMIN_COURSE_DELETE) {
										TuitionManagement.setHeader("DELETE EXISTING USER");
										String deleteUser = Helper.readString("Enter studentID to delete: ");
										
										boolean deleted = false;
										for (int i = 0; i < students.size(); i++) {
											Student s = students.get(i);
											if (s.getUserId().equals(deleteUser)) { //check against list
												students.remove(i); //remove from list
												deleted = true;
												break;
											}
										}

										// Print the result of the delete operation
										if (deleted) {
											System.out.println("Course with ID " + deleteUser + " has been deleted.");
										} else {
											System.out.println("Course with ID " + deleteUser + " not found.");
										}
									}
							}
						
						}
						else if (optionA == ADMIN_OPTION_FEE) {
							//code for Fee Management
						}
						else if (optionA == ADMIN_OPTION_ENROLMENT) {
							//code for Enrolmant Management
						}
						else if(optionA == ADMIN_OPTION_ATTENDANCE) {
							//code for Attendance
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
	
	 public static void adminmenu() {
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
	 public static void loginmenu() {
			TuitionManagement.setHeader("WELCOME TO TUITION MANAGEMENT!");
			System.out.println("1. Admin Login");
			System.out.println("2. Student Login");
			System.out.println("3. Teacher Login");
			System.out.println("4. Leave... ");
			
			Helper.line(80, "-");

		}


	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	public static void courseTypeMenu() { 
		TuitionManagement.setHeader("COURSE MANAGEMENT");
		System.out.println("1. Add a new Course");
		System.out.println("2. View all Courses");
		System.out.println("3. Delete an existing Course");
		System.out.println("4. Update an existing Course");
		System.out.println("5. Quit ");
		Helper.line(80, "-");
		
	}
	public static void userTypeMenu() { 
		TuitionManagement.setHeader("USER MANAGEMENT");
		System.out.println("1. Add a new user");
		System.out.println("2. View all user");
		System.out.println("3. Delete an existing user");
		System.out.println("4. Quit");
		Helper.line(80, "-");
		
	}
	public static void studentTypeMenu() { 
		TuitionManagement.setHeader("STUDENT MANAGEMENT");
		System.out.println("1. Add a new Student");
		System.out.println("2. View all Students");
		System.out.println("3. Delete an existing Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");
		
	}
	

	}


