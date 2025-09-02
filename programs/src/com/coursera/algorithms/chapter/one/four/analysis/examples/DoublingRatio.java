package com.coursera.algorithms.chapter.one.four.analysis.examples;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSumFast;

public class DoublingRatio {
    public static double timeTrial(int N) {

        int MAX = 1000000000;

        int a[] = new int[N];

        for(int i = 0; i < N; i++){
            a[i] = StdRandom.uniform(-MAX,MAX);
        }

        Stopwatch watch = new Stopwatch();
        ThreeSumFast.count(a);
        return watch.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);

        for(int i=250; true; i+=i) {
            double curr = timeTrial(i);

            StdOut.printf("| %10d | %6.1f | ", i, curr);
            StdOut.printf("%5.1f |\n" , curr/prev);

            prev = curr;
        }

    }
}
