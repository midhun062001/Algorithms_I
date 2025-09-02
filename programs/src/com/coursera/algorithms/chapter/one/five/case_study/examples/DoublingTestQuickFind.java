package com.coursera.algorithms.chapter.one.five.case_study.examples;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class DoublingTestQuickFind {
    public static void test(int N) {
            UnionFind uf = new UnionFind(N);
            Random rand = new Random();
            for(int i = 0; i < N; i++) {
                uf.union(rand.nextInt(N), rand.nextInt(N));
            }
    }

    public static void main(String[] args) {
      for(int N = 1000; true; N *= 2) {
            LocalTime start = LocalTime.now();
            test(N);
            LocalTime end = LocalTime.now();
            System.out.println("Time Elapsed for " + N + " items: " +  Duration.between(start, end).toMillis() + "ms");
        }
    }
}
