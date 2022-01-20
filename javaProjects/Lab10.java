package com.vogella.eclipse.ide.first;

//AUTHOR: Rishi Vadrevu
//FILENAME: Lab10
//SPECIFICATION: Read input files and iterate them through array.
//FOR: CSE 110 - Lab #10
//TIME SPENT: 1.5 hours

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Accompanied by Student.java

public class Lab10 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		final int NUM_STUDENTS = 10;
		Student[] gradebook = new Student[NUM_STUDENTS];

		FileReader fr = new FileReader("/Users/rishi/Downloads/lab10_student_data.txt");
		BufferedReader br = new BufferedReader(fr);
		for(int i = 0; i < NUM_STUDENTS; i++) {
			String line = "";
			System.out.println(line);
			line = br.readLine();
		
			String fullname = line.substring(0, line.indexOf(","));
			String id = line.substring(line.indexOf(",") + 1, line.lastIndexOf(","));
			double grade = Double.parseDouble(line.substring(line.lastIndexOf(",")+1,line.lastIndexOf(",")+3));
			System.out.print("Read #" + (i+1) + ": " + fullname + " " + id);
			gradebook[i] = new Student(fullname, id, grade);
		}
		
		br.close();
		System.out.println();
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < NUM_STUDENTS; i++) {
			for(int j = i + 1; j < NUM_STUDENTS; j++) {
				if(gradebook[i].equals(gradebook[j])) {
				System.out.printf("\"%s\" and \"%s\": %s\n", gradebook[i].getFullname(), gradebook[j].getFullname(), gradebook[i].getID());
				}
			}
		}
	}

}
