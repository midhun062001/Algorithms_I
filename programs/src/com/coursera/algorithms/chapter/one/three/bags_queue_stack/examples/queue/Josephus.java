package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

import java.util.Scanner;

/*
*   Josephus problem. In the Josephus problem from antiquity, N people are in dire
    straits and agree to the following strategy to reduce the population. They arrange themselves
    in a circle (at positions numbered from 0 to N–1) and proceed around the circle,
    eliminating every Mth person until only one person is left. Legend has it that Josephus
    figured out where to sit to avoid being eliminated. Write a Queue client Josephus that
    takes N and M from the command line and prints out the order in which people are
    eliminated (and thus would show Josephus where to sit in the circle).
    % java Josephus 7 2
    1 3 5 0 4 2 6
* */
public class Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total population");
        int n = sc.nextInt();
        System.out.println("Enter M");
        int m = sc.nextInt();

        Queue<Integer> q = new QueueLinkedList<>();

        for (int i=0; i<n; i++) q.enqueue(i);

        while(!q.isEmpty()){
            for(int j=1; j<m; j++){
                q.enqueue(q.dequeue());
            }
            System.out.println(q.dequeue());
        }
    }
}
