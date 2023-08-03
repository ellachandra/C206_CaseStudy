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
	private static final int OPTION_QUIT = 7;// jia an
	private static final int OPTION_USER = 1;// jia an
	private static final int OPTION_COURSE = 2;// jia an
	private static final int OPTION_STUDENT = 3;// jia an
	private static final int OPTION_FEE = 4;// jia an
	private static final int ITEM_TYPE_ENROLMENT = 5;// jia an
	private static final int ITEM_TYPE_Attendence = 6; // jia an

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Administrator admin = new Administrator("admin123", "John Doe", "john.doe@example.com");
		 
		 ArrayList<Course> courseList = new ArrayList<Course>();
		
		 Course c1 = new Course("CS101", "Java Corp", "The Journey of Java", "Mon, Wed 10:00 AM - 11:30 AM");
		 courseList.add(c1);
	
	
			int option = 0;

			while (option != OPTION_QUIT) {// jia an

				TuitionManagement.menu();
				option = Helper.readInt("Enter an option > ");
			}
	
	
	
	
	
	
	
	
		 

			}
	
	 public static void menu() {
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
		
	}
	public static void userTypeMenu() { 
		TuitionManagement.setHeader("USER MANAGEMENT");
		System.out.println("1. Add a new user");
		System.out.println("2. View all user");
		System.out.println("3. Delete an existing user");
		
	}
	

	}


