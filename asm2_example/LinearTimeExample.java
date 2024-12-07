package asm2_example;

public class LinearTimeExample {
    // O(N) - Linear time: Looping through the array
    public static void printElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);  // Prints each element
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printElements(arr);  // Outputs: 1, 2, 3, 4, 5
    }
}

