package com.coursera.algorithms.chapter.one.four.analysis.examples;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSumOverFlowProof {
    public static int count(int[] a) {
        int N = a.length;
        int count = 0;

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                for(int k=j+1; k<N; k++) {
                    int x = a[i];
                    int y = a[j];
                    int z = a[k];

                    int carry = 0;

                    boolean flag = true;

                    while(flag && (x!=0 || y!=0 || z!=0 || carry!=0)) {
                        int last = x % 10 + y % 10 + z % 10 + carry;
                        if(last%10 != 0) {
                            flag = false;
                        }
                        carry = last/10;
                        x/=10;
                        y/=10;
                        z/=10;
                    }
                    if(flag) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = In.readInts(args[0]);

        Stopwatch timer = new Stopwatch();
        int count = ThreeSumOverFlowProof.count(a);
        double timeElapsed = timer.elapsedTime();

        StdOut.println(count);
        StdOut.println(timeElapsed);

        timer = new Stopwatch();
        count = ThreeSumFast.count(a);
        timeElapsed = timer.elapsedTime();
        StdOut.println(count);
        StdOut.println(timeElapsed);

        timer = new Stopwatch();
        count = ThreeSumFaster.count(a);
        timeElapsed = timer.elapsedTime();
        StdOut.println(count);
        StdOut.println(timeElapsed);

        timer = new Stopwatch();
        count = ThreeSum.count(a);
        timeElapsed = timer.elapsedTime();
        StdOut.println(count);
        StdOut.println(timeElapsed);

    }
}
