package asm2_example;
public class ConstantTimeExample {
    // O(1) - Constant time: Accessing an element in an array
    public static void printFirstElement(int[] arr) {
        System.out.println(arr[0]);  // Always takes constant time
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printFirstElement(arr);  // Outputs: 1
    }
}
