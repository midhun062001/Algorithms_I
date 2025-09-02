package com.coursera.algorithms.chapter.one.five.case_study.examples;

public class QuickUnion implements UN {
    private int[] id;
    private int count;

    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        count = n;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        id[qRoot] = pRoot;
        count--;
    }

    @Override
    public int find(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}
