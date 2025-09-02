package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import java.util.Arrays;
import java.util.Random;

public class LocalMinimumTest {
    public static void main(String[] args) {
        // Run multiple test cases
        runTest(new int[]{9, 7, 3, 8, 5, 6});         // Local min: 3 or 5
        runTest(new int[]{1, 2, 3, 6, 7, 5, 8});            // Local min: 1
        runTest(new int[]{5, 4, 3, 2, 1});            // Local min: 1
        runTest(new int[]{5, 3, 4});                 // Local min: 3
        runTest(new int[]{10});                      // Edge case: single element
        runTest(generateDistinctRandomArray(100));   // Large random test
        runTest(new int[]{1,3,2,5,6,7,8});
    }

    private static void runTest(int[] arr) {
        System.out.println("Testing array: " + Arrays.toString(arr));

        // Call your solution here
        // Example:
         int index = LocalMinimumArray.localMinimum(arr);
         System.out.println("Found local minimum at index " + index + " with value " + (index != -1 ? arr[index] : -1));
    }

    // Helper: Generate a random array with distinct integers
    private static int[] generateDistinctRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i + 1;
        shuffleArray(arr);
        return arr;
    }

    // Fisher–Yates shuffle
    private static void shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
