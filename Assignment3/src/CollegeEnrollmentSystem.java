/*
 * Student Name: Subash Sapkota
 * Student Id: C0824340
 */

/*
	Company: Acuity Software
	Job Title: Software Developer
	Job Link: https://ca.indeed.com/viewjob?jk=fb37a2f997aa6c9f&tk=1fl2kkjneo1l4800&from=serp&vjs=3
	Employer Email: hr@acuitysoftware.ca

	Requirements:
		- Software Engineering degree
		- 1+ years of experience in OOP, UML, Modern Language Java, web applications and noSQL databases
		- Good understanding of software modeling using UML
		- Good understanding on all phases of Software Development Life Cycle (SDLC) in agile environment

	Responsibilities: 
		- MVC web application framework, 
		- Work with R&D team, 
		- Product Management to Design, 
		- Implementing with latest User Experience techniques, Design Patterns
		- Work under Agile Environment
		- Software modeling using UML
 */

import java.util.*;

public class CollegeEnrollmentSystem {

	public static void main(String[] args) {
		// Entry point of a program
		System.out.println("Welcome to College Enrollment System.");

	}

}

class StudentADT {
	/*
	 * This class contains the template for Student
	 *  and provides getter and setter methods to access private variables
	 * */
	private String firstname;
	private String lastname;
	private String studentID;
	
	// Getter for Private variables
	public String getStudentFirstname() {
		return this.firstname;
	}
	
	public String getStudentLastname() {
		return this.lastname;
	}
	
	public String getStudentId() {
		return this.studentID;
	}
	
	// Setter for Private variables
	public void setStudentFirstname(String firstName) {
		this.firstname = firstName;
	}
	
	public void setStudentLastname(String lastName) {
		this.lastname = lastName;
	}
	
	public void setStudentId(String studentId) {
		this.studentID = studentId;
	}
	
	public String toString() {
		return "StudentADT Class";
	}
}

class StudentList {
	/*
	 * List of students with cohortId
	 * */
	
    // cohortID is the set of students in one program / term / group
    // cohortID encodes:  programName, Term {1,2,3,4}, group
    // sample cohort name: CSD_term3_group2
	
	
	private ArrayList<StudentADT> studentNames;
	private Cohort cohort;
	
	// Getter
	public ArrayList<StudentADT> getStudentNames() {
		return this.studentNames;
	}
	
	public Cohort getCohortID() {
		return cohort;
	}
		// Setter
	public void setStudentNames(ArrayList<StudentADT> studentNames) {
		this.studentNames = studentNames;
	}
	
	public void setCohortId(Cohort cohort) {
		this.cohort = cohort;
	}
	
	public String toString() {
		return "Students beloning to " + this.cohort.toString();
	}
}

class Course {
	/*
	 * Courses Class containing information about courseID and courseName and its respective ClassRoom information
	 * */
	private String courseID;
	private String courseName;
	private ClassRoom classRoom;
	
	// Getter
	public String getCourseID() {
		return this.courseID;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public ClassRoom getClassRoom() {
		return this.classRoom;
	}
	
	// Setter methods
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	public void setCouseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}
	
	public String toString() {
		return this.courseID + "--" + this.courseName; 
	}
}

class Program {
	/*
	 * This class links program with courses
	 * */
	
	private String programID;
	private String programName;
	private String term;
	private ArrayList<Course> courses;
	
	// Getter
	public String getProgramID() {
		return this.programID;
	}
	public String getProgramName() {
		return this.programName;
	}
	public String getTerm() {
		return this.term;
	}
	public ArrayList<Course> getCourse() {
		return this.courses;
	}
	// Setter
	public void setProgramID(String programId) {
		this.programID = programId;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public void setTerm(String termName) {
		this.term = termName;
	}
	public void setCourse(ArrayList<Course> course) {
		this.courses = course;
	}
	
	public String toString() {
		return this.programName;
	}
}
	

class Cohort {
	/*
	 * This class links cohortID with program
	 * */
	
	private String cohortID;
	private Program program;
		
		// Getter
	public String getCohortID() {
		return this.cohortID;
	}
	public Program getProgram() {
		return this.program;
	}
	
		// Setter
	public void setCohortId(String cohortID) {
		this.cohortID = cohortID;
	}
	public void setStudentNames(Program program) {
		this.program = program;
	}
		
	public String toString() {
		return this.cohortID;
	}
		
}

class ClassRoom {
	/*
	 * This class holds the information of classroom and classId
	 * */
	private String classID;
	private String className;
	
	// Getters
	public String getClassID() {
		return this.classID;
	}
	public String getClassName() {
		return this.className;
	}
	
	// Setters
	public void setClassID(String classId) {
		this.classID = classId;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String toString() {
		return this.className;
	}
}

