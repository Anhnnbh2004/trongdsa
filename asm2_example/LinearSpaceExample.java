package asm2_example;

public class LinearSpaceExample {
    // O(N) - Linear space: Creating a new array of size N
    public static int[] duplicateArray(int[] arr) {
        int[] newArr = new int[arr.length];  // Creates a new array of same size
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = duplicateArray(arr);  // Duplicates the array
        for (int num : newArr) {
            System.out.println(num);  // Outputs: 1, 2, 3, 4, 5
        }
    }
}

