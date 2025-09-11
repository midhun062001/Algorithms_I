package com.coursera.algorithms.chapter.two.two.merge_sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.random.RandomGenerator;

import edu.princeton.cs.algs4.Stopwatch;

public class TestTopDownMergeSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input size");

        int size = sc.nextInt();

        Integer[] a = new Integer[size];

        RandomGenerator generator = RandomGenerator.getDefault();

        for (int i = 0; i < size; i++) {
            a[i] = generator.nextInt(0, 100);
        }

        Stopwatch timer = new Stopwatch();
        TopDownMergeSort.sort(a);
        double timeElapsed = timer.elapsedTime();
        System.out.println(TopDownMergeSort.isSorted(a));
        System.out.println("Elapsed Time: " + timeElapsed + " s");
    }
}
