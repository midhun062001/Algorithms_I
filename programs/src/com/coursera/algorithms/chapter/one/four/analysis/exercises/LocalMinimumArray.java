package com.coursera.algorithms.chapter.one.four.analysis.exercises;

public class LocalMinimumArray {
    public static int localMinimum(int[] a){
        int l = 0;
        int r = a.length-1;
        while(l<r){
            int mid = l + (r-l)/2  ;

           if(a[mid]>a[mid+1]){
               l = mid+1;
           }
           else {
               r = mid;
           }
        }
        return l;
    }
}
