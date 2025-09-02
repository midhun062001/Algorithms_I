package com.coursera.algorithms.chapter.one.five.case_study.examples;

public class QuickUnionWeighted implements UN {
    private int[] id;
    private int[] size;
    private int count;

    public QuickUnionWeighted(int N) {
        id = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }

        count = N;
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if(pId == qId) return;

        if(size[pId] < size[qId]) {
            id[pId] = qId;
            size[qId] += size[pId];
        }
        else {
            id[qId] = pId;
            size[pId] += size[qId];
        }

        count--;
    }

    @Override
    public int find(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]]; // path compression, make the child node point to parent's parent node
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}
