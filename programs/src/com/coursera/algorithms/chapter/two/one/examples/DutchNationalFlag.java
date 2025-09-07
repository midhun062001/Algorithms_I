package com.coursera.algorithms.chapter.two.one.examples;

import java.util.Arrays;

// zoho asked problem
// three way partitioning problem
public class DutchNationalFlag {

    /**
     *
     * @param a is a integer array which contains only 0,1 and 2 This methods
     *          returns a permutation of input array in sorted order This method
     *          uses THREE WAY PARTITIONING ALGORITHM This method takes a linear
     *          time.
     */
    public static void sort(int[] a) {
        int low = 0;
        int mid = 0;
        int high = a.length - 1;

        while (mid <= high) {
            if (a[mid] == 0)
                swap(mid++, low++, a);
            else if (a[mid] == 1)
                mid++;
            else
                swap(mid, high--, a);
        }
    }

    private static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = { 0, 1, 2, 0, 1, 2, 1, 1, 1, 1, 0, 0, 0, 2, 2, 2 };
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
