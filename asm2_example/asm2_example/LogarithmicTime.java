package asm2_example;

public class LogarithmicTime {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        
        // Binary search to find the target
        int index = binarySearch(sortedArray, target);
        System.out.println("Index of " + target + ": " + index);
    }

    // Modify the method to return the index instead of a boolean
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid; // Return the index of the target
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Return -1 if the target is not found
    }
}
