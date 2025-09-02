package com.coursera.algorithms.chapter.one.five.case_study.examples;

public interface UN {
     void union(int p, int q);
     int find(int p);
     int count();
     default boolean connected(int p, int q) {
          return find(p) == find(q);
     }
}
