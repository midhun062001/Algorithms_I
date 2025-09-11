package com.coursera.algorithms.chapter.two.two.merge_sort;

import java.util.Arrays;

public class TopDownMergeSort {

    private static final int CUTOFF = 7;

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        for (int i = 0; i < a.length; i++)
            aux[i] = a[i];
        sort(aux, a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int low,
            int high) {
        if (high <= low + CUTOFF - 1) {
            insertionSort(aux, low, high);
            return;
        }

        int mid = low + (high - low) / 2;
        sort(aux, a, low, mid); // optimization: avoid time taken to copy elements in merge!
        sort(aux, a, mid + 1, high);

        merge(a, aux, low, mid, high);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int low,
            int mid, int high) {

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid)
                aux[k] = a[j++];
            else if (j > high)
                aux[k] = a[i++];
            else if (less(a[j], a[i]))
                aux[k] = a[j++];
            else
                aux[k] = a[i++];
        }
    }

    private static void insertionSort(Comparable[] a, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int j = i - 1;
            Comparable key = a[i];

            while (j >= low && less(key, a[j])) {
                a[j + 1] = a[j--];
            }

            a[j + 1] = key;
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int count = 100;
        Integer[] input = new Integer[count];

        for (int i = 0; i < input.length; i++) {
            input[i] = count--;
        }
        sort(input);
        System.out.println(Arrays.toString(input));
    }
}
