package com.codSoft.student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementUI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManagementSystem sms = new StudentManagementSystem();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. Edit Student");
        System.out.println("3. Search Student");
        System.out.println("4. Display All Students");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear the invalid input
        }
        return choice;
    }

    private static void addStudent() {
        scanner.nextLine(); // clear the newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // clear the newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        if (validateInput(name, rollNumber, grade)) {
            Student student = new Student(name, rollNumber, grade);
            sms.addStudent(student);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Invalid input. Student not added.");
        }
    }

    private static void editStudent() {
        System.out.print("Enter roll number of the student to edit: ");
        int rollNumber = scanner.nextInt();
        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            scanner.nextLine(); // clear the newline
            System.out.print("Enter new name (leave blank to keep current): ");
            String name = scanner.nextLine();
            System.out.print("Enter new grade (leave blank to keep current): ");
            String grade = scanner.nextLine();

            if (!name.isEmpty()) {
                student.setName(name);
            }
            if (!grade.isEmpty()) {
                student.setGrade(grade);
            }

            System.out.println("Student updated successfully.");
            
            sms.writeToFile();
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int rollNumber = scanner.nextInt();
        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        System.out.println("All Students:");
        for (Student student : sms.getAllStudents()) {
            System.out.println(student);
        }
    }

    private static boolean validateInput(String name, int rollNumber, String grade) {
        return !(name.isEmpty() || rollNumber <= 0 || grade.isEmpty());
    }
}

