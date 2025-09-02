package com.algorithma.two.sorting.client;

import com.algorithma.two.sorting.algo.SelectionSort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class DoubleTestSelectionSort {
    private static void test(int n) {
        Integer[] a = new Integer[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        LocalTime start = LocalTime.now();
        SelectionSort.sort(a);
        LocalTime end = LocalTime.now();
        assert SelectionSort.isSorted(a) : "Array is not sorted";
        long duration = Duration.between(start, end).toMillis();
        System.out.printf("Input size: %d, Time elapsed: %d\n", a.length, duration);
    }

    public static void main(String[] args) {
        for(int i = 1000; true; i*=2) {
            test(i);
        }
    }
}
