package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FarthestPair {
    public static double[] farthestPair(double[] a) {
        int N  = a.length;

        double min = a[0];
        double max = a[0];

        for(int i=1; i<N; i++) {
            if(a[i]<min) {
                min = a[i];
            }
            if(a[i]>max) {
                max = a[i];
            }
        }
        return new double[] {min, max};
    }

    public static double[] bruteForceFarthest(double[] a) {
        double maxDiff = Double.NEGATIVE_INFINITY;
        double x = 0, y = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                double diff = Math.abs(a[i] - a[j]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                    x = a[i];
                    y = a[j];
                }
            }
        }
        return new double[]{x, y};
    }

    // ✅ Utility to check if two pairs represent the same difference
    public static boolean sameFarthestPair(double[] a, double[] b) {
        double diff1 = Math.abs(a[0] - a[1]);
        double diff2 = Math.abs(b[0] - b[1]);
        return Math.abs(diff1 - diff2) < 1e-9;
    }

    // ✅ Generate and validate test cases
    public static void generateAndValidateFarthestPairTests() {
        List<double[]> testCases = new ArrayList<>();

        testCases.add(new double[]{1.0, 5.0, 9.0, 15.0});
        testCases.add(new double[]{-10.0, -50.0, -3.0, -1.0});
        testCases.add(new double[]{-100.0, 0.0, 50.0, 99.0});
        testCases.add(new double[]{3.3, 3.3, 3.3, 3.3});
        testCases.add(new double[]{2.2, 8.8});
        testCases.add(new double[]{1e9, -1e9, 0.0, 500000000.0});
        testCases.add(new double[]{1.000001, 1.000002, 1.000003});
        testCases.add(new double[]{25.0, -75.5, 60.2, 0.0, -15.0});

        // Random large test case
        double[] largeArray = new double[1000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = Math.random() * 1000 - 500;
        }
        testCases.add(largeArray);

        // Validate each test case
        int passed = 0;
        for (int i = 0; i < testCases.size(); i++) {
            double[] input = testCases.get(i);
            double[] expected = bruteForceFarthest(input);
            double[] actual = farthestPair(input);

            if (sameFarthestPair(expected, actual)) {
                System.out.println("✅ Test " + (i + 1) + " passed.");
                passed++;
            } else {
                System.out.println("❌ Test " + (i + 1) + " failed.");
                System.out.println("   Input: " + Arrays.toString(input));
                System.out.println("   Expected pair: " + Arrays.toString(expected));
                System.out.println("   Got: " + Arrays.toString(actual));
            }
        }

        System.out.println("\nPassed " + passed + "/" + testCases.size() + " test cases.");
    }

    // ✅ Main to run the validator
    public static void main(String[] args) {
        generateAndValidateFarthestPairTests();
    }
}
