package com.coursera.algorithms.chapter.one.four.analysis.exercises;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class FourSumProblem {
    /*
    * find the sum of two elements, and make it as target
    * use 2 pointer approach to search for the pair that sum is equal to -1*target
    * */

    public static void printAll(int[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int l = j+1;
                int r = N-1;

                while (l < r) {
                    int sum = a[i] + a[j] + a[l] + a[r];
                    if (sum == 0) {
                        StdOut.printf("[%d %d %d %d]\n", a[i], a[j], a[l], a[r]);
                        l++;
                    }
                    else if(sum > 0) {
                        r--;
                    }
                    else if (sum < 0) {
                        l++;
                    }
                }
                //end of while
            }
            // end of j's for
        }
        // end of i's for
    }

    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;

        Arrays.sort(a);

        for(int i = 0; i < N; i++){
            for(int j = i+1; j < N; j++){
                int target = -(a[i] + a[j]);
                int left = j+1;
                int right = N-1;

                while(left < right){
                    if(a[left] + a[right] == target){
                        cnt++;
                        left++;
                    }
                    else if(a[left] + a[right] < target){
                        left++;
                    }
                    else {
                        right--;
                    }
                }
                // end of while
            }
            // end of j for
        }
        // end of i for
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);

        Stopwatch watch = new Stopwatch();
        int cnt = count(a);
        double timeElapsed = watch.elapsedTime();
        StdOut.println(cnt);
        StdOut.println(timeElapsed);
        if(cnt < 20) {
            printAll(a);
        }
    }
}
