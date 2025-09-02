package com.coursera.algorithms.chapter.one.four.analysis.examples;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumFaster {
    public static int count(int[] a) {
        int N = a.length;
        int count = 0;

        Arrays.sort(a);

        for(int i=0; i<N; i++) {
            int target = -a[i];
            int left = i+1;
            int right = N-1;

            while(left < right) {
                if(a[left] + a[right] == target) {
                    count++;
                    left++;
                }
                else if(a[left] + a[right] < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] a = In.readInts(args[0]);

        Stopwatch timer = new Stopwatch();
        int count = ThreeSumFaster.count(a);
        double timeElapsed = timer.elapsedTime();

        StdOut.println(count);
        StdOut.println(timeElapsed);

    }
}
