package com.vogella.eclipse.ide.first;

public class Student {
	private String Fullname, asuID;
	private int numOfUpdates;
	private int numOfAccessed;
	private double grade;
	
	public Student() {
		this.Fullname = "";
		this.asuID = null;
		this.grade = -1.00;
		this.numOfAccessed++;
	}
	
	public Student(String Fullname, String asuID, double grade) {
		this.asuID = asuID;
		this.Fullname = Fullname;
		this.numOfAccessed++;
		this.grade = grade;
	}
	
	public String getFullname() {
		this.numOfAccessed++;
		return Fullname;
	}
	
	public void setName(String n) {
		this.numOfUpdates++;
		Fullname = n;
	}
	
	public double getGrade() {
		this.numOfAccessed++;
		return grade;
	}
	
	public void setGrade(double g) {
		grade = g;
		this.numOfUpdates++;
	}
	
	public String getID() {
		this.numOfAccessed++;
		return asuID;
	}
	
	public void setId(String a) {
		asuID = a;
		this.numOfUpdates++;
	}
	
	public int getNumOfUpdates() {
		this.numOfAccessed++;
		return numOfUpdates;
	}
	
	public int getNumOfAccessed() {
		return numOfAccessed;
	}
	
	public boolean equals(Student other) {
		boolean state;
		if(asuID.equals(other.asuID)) {
			state = true;
		}
		else if(Fullname.toUpperCase().equals(other.Fullname.toUpperCase())) {
			state = true;
		}
		
		else {
			state = false;
		}
		return state;
	}
	
	public String toString() {
		this.numOfAccessed++;
		return "[Name: " + Fullname + ", AsuID: " + asuID + ", Grade: " + grade + " ]";
	}
	
	

}
