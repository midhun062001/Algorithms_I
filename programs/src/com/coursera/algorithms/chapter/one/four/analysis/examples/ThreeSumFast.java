package com.coursera.algorithms.chapter.one.four.analysis.examples;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumFast {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;

        Arrays.sort(a);

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                int sum = a[i]+a[j];
                if(BinarySearch.rank(-sum, a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch watch = new Stopwatch();
        int cnt = count(a);
        double timeElapsed = watch.elapsedTime();
        StdOut.println(cnt);
        StdOut.println(timeElapsed);
    }
}
