package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue.Queue;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue.ResizingArrayQueue;

import java.util.Scanner;

public class Exercise15_KthStringFromLast {
    public static void main(String[] args) {
        Queue<String> q = new ResizingArrayQueue<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the k");
        int k = sc.nextInt();

        System.out.println("Enter list of strings (minimum k)");
        while (sc.hasNextLine()) {
            q.enqueue(sc.nextLine());
            if(q.size() > k) {
                q.dequeue();
            }
        }

        System.out.printf("%d from the last string is %s.",k, q.dequeue());

    }
}
