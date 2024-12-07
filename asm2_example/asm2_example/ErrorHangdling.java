package asm2_example;
import java.util.Scanner;
import java.util.ArrayList;

class Student {
    int id;
    String name;
    double marks;
    String rank;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = determineRank(marks);
    }

    // Method to determine the student's rank based on marks
    private String determineRank(double marks) {
        if (marks < 5.0) return "Fail";
        if (marks < 6.5) return "Medium";
        if (marks < 7.5) return "Good";
        if (marks < 9.0) return "Very Good";
        return "Excellent";
    }

    // Method to display student information
    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Rank: " + rank);
    }
}

public class ErrorHangdling {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to add a student
    public static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Marks (0-10): ");
            double marks = scanner.nextDouble();

            // Validate marks
            if (marks < 0 || marks > 10) {
                throw new IllegalArgumentException("Marks must be between 0 and 10.");
            }

            studentList.add(new Student(id, name, marks));
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();  // Consume invalid input
        }
    }

    // Method to edit a student
    public static void editStudent() {
        try {
            System.out.print("Enter Student ID to edit: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Student student = findStudentById(id);
            if (student == null) {
                throw new IllegalArgumentException("Student not found.");
            }

            System.out.print("Enter new name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new marks (0-10): ");
            double marks = scanner.nextDouble();

            // Validate marks
            if (marks < 0 || marks > 10) {
                throw new IllegalArgumentException("Marks must be between 0 and 10.");
            }

            student.name = name;
            student.marks = marks;
            student.rank = student.determineRank(marks);
            System.out.println("Student information updated.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();  // Consume invalid input
        }
    }

    // Method to delete a student
    public static void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Student student = findStudentById(id);
            if (student == null) {
                throw new IllegalArgumentException("Student not found.");
            }

            studentList.remove(student);
            System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();  // Consume invalid input
        }
    }

    // Method to search for a student by ID
    public static void searchStudent() {
        try {
            System.out.print("Enter Student ID to search: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            Student student = findStudentById(id);
            if (student == null) {
                throw new IllegalArgumentException("Student not found.");
            }

            student.display();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();  // Consume invalid input
        }
    }

    // Helper method to find a student by ID
    public static Student findStudentById(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }
}
