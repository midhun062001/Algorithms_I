package com.coursera.algorithms.chapter.two.two.merge_sort;

import java.util.Arrays;

public class MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];

        int N = a.length;

        for (int s = 1; s < N; s <<= 1) {
            for (int lo = 0; lo < N - s; lo += s + s) {
                merge(a, lo, lo + s - 1, Math.min(N - 1, lo + s + s - 1));
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = { 213, 321, 1, 12, 1, 231, 1, 32, 1, 31, 3, 1, 35,
                456, 54, 65, 765, 8, 67, 98 };
        sort(a);
        System.out.println(isSorted(a));
        System.out.println(Arrays.toString(a));

    }
}