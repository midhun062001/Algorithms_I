package com.coursera.algorithms.chapter.two.one.elementary_sorts.exercises;

import edu.princeton.cs.algs4.StdDraw;

public class AnimationSelectionSort {
    private static void show(Double[] a, int currentIndex, int progress) {
        int N = a.length;
        StdDraw.clear();
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double halfWidth = 0.5 / N;
            double halfHeight = a[i] / 2.0;  // proportional to [0,1]

            if (i == currentIndex) StdDraw.setPenColor(StdDraw.RED);
            else if (i <= progress) StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else StdDraw.setPenColor(StdDraw.BLACK);

            StdDraw.filledRectangle(x, halfHeight, halfWidth, halfHeight);
        }
        StdDraw.show();
        StdDraw.pause(100); // smoother animation
    }

    public static void selectionSort(Double[] a) {
        int N = a.length;
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) min = j;
            }
            double temp = a[i];
            a[i] = a[min];
            a[min] = temp;

            show(a, min, i);
        }
    }

    public static void insertionSort(Double[] a) {
        int N = a.length;
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                double temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;

                show(a, j - 1, i);
            }
        }
    }

    public static void shellSort(Double[] a) {
        int N = a.length;
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 3x+1 increment sequence

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    double temp = a[j];
                    a[j] = a[j - h];
                    a[j - h] = temp;

                    show(a, j, i); // highlight the swap
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int N = 40; // number of bars
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = Math.random(); // values between 0 and 1
        }

        StdDraw.enableDoubleBuffering();
        // selectionSort(a);
        // insertionSort(a);
        shellSort(a);
    }
}
