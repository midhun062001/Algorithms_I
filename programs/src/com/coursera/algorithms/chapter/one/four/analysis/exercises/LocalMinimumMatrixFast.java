package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import edu.princeton.cs.algs4.StdOut;

public class LocalMinimumMatrixFast {
    public static int[] findLocalMinimum(int[][] a) {
        int N = a.length;

        int left = 0;
        int right = N-1;

        while(left < right) {
            int midColumn = left + (right-left)/2 ;

            int minIdx = 0;

            for(int i=1; i<N; i++) {
                minIdx = a[i][midColumn] < a[minIdx][midColumn] ? i : minIdx;
            }

            System.out.println(minIdx + " " + midColumn);

            int current = a[minIdx][midColumn];
            int leftNeighbor = midColumn == 0 ? Integer.MAX_VALUE : a[minIdx][midColumn-1];
            int rightNeighbor = midColumn == N-1 ? Integer.MAX_VALUE : a[minIdx][midColumn+1];

            if(leftNeighbor > current && rightNeighbor > current) {

                return new int[] {minIdx, midColumn};

            } else if(leftNeighbor <current) {
                right = midColumn;
            }
            else {
                left = midColumn+1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int  N = 5;

        int[][] a = {
                {228, 938, 233, 712, 280},
                {55, 52, 480, 464, 872},
                {422, 291, 365, 101, 574,},
                {482, 350, 48, 861, 139,},
                {602, 807, 916, 981, 299,}
        };

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
//                a[i][j] = StdRandom.uniform(0,1000);
                System.out.printf("%03d ",a[i][j]);
            }
            System.out.println();
        }

        int[] min = findLocalMinimum(a);
        StdOut.println(min[0]+" "+min[1]);

    }
}
