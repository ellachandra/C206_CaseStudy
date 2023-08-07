import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Student s1;
	private Student s2;
	private Administrator a1;
	private Administrator a2;
	private Teacher t1;
	private Teacher t2;
	private Course c1;
	private Course c2;
	
	private ArrayList<Student> students;
	private ArrayList<Administrator> administrators;
	private ArrayList<Teacher> teachers;
	private ArrayList<Course> courseList;
	
	
	public C206_CaseStudyTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		//prepare test data
		s1 = new Student("student1", "student123", "Student 1", 81122334, "student1@example.com");
		s2 = new Student("student2", "student456", "Student 2", 81222334, "student2@example.com");
		a1 = new Administrator("admin1", "admin123", "Administrator 1", 91122334, "admin1@example.com");
		a2 = new Administrator("admin2", "admin456", "Administrator 2", 92233445, "admin2@example.com");
		t1 = new Teacher("teacher1", "teacher123", "Teacher 1", 81122334, "teacher1@example.com");
		t2 = new Teacher("teacher2", "teacher456", "Teacher 2", 82233445, "teacher2@example.com");
		c1 = new Course("CS101", "Java Corp", "The Journey of Java", "", "Mon, Wed 10:00 AM - 11:30 AM");
		c2 = new Course("CS102", "Java Corp 2", "Advanced journey of Java", "Requires CS101", "Tue, Thur 11:00 AM - 12:30 PM");
		
		students = new ArrayList<Student>();
		administrators = new ArrayList<Administrator>();
		teachers = new ArrayList<Teacher>();
		courseList = new ArrayList<Course>();
	}


	@Test
	//test add user(administrator) 
	public void testAddUser() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid User arraylist to add to", administrators);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as the same as the first item of the list
		TuitionManagement.addAdministrator(administrators, a1);
		assertEquals("Check that administrators arrayList size is 1,", 1, administrators.size());
		assertSame("Check that Administrator is added,", a1, administrators.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		TuitionManagement.addAdministrator(administrators, a2);
		assertEquals("Test that Administrator is added,", a2, administrators.get(1));
		
	}
	
	@Test
	public void testAddStudent() {
		
	}
	
	@Test
	public void testAddTeacher() {
		
	}
	
	@Test
	public void testAddCourse() {
		
	}
	
	@Test
	public void testRetrieveUser() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Administrator arraylist to retrieve the item", administrators);
		
		//test if the list of administrator retrieved from the SourceCentre is empty - boundary
		String allAdministrator = TuitionManagement.retrieveUser(administrators);
		String testOutput = "";
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		TuitionManagement.addAdministrator(administrators, a1);
		TuitionManagement.addAdministrator(administrators, a2);
		assertEquals("Test that Administrator arraylist size is 2", 2, administrators.size());
		
		//test if the expected output string same as the list of Administrator retrieved from the SourceCentre	
		allAdministrator = TuitionManagement.retrieveUser(administrators);
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "admin1", "admin123", "Administrator 1", 91122334, "admin1@example.com");
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "admin2", "admin456", "Administrator 2", 92233445, "admin2@example.com");
		
		assertEquals("Test that ViewUser list", testOutput, allAdministrator);
		
	}
	
	@Test
	public void testRetrieveStudent() {
		
	}
	
	@Test
	public void testRetrieveTeacher() {
		
	}
	
	@Test
	public void testRetrieveCourse() {
		
	}
	
	@Test
	public void testDeleteUser() {
		
	}
	
	@Test
	public void testDeleteStudent() {
		
	}
	
	@Test
	public void testDeleteTeacher() {
		
	}
	
	@Test
	public void testDeleteCourse() {
		
	}

	
	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		a1 = null;
		a2 = null;
		t1 = null;
		t2 = null;
		c1 = null;
		c2 = null;
	}
}


