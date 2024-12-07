package asm2_example;

public class ConstantSpaceExample {
    // O(1) - Constant space: Only a fixed number of variables used
    public static void printFirstElement(int[] arr) {
        int firstElement = arr[0];  // Only one extra variable used
        System.out.println(firstElement);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printFirstElement(arr);  // Outputs: 1
    }
}
