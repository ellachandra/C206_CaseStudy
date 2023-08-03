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




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 Administrator admin = new Administrator("admin123","p4ssword", "John Doe", "john.doe@example.com");
		 
		ArrayList<Administrator> administrators = new ArrayList<>();
        administrators.add(new Administrator("admin1", "admin123", "Administrator 1", "admin1@example.com"));
        administrators.add(new Administrator("admin2", "admin456", "Administrator 2", "admin2@example.com"));
        administrators.add(new Administrator("admin3", "admin789", "Administrator 3", "admin3@example.com"));
        administrators.add(new Administrator("admin4", "adminabc", "Administrator 4", "admin4@example.com"));

		 ArrayList<Course> courseList = new ArrayList<Course>();
		
		 Course c1 = new Course("CS101", "Java Corp", "The Journey of Java", "Mon, Wed 10:00 AM - 11:30 AM");
		 courseList.add(c1);
	
	
			int option = 0;

			while (option != NO_LOGIN) {// jia an

				TuitionManagement.loginmenu();
				option = Helper.readInt("Enter an option > ");
			
			
			if (option == ADMIN_LOGIN) {
				// Code to Login for admin
				boolean loginSuccessful = false;
				String inputUserId = Helper.readString("Enter your userID:");
                String inputPassword = Helper.readString("Enter your password:");
				
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
					
					if(optionA == ADMIN_OPTION_USER ) {
						//code for user
					}
					else if(optionA == ADMIN_OPTION_COURSE) {
						//code for course
						int optionC = 0;
						while(optionC != ADMIN_COURSE_QUIT) {
						TuitionManagement.courseTypeMenu();
						optionC = Helper.readInt("Enter an option > ");
						
						if(optionC == ADMIN_COURSE_ADD) {
							TuitionManagement.setHeader("ADD A NEW COURSE");
							boolean added = false;
							String courseId = Helper.readString("Enter Course ID:");
				            String courseName = Helper.readString("Enter Course Name:");
				            String courseDescription = Helper.readString("Enter Course Description:");
				            String schedule = Helper.readString("Enter Course Schedule:");

				            // Create a new Course object with user input
				            Course newCourse = new Course(courseId, courseName, courseDescription, schedule);

				            // Add the new course to the ArrayList
				            courseList.add(newCourse);

				            // Print a success message
				            System.out.println("Course added successfully!");
							
						}else if(optionC == ADMIN_COURSE_VIEW) {
							TuitionManagement.setHeader("VIEW ALL COURSE");
							 System.out.println("ALL COURSES:");
					            System.out.println("------------------------------------------------------------");
					            System.out.println("Course ID\tCourse Name\t\tDescription\t\t\tSchedule");
					            System.out.println("------------------------------------------------------------");
					            for (Course course : courseList) {
					                String courseId = course.getCourseCode();
					                String courseName = course.getCourseTitle();
					                String courseDescription = course.getCourseDesc();
					                String schedule = course.getSchedule();

					                System.out.printf("%-10s\t%-20s\t%-30s\t%-20s%n", courseId, courseName, courseDescription, schedule);
					            }
					            System.out.println("------------------------------------------------------------");
					        }
					    }
							
						}
					else if (optionA == ADMIN_OPTION_STUDENT) {
						//code for Student Management
						
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
			TuitionManagement.setHeader("WELCOME TO SAINT TUITION!");
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
		
	}
	public static void userTypeMenu() { 
		TuitionManagement.setHeader("USER MANAGEMENT");
		System.out.println("1. Add a new user");
		System.out.println("2. View all user");
		System.out.println("3. Delete an existing user");
		
	}
	

	}


