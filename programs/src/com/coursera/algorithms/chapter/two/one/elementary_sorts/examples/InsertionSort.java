package com.coursera.algorithms.chapter.two.one.elementary_sorts.examples;

import edu.princeton.cs.algs4.In;

public class InsertionSort {

    public static void sort(Comparable[] a) {
        for(int i=1; i<a.length; i++) {
            for(int j=i; j>0; j--) {
                if(less(a[j], a[j-1])) exch(a, j-1, j);//optimize it by reducing exchanges
                else break;
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
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }

    private static void show(Comparable[] a) {
        for(Comparable element : a) {
            System.out.printf("%s ",element.toString());
        }
    }

    public static void main(String[] args) {
        String[] q = In.readStrings();
        sort(q);
        assert isSorted(q);
        show(q);
    }
}
