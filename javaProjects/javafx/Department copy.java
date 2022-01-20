import java.io.Serializable;

//   Assignment: ASU CSE205 Spring 2021 #8
//         Name:Robert Ayala
//    StudentID:1218583093
//      Lecture: T/Th 9-10:15
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. //---- is where you should add your own code

public class Department implements Serializable
{
	//private instance variables
	private String deptName, university;
	private int numOfMembers;
	private Faculty currentFaculty;

	//constructor
	public Department(String deptName, String university, int numOfMembers,
					String firstName, String lastName, String academicLevel)
	{
		this.deptName = deptName;
		this.university = university;
		this.numOfMembers = numOfMembers;
		currentFaculty = new Faculty(firstName, lastName, academicLevel);
	}

	public String getDeptName() {
		return deptName;
	}

	//return university
	public String getUniversity() {
		return university;
	}

	public int getNumOfMembers() {
		return numOfMembers;
	}

	public Faculty getFaculty() {
		return currentFaculty;
	}

	public void setDeptName(String a) {
		deptName = a;
	}

	public void setNumOfMembers(int a) {
		numOfMembers = a;
	}

	public void setUniversity(String a) {
		university = a;
	}

	public void setFaculty(String firstName, String lastName, String academicLevel) {
		currentFaculty.setFirstName(firstName);
		currentFaculty.setLastName(lastName);
		currentFaculty.setAcademicLevel(academicLevel);
	}

	//return a string in a specified format
	public String toString() {
		return "\nDept. Name:\t\t" + deptName + "\n"
				+ "University:\t\t" + university + "\n"
				+ "# of Members:\t" + numOfMembers + "\n"
				+ "Faculty:\t\t" + currentFaculty.toString() + "\n";
	}
}
