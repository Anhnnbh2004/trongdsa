package asm2_example;

public class ConstantSpace {
    public static int multiply(int a, int b) {
        return a * b;  // Using only a fixed amount of memory for variables 'a' and 'b'
    }

    public static void main(String[] args) {
        int result = multiply(5, 6); // Example multiplication
        System.out.println("Result of multiplication: " + result);
    }
}
