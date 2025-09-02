package com.coursera.algorithms.chapter.one.four.analysis.exercises.eggbreak;

public class UnlimitedEggBreak2LgF {
    public static int count(int N, int k) {
        int prev = 0;
        int curr = 1;

        int count = 0;

        // lg k
        while(curr <= k) {
            prev = curr;
            curr *= 2;
            count++;
        }

        int l = prev;
        int r = curr;

        while(l <= r) {
           count++;

           int mid = l+ (r-l)/2;

           if(mid < k) {
               l = mid+1;
           }
           else {
               r = mid-1;
           }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count(100000000,32));
    }
}
