package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class LocalMaximumMatrix {
    /*
    * @param N*N matrix with distinct elements
    * @return int[i,j] contains index of local maximum
    * */
    public static int[] findLocalMaximum(int[][] a) {
        int N = a.length;

        int l = 0;
        int r = N-1;

        while(l<r) {
            int midCol = l + (r-l)/2;
            int maxRow = 0;

            for(int i=1; i<N; i++) {
                if(a[i][midCol] > a[maxRow][midCol]) {
                    maxRow = i;
                }
            }

            int current = a[maxRow][midCol];
            int leftNeighbor = midCol == 0 ? Integer.MIN_VALUE : a[maxRow][midCol-1];
            int rightNeighbor = midCol == N-1 ? Integer.MIN_VALUE : a[maxRow][midCol+1];

            if(current>leftNeighbor && current > rightNeighbor) {
                return new int[] {maxRow,midCol};
            }
            else if(current < rightNeighbor) {
                l =  midCol+1;
            }
            else {
                r = midCol-1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int  N = 5;

//        int[][] a = {
//                {228, 938, 233, 712, 280},
//                {55, 52, 480, 464, 872},
//                {422, 291, 365, 101, 574,},
//                {482, 350, 48, 861, 139,},
//                {602, 807, 916, 981, 299,}
//        };

        int[][] a = new int[N][N];

//        int[][] a = {
//                {482, 838, 398, 88, 915},
//                {281, 998, 568, 797, 474},
//                {241, 945, 656, 150, 49},
//                {3,   127, 593, 388, 265},
//                {863, 129, 350, 279, 318}
//        };

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                a[i][j] = StdRandom.uniform(0,1000);
                System.out.printf("%03d ",a[i][j]);
            }
            System.out.println();
        }

        int[] min = findLocalMaximum(a);
        StdOut.println(min[0]+" "+min[1]);

    }
}
