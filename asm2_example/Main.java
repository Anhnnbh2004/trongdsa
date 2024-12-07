package asm2_example;

import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;
    String rank;

    // Constructor to initialize a student
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = getRank(marks);
    }

    // Method to determine the rank based on marks
    private String getRank(double marks) {
        if (marks >= 9.0) return "Excellent";
        if (marks >= 7.5) return "Very Good";
        if (marks >= 6.5) return "Good";
        if (marks >= 5.0) return "Medium";
        return "Fail";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}

class BinaryTree {
    private class Node {
        Student student;
        Node left, right;

        public Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    // Add a student to the tree
    public void addStudent(Student student) {
        root = addStudentRec(root, student);
    }

    private Node addStudentRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }
        if (student.id < root.student.id) {
            root.left = addStudentRec(root.left, student);
        } else if (student.id > root.student.id) {
            root.right = addStudentRec(root.right, student);
        }
        return root;
    }

    // In-order traversal to print students in sorted order
    public void displayStudents() {
        displayStudentsRec(root);
    }

    private void displayStudentsRec(Node root) {
        if (root != null) {
            displayStudentsRec(root.left);
            System.out.println(root.student);
            displayStudentsRec(root.right);
        }
    }

    // Search for a student by ID
    public Student searchStudent(int id) {
        return searchStudentRec(root, id);
    }

    private Student searchStudentRec(Node root, int id) {
        if (root == null) {
            return null;
        }
        if (root.student.id == id) {
            return root.student;
        }
        return id < root.student.id ? searchStudentRec(root.left, id) : searchStudentRec(root.right, id);
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        root = deleteStudentRec(root, id);
    }

    private Node deleteStudentRec(Node root, int id) {
        if (root == null) {
            return root;
        }
        if (id < root.student.id) {
            root.left = deleteStudentRec(root.left, id);
        } else if (id > root.student.id) {
            root.right = deleteStudentRec(root.right, id);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.student = minValue(root.right);
            root.right = deleteStudentRec(root.right, root.student.id);
        }
        return root;
    }

    private Student minValue(Node root) {
        Student minStudent = root.student;
        while (root.left != null) {
            minStudent = root.left.student;
            root = root.left;
        }
        return minStudent;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        // Adding some students
        tree.addStudent(new Student(1, "Alice", 8.5));
        tree.addStudent(new Student(2, "Bob", 6.0));
        tree.addStudent(new Student(3, "Charlie", 9.2));

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Student Marks: ");
                double marks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                tree.addStudent(new Student(id, name, marks));
                System.out.println("Student added successfully.");
            } else if (choice == 2) {
                System.out.println("\nAll Students:");
                tree.displayStudents();
            } else if (choice == 3) {
                System.out.print("Enter Student ID to search: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                Student student = tree.searchStudent(id);
                if (student != null) {
                    System.out.println(student);
                } else {
                    System.out.println("Student not found.");
                }
            } else if (choice == 4) {
                System.out.print("Enter Student ID to delete: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                tree.deleteStudent(id);
                System.out.println("Student deleted successfully.");
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

