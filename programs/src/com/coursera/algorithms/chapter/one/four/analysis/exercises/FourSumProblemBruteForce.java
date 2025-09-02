package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class FourSumProblemBruteForce {
    public static int count(int[] a) {
        int N = a.length;
        int cnt= 0;

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                for(int k=j+1; k<N; k++) {
                    for(int l=k+1; l<N; l++) {
                        if(a[i] + a[j] + a[k] + a[l] == 0) {
                            cnt++;
                        }
                    }
                    // end of l's for
                }
                // end of k's for
            }
            // end of j's for
        }
        // end of i's for
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);

        Stopwatch stopwatch = new Stopwatch();
        int count = count(a);
        double elapsedTime = stopwatch.elapsedTime();

        StdOut.println(count);
        StdOut.println(elapsedTime);

    }
}
