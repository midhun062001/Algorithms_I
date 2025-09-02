package com.algorithma.two.sorting.algo;

import java.util.Scanner;

public class InsertionSort {
    public static void sort(Comparable[] a) {
        for(int i=1; i<a.length; i++) {
            for(int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for(int i=1; i<a.length; i++) {
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    private static void show(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()) {
            sb.append(sc.nextLine()).append(" ");
        }
        String[] a = sb.toString().trim().split(" ");

        sort(a);
        assert isSorted(a) : "Array is not sorted";
        show(a);
    }
}
