package com.coursera.algorithms.chapter.two.one.elementary_sorts.examples;

import java.io.Console;
import java.time.Duration;
import java.time.LocalTime;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

public class CompareSorts {

    private static double time(String algorithm, Comparable[] a) {
        LocalTime start = LocalTime.now();
        if("insertion".equals(algorithm)) Insertion.sort(a);
        if("selection".equals(algorithm)) Selection.sort(a);
        if("shell".equals(algorithm)) edu.princeton.cs.algs4.Shell.sort(a);
        LocalTime end = LocalTime.now();

        Duration elapsedTime = Duration.between(start, end);
        return elapsedTime.toMillis();
    }

     /**
     * Times the execution of a given algorithm on T random inputs of size N.
     *
     * @param alg the name of the algorithm (e.g., "Insertion", "Selection", "Merge")
     * @param T the number of trials
     * @param N the size of the input array
     * @return the total time taken (in milliseconds) to run T trials
     */
    public static double timeRandomInputs(String alg, int T, int N) {
        // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++)
        { // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        Console con = System.console();
        String algorithmOne = con.readLine("Enter the first algorithm: ").strip().toLowerCase();
        String algorithmTwo = con.readLine("Enter the second algorithm: ").strip().toLowerCase();
        int T = Integer.parseInt(con.readLine("Enter the number of trails: ").strip());
        int N = Integer.parseInt(con.readLine("Enter the length of input array: ").strip());

        double t1 = timeRandomInputs(algorithmOne, T, N);
        double t2 = timeRandomInputs(algorithmTwo, T, N);

        con.printf("%s : %.0f ms\n",algorithmOne, t1);
        con.printf("%s : %.0f ms\n",algorithmTwo, t2);
    }
}
