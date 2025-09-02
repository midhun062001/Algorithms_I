package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ClosestPair {
    public static double[] findClosestPair(double[] a) {
        int N = a.length;
        double diff = Double.MAX_VALUE;

        int current = 0;
        Arrays.sort(a);

        for(int i=1; i<N; i++) {
            double currDiff = Math.abs(a[i]-a[i-1]);
            if(currDiff<diff) {
                diff = currDiff;
                current = i;
            }
        }

        return new double[]{a[current-1],a[current]};
    }

    public static void runTests() {
        // Test cases: array of inputs and list of valid expected pairs
        Object[][] testCases = {
                { new double[]{3.5, 3.6},                     new double[][]{{3.5, 3.6}} },
                { new double[]{2.2, 2.2, 2.2},                new double[][]{{2.2, 2.2}} },
                { new double[]{10.5, 3.1, 8.0, 4.5, 3.3},     new double[][]{{3.1, 3.3}} },
                { new double[]{-3.0, 0.0, -1.0, -2.0},        new double[][]{{-3.0,-2.0},{-2.0,-1.0},{-1.0,0.0}} },
                { new double[]{-1e9, 0.0, 1e9, 1e-9, -1e-9},  new double[][]{{-1e-9, 1e-9}} },
                { new double[]{1.0, 2.0, 3.0, 4.0, 5.0},      new double[][]{{1.0, 2.0}} },
                { new double[]{7.5, 10.0, 15.0, 20.0, 19.99}, new double[][]{{19.99, 20.0}} }
        };

        for (int i = 0; i < testCases.length; i++) {
            double[] input = (double[]) testCases[i][0];
            double[][] validPairs = (double[][]) testCases[i][1];

            double[] result = findClosestPair(Arrays.copyOf(input, input.length));
            Arrays.sort(result);  // Normalize result order

            boolean pass = false;
            for (double[] expected : validPairs) {
                Arrays.sort(expected);  // Normalize expected order
                if (Math.abs(expected[0] - result[0]) < 1e-6 &&
                        Math.abs(expected[1] - result[1]) < 1e-6) {
                    pass = true;
                    break;
                }
            }

            StdOut.printf("Test %d: Got {%.6f, %.6f} → %s\n",
                    i + 1, result[0], result[1],
                    (pass ? "PASS ✅" : "FAIL ❌"));
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}
