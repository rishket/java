package com.vogella.eclipse.ide.first;

import java.util.Arrays;

//CSE 110
//Assignment: 6
// Author: Rishi Vadrevu
// Description: Assignment6.java
public class Assignment6 {

	public static void main(String[] args) {
		int[] array = {23, 45, 25, 56, 75, 87};
		
		printArray(array, ", ");
	}
	
	public static String printArray(int[] array, String b) {
		String iterate = "";
		for(int i = 0; i < array.length; i++) {
			iterate += array[i];
			iterate += b;
		}
		return iterate;
	}
	
	public static int getFirst(int[] array) {
		int firstVal = array[0];
		return firstVal;
	}
	
	public static int getLast(int[] array) {
		int lastVal = array[array.length - 1];
		return lastVal;
	}
	
	public static int[] getAllButFirst(int[] array) {
		int[] newArray = new int[0];
		for(int i = 0; i< array.length; i++) {
			newArray[i] = array[i+1];
		}
		return newArray;
	}
	
	public static int getIndexOfMin(int[] array) {
		int smallestValue = array[0];
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if (array[i] < smallestValue) {
				smallestValue = array[i];
				index = 0;
			}
		}
		return index;
	}
	
	public static int getIndexOfMax(int[] array) {
		int largestValue = array[0];
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if (array[i] > largestValue) {
				largestValue = array[i];
				index = i;
			}
		}
		return index;
	}
	
	public static int[] swapByIndex(int[] array, int a, int b) {
		int length = array.length;
		int[] newArray = Arrays.copyOf(array, length);
		int c = array[a];
		newArray[a] = newArray[b];
		newArray[b] = c;
		return newArray;
	}
	
	public static int[] removeAtIndex(int[] array, int a) {
		int position = a;
		int length = array.length - 1;
		int[] newArray = Arrays.copyOf(array, length);
		for(int i = 0; i < array.length; i++) {
			newArray[i-1] = array[i];
		}
		return newArray;
	}
	
	public static int[] insertAtIndex(int[] array, int a, int number) {
		int length = array.length-1;
		int position = a; 
		int[] newArray = Arrays.copyOf(array, length);
		for(int i = length - 1; i > position; i--) {
			newArray[i] = newArray[i-1];
		}
		newArray[position] = number;
		return newArray;
	}
	
	public static boolean isSorted(int[] array) {
		for(int i = 0; i < array.length-1; i++) {
			if(array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}

}
