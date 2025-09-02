package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import edu.princeton.cs.algs4.StdRandom;

public class LocalMinimumMatrixBruteforce {
    // bruteforce
    public static int[] findLocalMinimum(int[][] a) {
        int N = a.length;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int left = j==0 ? Integer.MAX_VALUE : a[i][j-1];
                int right = j==N-1 ? Integer.MAX_VALUE : a[i][j+1];
                int top = i==0 ? Integer.MAX_VALUE : a[i-1][j];
                int bottom = i==N-1 ? Integer.MAX_VALUE : a[i+1][j];
                int current = a[i][j];
                if(current<left && current<right && current<top && current<bottom) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] a = new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                a[i][j] = StdRandom.uniform(0,1000);
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        int[] localMinimum = findLocalMinimum(a);

        System.out.printf("a[%d,%d] : %d", localMinimum[0],localMinimum[1],a[localMinimum[0]][localMinimum[1]]);

    }
}
