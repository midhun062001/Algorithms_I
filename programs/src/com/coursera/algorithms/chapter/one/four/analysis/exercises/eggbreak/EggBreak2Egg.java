package com.coursera.algorithms.chapter.one.four.analysis.exercises.eggbreak;

public class EggBreak2Egg {
    public static int countThrow(int n, int k) {
        int count = 0;
        int prev = 0;
        int curr = 0;

        while (curr*curr <= k) {
            prev = curr;
            curr++;
            count++;
            System.out.printf("egg trowed at %d floor\n",curr*curr);
        }

        prev *= prev;
        curr *= curr;

        for (int i = prev+1; i <= Math.min(curr-1,n); i++) {
            count++;
            System.out.printf("egg trowed at %d floor\n",i);
            if(i==k) break;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countThrow(10,6));
    }
}
