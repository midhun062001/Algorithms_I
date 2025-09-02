package com.coursera.algorithms.chapter.one.five.case_study.assiginment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF uf;
    private final int vritualTop;
    private final int vritualBottom;
    private int openCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        this.n = n;
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        vritualTop = n*n;
        vritualBottom = n*n+1;
    }

    private void validate(int row, int col) {
        if(row<1 || row > n || col < 1 || col > n) throw new IllegalArgumentException("row and col must be in range [1.."+n+"]");
    }

    private int id(int row, int col) {
        return (row-1) * n + (col-1);
    }
    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        if(grid[row-1][col-1]) return;

        grid[row-1][col-1] = true;
        openCount++;

        int idx = id(row, col);

        if(row == 1) uf.union(vritualTop, idx);
        if(row == n) uf.union(vritualBottom, idx);

        if(row > 1 && isOpen(row-1, col)) uf.union(idx, id(row-1, col));
        if (row < n && isOpen(row+1, col)) uf.union(idx, id(row+1, col));
        if(col > 1 && isOpen(row, col-1)) uf.union(idx, id(row, col-1));
        if(col < n && isOpen(row, col+1)) uf.union(idx, id(row, col+1));
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        return isOpen(row,col)
                && uf.find(id(row, col)) == uf.find(vritualTop);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(vritualTop) == uf.find(vritualBottom);
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(1, 2);
        p.open(2, 2);
        p.open(2, 1);
        p.open(3, 1);
        p.open(4, 1);
        p.open(5, 1);
        System.out.println("Percolates? " + p.percolates());
    }

}
