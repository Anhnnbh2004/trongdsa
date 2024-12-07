import java.util.*;
class Student {
    String fullName;
    String lastName;
    public Student(String fullName) {
        this.fullName = fullName;

        String[] nameParts = fullName.split(" ");
        if (nameParts.length == 2) {
            this.lastName = nameParts[1];
        } else {
            this.lastName = nameParts[0];
        }
    }
    public void display() {
        System.out.println("Full Name: " + fullName);
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
        String[] nameParts = fullName.split(" ");
        if (nameParts.length == 2) {
            this.lastName = nameParts[1];
        } else {
            this.lastName = nameParts[0];
        }
    }
    public String getLastName() {
        return lastName;
    }
}
public class StudentManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Enter Student List");
            System.out.println("2. Find Students By Last Name");
            System.out.println("3. Find And Edit Atudents By Full Name");
            System.out.println("4. End");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    enterStudentList();
                    break;
                case 2:
                    findStudentByLastName();
                    break;
                case 3:
                    findAndEditStudentByFullName();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }
    public static void enterStudentList() {
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter full name of student " + (i + 1) + ": ");
            String fullName = scanner.nextLine();
            students.add(new Student(fullName));
        }
        System.out.println("Student list entered successfully.");
    }
    public static void findStudentByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                student.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No student found with last name " + lastName);
        }
    }
    public static void findAndEditStudentByFullName() {
        System.out.print("Enter full name of student to edit: ");
        String fullName = scanner.nextLine();
        boolean found = false;

        for (Student student : students) {
            if (student.fullName.equalsIgnoreCase(fullName)) {
                student.display();
                System.out.print("Enter new full name: ");
                String newFullName = scanner.nextLine();
                student.setFullName(newFullName);
                System.out.println("Student information updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with the name " + fullName);
        }
    }
}
