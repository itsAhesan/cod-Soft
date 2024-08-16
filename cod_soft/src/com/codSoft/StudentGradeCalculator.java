package com.codSoft;

import java.util.Scanner;

public class StudentGradeCalculator {

	public static void main(String[] args) throws Exception {
		
		 Scanner scanner = new Scanner(System.in);
	        
	        // Ask the user for the number of subjects
	        System.out.print("Enter the number of subjects: ");
	        int numSubjects = scanner.nextInt();
	        
	        // Create an array to store the marks
	        int[] marks = new int[numSubjects];
	        
	        // Input marks for each subject
	        for (int i = 0; i < numSubjects; i++) {
	            System.out.print("Enter marks for subject " + (i + 1) + ": ");
	            marks[i] = scanner.nextInt();
	            if (marks[i]>=101) {
					throw new Exception("Enter valid marks");
				}
	        }
	        
	        // Calculate total marks
	        int totalMarks = calculateTotalMarks(marks);
	        
	        // Calculate average percentage
	        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
	        
	        // Calculate grade
	        char grade = calculateGrade(averagePercentage);
	        
	        // Display results
	        System.out.println("Total Marks: " + totalMarks);
	        System.out.println("Average Percentage: " + averagePercentage + "%");
	        System.out.println("Grade: " + grade);
	        
	        scanner.close();
	    }

	    public static int calculateTotalMarks(int[] marks) {
	        int total = 0;
	        for (int mark : marks) {
	            total += mark;
	        }
	        return total;
	    }

	    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
	        return (double) totalMarks / numSubjects;
	    }

	    public static char calculateGrade(double averagePercentage) {
	        if (averagePercentage >= 90) {
	            return 'A';
	        } else if (averagePercentage >= 80) {
	            return 'B';
	        } else if (averagePercentage >= 70) {
	            return 'C';
	        } else if (averagePercentage >= 60) {
	            return 'D';
	        } else {
	            return 'F';
	        }
	    }
		

	

}
