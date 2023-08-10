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
	private Enrolment e1;
	private Fee fee1;
	private Fee fee2;

	private ArrayList<Student> students;
	private ArrayList<Administrator> administrators;
	private ArrayList<Teacher> teachers;
	private ArrayList<Course> courseList;
	private ArrayList<Enrolment> enrolmentList;
	private ArrayList<Fee> feeList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		s1 = new Student("student1", "student123", "Student 1", 81122334, "student1@example.com", "Programming experience");
		s2 = new Student("student2", "student456", "Student 2", 81222334, "student2@example.com", "Programming experience");
		a1 = new Administrator("admin1", "admin123", "Administrator 1", 91122334, "admin1@example.com");
		a2 = new Administrator("admin2", "admin456", "Administrator 2", 92233445, "admin2@example.com");
		t1 = new Teacher("teacher1", "teacher123", "Teacher 1", 81122334, "teacher1@example.com");
		t2 = new Teacher("teacher2", "teacher456", "Teacher 2", 82233445, "teacher2@example.com");
		c1 = new Course("CS101", "Java Corp", "The Journey of Java", "Programming experience", 20, "Mon, Wed 10:00 AM - 11:30 AM");
		c2 = new Course("CS102", "Java Corp 2", "Advanced journey of Java", "Java experience", 40,
				"Tue, Thur 11:00 AM - 12:30 PM");
		e1 = new Enrolment("Student 1", "CS101");
		fee1 = new Fee("F1", "Type1", "2023-08-15", 100.0);
		fee2 = new Fee("F2", "Type2", "2023-08-30", 150.0);

		students = new ArrayList<Student>();
		administrators = new ArrayList<Administrator>();
		teachers = new ArrayList<Teacher>();
		courseList = new ArrayList<Course>();
		enrolmentList = new ArrayList<Enrolment>();
		feeList = new ArrayList<Fee>();
	}

	@Test
	// test add user(administrator)
	public void testAddUser() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid User arraylist to add to", students);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as the same as the first item of the list
		TuitionManagement.addUser(administrators, a1);
		assertEquals("Check that administrators arrayList size is 1,", 1, administrators.size());
		assertSame("Check that Administrator is added,", a1, administrators.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		TuitionManagement.addUser(administrators, a2);
		assertEquals("Test that Administrator is added,", a2, administrators.get(1));

	}

	@Test
	public void testAddStudent() { // weile
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid User arraylist to add to", administrators);
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as the same as the first item of the list
		TuitionManagement.addStudent(students, s1);
		assertEquals("Check that students arrayList size is 1,", 1, students.size());
		assertSame("Check that Student is added,", s1, students.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		TuitionManagement.addStudent(students, s2);
		assertEquals("Test that Student is added,", s2, students.get(1));
	}

	@Test
	public void testAddTeacher() {

	}

	@Test
	public void testAddCourse() {//jia an
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid Course arraylist to add to", courseList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as the same as the first item of the list
		TuitionManagement.addCourse(courseList, c1);
		assertEquals("Check that courseList arrayList size is 1,", 1, courseList.size());
		assertSame("Check that Course is added,", c1, courseList.get(0));

		// Add another item. Test if the size of the list is 2? - normal
		// The item just added is as same as the second item of the list
		TuitionManagement.addCourse(courseList, c2);
		assertEquals("Test that Course is added,", c2, courseList.get(1));
	}

	@Test
	public void testAddFee() { // donovan

		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is a valid Fee arraylist to add to", feeList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is the same as the first item of the list
		TuitionManagement.addFee(feeList, fee1);
		assertEquals("Check that feeList arrayList size is 1,", 1, feeList.size());
		assertSame("Check that Fee is added,", fee1, feeList.get(0));

		// Add another item. Test if the size of the list is 2? - normal
		// The item just added is the same as the second item of the list
		TuitionManagement.addFee(feeList, fee2);
		assertEquals("Test that Fee is added,", fee2, feeList.get(1));
	}

	@Test
	public void testRetrieveUser() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Administrator arraylist to retrieve the item", administrators);

		// test if the list of administrator retrieved from the SourceCentre is empty -
		// boundary
		String allAdministrator = TuitionManagement.retrieveUser(administrators);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed,", testOutput, allAdministrator);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		TuitionManagement.addUser(administrators, a1);
		TuitionManagement.addUser(administrators, a2);
		assertEquals("Test that Administrator arraylist size is 2", 2, administrators.size());

		// test if the expected output string same as the list of Administrator
		// retrieved from the SourceCentre
		allAdministrator = TuitionManagement.retrieveUser(administrators);
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "admin1", "admin123", "Administrator 1", 91122334,
				"admin1@example.com");
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "admin2", "admin456", "Administrator 2", 92233445,
				"admin2@example.com");

		assertEquals("Test that ViewUser list", testOutput, allAdministrator);

	}

	@Test
	public void testRetrieveStudent() { // weile
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve the item", students);

		// test if the list of student retrieved from the SourceCentre is empty -
		// boundary
		String allStudent = TuitionManagement.retrieveStudent(students);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allStudent);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		TuitionManagement.addStudent(students, s1);
		TuitionManagement.addStudent(students, s2);
		assertEquals("Test that Student arraylist size is 2", 2, students.size());

		// test if the expected output string same as the list of Student retrieved from
		// the SourceCentre
		allStudent = TuitionManagement.retrieveStudent(students);
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "student1", "Student 1", 81122334,
				"student1@example.com");
		testOutput += String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "student2", "Student 2", 81222334,
				"student2@example.com");

		assertEquals("Test that ViewStudent list", testOutput, allStudent);
	}

	@Test
	public void testRetrieveTeacher() {

	}

	@Test
	public void testRetrieveCourse() {//jia an
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Course arraylist to retrieve the item", courseList);

		// Test if the list of courses retrieved from the SourceCentre is empty -
		// boundary
		String allCourses = TuitionManagement.retrieveCourses(courseList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allCourses);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		courseList.add(c1);
		courseList.add(c2);
		assertEquals("Test that Course arraylist size is 2", 2, courseList.size());

		// Test if the expected output string is the same as the list of courses
		// retrieved from the SourceCentre
		allCourses = TuitionManagement.retrieveCourses(courseList);
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s\t%-12d\t%-20s%n", "CS101", "Java Corp",
				"The Journey of Java", "", 20, "Mon, Wed 10:00 AM - 11:30 AM");
		testOutput += String.format("%-10s\t%-20s\t%-30s\t%-20s\t%-12d\t%-20s%n", "CS102", "Java Corp 2",
				"Advanced journey of Java", "NA level", 40, "Tue, Thur 11:00 AM - 12:30 PM");

		assertEquals("Test that ViewCourse list", testOutput, allCourses);

	}

	@Test
	public void testRetrieveFee() { // donovan
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid fee arraylist to retrieve the item", feeList);

		// Test if the list of fees retrieved from the SourceCentre is empty - boundary
		String allfees = TuitionManagement.retrieveFee(feeList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allfees);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		TuitionManagement.addFee(feeList, fee1);
		TuitionManagement.addFee(feeList, fee2);
		assertEquals("Test that Course arraylist size is 2", 2, feeList.size());

		// Test if the expected output string is the same as the list of fees retrieved
		// from the SourceCentre
		allfees = TuitionManagement.retrieveFee(feeList);
		testOutput = String.format("%-12s\t %-20s\t %-16s\t %-10.2f%n", "F1", "Type1", "2023-08-15", 100.0);
		testOutput += String.format("%-12s\t %-20s\t %-16s\t %-10.2f%n", "F2", "Type2", "2023-08-30", 150.0);

		assertEquals("Test that ViewFee list", testOutput, allfees);
	}

	@Test
	public void testDeleteUser() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Administrator arraylist to delete a student", administrators);

		// test if the list of users retrieved from the SourceCentre is the same as
		// expected output
		String testOutput = "";
		String testOutput2 = "";
		TuitionManagement.addUser(administrators, a1);
		TuitionManagement.addUser(administrators, a2);
		String allUser = TuitionManagement.retrieveUser(administrators);
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "admin1", "admin123", "Administrator 1", 91122334,
				"admin1@example.com");
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "admin2", "admin456", "Administrator 2", 92233445,
				"admin2@example.com");

		// Test if the output is empty
		assertEquals(
				"Test that the expected output string is same as the list of administrators retrieved from the SourceCentre",
				testOutput, allUser);

		// Given a list, after deleting 1 item, test that the arraylist has -1 item
		TuitionManagement.deleteUser(administrators, a2.getUserId());
		assertEquals("Test that Administrator arraylist size is 1", 1, administrators.size());

		// test if the expected output string same as the list of Student retrieved from
		// the SourceCentre
		allUser = TuitionManagement.retrieveUser(administrators);

		testOutput2 += String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "admin1", "admin123", "Administrator 1", 91122334,
				"admin1@example.com");

		assertEquals("Test that ViewUser list", testOutput2, allUser);
	}

	@Test
	public void testDeleteStudent() { // weile
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to delete a student", students);

		// test if the list of student retrieved from the SourceCentre is the same as
		// expected output
		String testOutput = "";
		String testOutput2 = "";
		TuitionManagement.addStudent(students, s1);
		TuitionManagement.addStudent(students, s2);
		String allStudent = TuitionManagement.retrieveStudent(students);
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "student1", "Student 1", 81122334,
				"student1@example.com");
		testOutput += String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "student2", "Student 2", 81222334,
				"student2@example.com");

	
		assertEquals(
				"Test that the expected output string is same as the list of students retrieved from the SourceCentre",
				testOutput, allStudent);

		// Given a list, after deleting 1 item, test that the arraylist has -1 item
		TuitionManagement.deleteStudent(students, s2.getUserId());
		assertEquals("Test that Student arraylist size is 1", 1, students.size());

		// test if the expected output string same as the list of Student retrieved from
		// the SourceCentre
		allStudent = TuitionManagement.retrieveStudent(students);

		testOutput2 += String.format("%-10s\t%-20s\t%-30s\t%-20s%n", "student1", "Student 1", 81122334,
				"student1@example.com");

		assertEquals("Test that ViewStudent list", testOutput2, allStudent);

	}

	@Test
	public void testDeleteTeacher() {

	}

	@Test
	public void testDeleteCourse() {//jia an

		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Course arraylist to delete a course", courseList);

		// Test if the list of courses retrieved from the SourceCentre is the same as
		// expected output
		String testOutput = "";
		String testOutput2 = "";
		courseList.add(c1);
		courseList.add(c2);
		String allCourses = TuitionManagement.retrieveCourses(courseList);
		testOutput = String.format("%-10s\t%-20s\t%-30s\t%-20s\t%-12d\t%-20s%n", "CS101", "Java Corp",
				"The Journey of Java", "", 20, "Mon, Wed 10:00 AM - 11:30 AM");
		testOutput += String.format("%-10s\t%-20s\t%-30s\t%-20s\t%-12d\t%-20s%n", "CS102", "Java Corp 2",
				"Advanced journey of Java", "NA level", 40, "Tue, Thur 11:00 AM - 12:30 PM");

		// Test if the output is empty
		assertEquals(
				"Test that the expected output string is same as the list of courses retrieved from the SourceCentre",
				testOutput, allCourses);

		// Given a list, after deleting 1 item, test that the arraylist has -1 item
		TuitionManagement.deleteCourse(courseList, c2.getCourseCode());
		assertEquals("Test that Course arraylist size is 1", 1, courseList.size());

		// Test if the expected output string same as the list of courses retrieved from
		// the SourceCentre
		allCourses = TuitionManagement.retrieveCourses(courseList);

		testOutput2 += String.format("%-10s\t%-20s\t%-30s\t%-20s\t%-12d\t%-20s%n", "CS101", "Java Corp",
				"The Journey of Java", "", 20, "Mon, Wed 10:00 AM - 11:30 AM");

		assertEquals("Test that ViewCourse list", testOutput2, allCourses);
	}

	@Test
	public void testDeletefee() {//donovan
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Fee arraylist to delete a Fee", feeList);

		// Test if the list of fees retrieved from the SourceCentre is the same as
		// expected output
		String testOutput = "";
		String testOutput2 = "";
		feeList.add(fee1);
		feeList.add(fee2);
		String allfees = TuitionManagement.retrieveFee(feeList);
		testOutput = String.format("%-12s\t %-20s\t %-16s\t %-10.2f%n", "F1", "Type1", "2023-08-15", 100.0);
		testOutput += String.format("%-12s\t %-20s\t %-16s\t %-10.2f%n", "F2", "Type2", "2023-08-30", 150.0);

		// Test if the output is empty
		assertEquals("Test that the expected output string is same as the list of fees retrieved from the SourceCentre",
				testOutput, allfees);

		// Given a list, after deleting 1 item, test that the arraylist has -1 item
		TuitionManagement.deleteFee(feeList, fee2.getFeeID());
		assertEquals("Test that fee arraylist size is 1", 1, feeList.size());

		// Test if the expected output string same as the list of fees retrieved from
		// the SourceCentre
		allfees = TuitionManagement.retrieveFee(feeList);

		testOutput2 += String.format("%-12s\t %-20s\t %-16s\t %-10.2f%n", "F1", "Type1", "2023-08-15", 100.0);

		assertEquals("Test that Viewfee list", testOutput2, allfees);

	}

	// ---------- Test Enrollment ----------------------------

	@Test
	public void testDoAddEnrolment() {
		// List not null so that can add a new item - boundary testing
		assertNotNull("Check if there is valid Enrolment array list to add to", enrolmentList);

		// Test that item added into array list should increase the size of the empty
		// array list
		TuitionManagement.doAddEnrolment(enrolmentList, e1);
		assertEquals("Check that Enrolment arraylist size is 1", 1, enrolmentList.size());

		// Test that item is the added is the same as the first item of the list
		assertSame("Check that Enrolment is added", e1, enrolmentList.get(0));
	}

	@Test
	public void testRetrieveAllEnrolment() {
		// List not null so that can add a new item - boundary testing
		assertNotNull("Check if there is valid Enrolment array list to add to", enrolmentList);

		// Test that list of enrolment is empty
		String allEnrolment = TuitionManagement.retrieveAllEnrolment(enrolmentList);
		String testOutput = "";
		assertEquals("Check that enrolment list is empty", testOutput, allEnrolment);

		// Test that the empty list size is 1 when added 1 item
		TuitionManagement.doAddEnrolment(enrolmentList, e1);
		assertEquals("Test that Enrolment arraylist size is 1", 1, enrolmentList.size());

		// test if the expected output string is the same as the list of enrolments
		// retrieved
		allEnrolment = TuitionManagement.retrieveAllEnrolment(enrolmentList);
		testOutput = String.format("%-15s %-10s\n", "Student 1", "CS101");
		assertEquals("Test that output retrieveAllEnrolment output is the same as expected", testOutput, allEnrolment);

	}

	@Test
	public void testDoDeleteEnrolment() {
		// List not null so that can add a new item - boundary testing
		assertNotNull("Check if there is valid Enrolment array list to add to", enrolmentList);

		// Test that the empty list size is 1 when added 1 item
		TuitionManagement.doAddEnrolment(enrolmentList, e1);
		assertEquals("Test that Enrolment arraylist size is 1", 1, enrolmentList.size());

		// test if the expected output string is the same as the list of enrolments
		// retrieved
		String allEnrolment = TuitionManagement.retrieveAllEnrolment(enrolmentList);
		String testOutput = String.format("%-15s %-10s\n", "Student 1", "CS101");
		assertEquals("Test that output retrieveAllEnrolment output is the same as expected", testOutput, allEnrolment);

		// test that output is empty when item is deleted
		TuitionManagement.doDeleteEnrolment(enrolmentList, e1.getStudentName());
		allEnrolment = TuitionManagement.retrieveAllEnrolment(enrolmentList);
		testOutput = "";
		assertEquals("Test that output retrieveAllEnrolment output is empty as expected", testOutput, allEnrolment);

		// test that list is empty and size is 0
		assertEquals("Test that Enrolment arraylist size is 0", 0, enrolmentList.size());
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
		e1 = null;
	}
}
