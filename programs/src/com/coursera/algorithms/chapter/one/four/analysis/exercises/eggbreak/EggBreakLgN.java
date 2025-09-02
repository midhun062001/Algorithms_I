package com.coursera.algorithms.chapter.one.four.analysis.exercises.eggbreak;

public class EggBreakLgN {
    public static int count(int n, int k) {
        int l = 1;
        int r = n;

        int cnt = 0;
        while (l <= r) {
            int mid = l + (r-l)/2;
            cnt++;
            if(mid < k)  {
                l = mid+1;
            }
            else {
                r = mid-1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(count(100000000,32));
    }
}
