package com.coursera.algorithms.chapter.one.four.analysis.exercises;
// AKA Fibonacci search
public class BinarySearchWithAdditionAndSubtraction {
    public static int search(int[] a, int t) {
        int N = a.length;

        int fk2 = 0;
        int fk1 = 1;
        int fk = fk1 + fk2;

        while(fk < N) {
            fk2 = fk1;
            fk1 = fk;
            fk = fk1 + fk2;
        }

        int offset = -1;

        while (fk > 1) {
            int i = Math.min(fk2+offset, N-1);

            if(a[i] < t) {
                offset = i;
                fk = fk1;
                fk1 = fk2;
                fk2 = fk - fk1;
            }
            else if(a[i] > t) {
                fk = fk2;
                fk1 = fk1-fk2;
                fk2 = fk-fk1;
            }
            else {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2,3,4,5,6,9,11,22,34,35,38,42,45,46,47,61,66,69};
        System.out.println(search(a,16));
    }
}
