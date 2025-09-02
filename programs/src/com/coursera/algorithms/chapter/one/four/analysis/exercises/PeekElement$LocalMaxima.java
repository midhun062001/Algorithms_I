package com.coursera.algorithms.chapter.one.four.analysis.exercises;

public class PeekElement$LocalMaxima {
    public static int peek(int[] a) {
        int N = a.length;

        int s=0;
        int e=N-1;

        while(s<e){
           int m = s + (e-s)/2;

           if(a[m] > a[m+1]) { // check mid + 1 because mid will never come to right at beginning but mid - 1 will result in AIOBE because mid may be 0 at start
               e = m;
           }
           else {
               s = m+1;
           }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] a1= {1,2};
        System.out.println(peek(a1));

        int[] a2= {2,1};
        System.out.println(peek(a2));

        int[] a3= {1,2,5,6,7,8,9,0,3,4,5};
        System.out.println(peek(a3));

        int[] a4 = {1};
        System.out.println(peek(a4));
    }
}
