package com.coursera.algorithms.chapter.one.five.case_study.examples;

public class UnionFind implements UN {
    private int[] id;
    private int count;

    public UnionFind(int N) {
        id = new int[N];
        for(int i=0; i<N; i++) {
            id[i] = i;
        }
        count = N;
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qID = find(q);
        // if p and q belong to same tree do nothing.
        if(pId == qID) return;
        // rename q's component to p's name!
        for(int i=0; i<id.length; i++) {
            if(qID == id[i]) id[i] = pId;
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        return count;
    }
}
