package asm2_example;
class Student {
    int studentId;
    String name;
    double marks;
    String rank;
    Student left, right;

    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.rank = assignRank(marks);
        this.left = null;
        this.right = null;
    }

    private String assignRank(double marks) {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }
}

class StudentTree {
    private Student root;

    public StudentTree() {
        root = null;
    }

    public void insert(Student student) {
        if (root == null) {
            root = student;
        } else {
            insertRecursive(root, student);
        }
    }

    private void insertRecursive(Student node, Student student) {
        if (student.studentId < node.studentId) {
            if (node.left == null) {
                node.left = student;
            } else {
                insertRecursive(node.left, student);
            }
        } else {
            if (node.right == null) {
                node.right = student;
            } else {
                insertRecursive(node.right, student);
            }
        }
    }

    public Student search(int studentId) {
        return searchRecursive(root, studentId);
    }

    private Student searchRecursive(Student node, int studentId) {
        if (node == null || node.studentId == studentId) {
            return node;
        }
        if (studentId < node.studentId) {
            return searchRecursive(node.left, studentId);
        } else {
            return searchRecursive(node.right, studentId);
        }
    }

    public void delete(int studentId) {
        root = deleteRecursive(root, studentId);
    }

    private Student deleteRecursive(Student node, int studentId) {
        if (node == null) {
            return node;
        }
        if (studentId < node.studentId) {
            node.left = deleteRecursive(node.left, studentId);
        } else if (studentId > node.studentId) {
            node.right = deleteRecursive(node.right, studentId);
        } else {
            // Node có một hoặc không có con
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            // Node có hai con: lấy người kế thừa theo thứ tự
            Student minNode = findMin(node.right);
            node.studentId = minNode.studentId;
            node.name = minNode.name;
            node.marks = minNode.marks;
            node.rank = minNode.rank;
            node.right = deleteRecursive(node.right, minNode.studentId);
        }
        return node;
    }

    private Student findMin(Student node) {
        Student current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Student node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.println("ID=" + node.studentId + ", Name=" + node.name + ", Marks=" + node.marks + ", Rank=" + node.rank);
            inorderRecursive(node.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentTree tree = new StudentTree();

        // Thêm sinh viên
        tree.insert(new Student(1, "John Doe", 8.2));
        tree.insert(new Student(2, "Jane Smith", 6.0));
        tree.insert(new Student(3, "Alice Brown", 9.5));
        tree.insert(new Student(4, "Bob White", 5.3));

        // Tìm kiếm một sinh viên
        Student student = tree.search(2);
        if (student != null) {
            System.out.println("Tìm thấy sinh viên: ID=" + student.studentId + ", Tên=" + student.name + ", Điểm=" + student.marks + ", Xếp loại=" + student.rank);
        } else {
            System.out.println("Sinh viên không được tìm thấy.");
        }

        // Xóa một sinh viên
        tree.delete(3);

        // Duyệt theo thứ tự và hiển thị danh sách sinh viên
        System.out.println("\nDanh sách sinh viên:");
        tree.inorder();
    }
}
