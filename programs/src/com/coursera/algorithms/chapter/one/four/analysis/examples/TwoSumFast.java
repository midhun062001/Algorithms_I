package com.coursera.algorithms.chapter.one.four.analysis.examples;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;

public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int count = 0;
        int N = a.length-1;

        int l = 0, r = N;

        while(l<r) {
            int sum = a[l] + a[r];
            if(sum == 0) {
                count++;
                l++;
            }
            else if(sum < 0) {
                l++;
            }
            else {
                r--;
            }
        }
        return count;
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
