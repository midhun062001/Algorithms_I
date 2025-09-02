package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

import java.util.Scanner;

public class QueueClient {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sequence with -");
        // to be or not to - be - - that - - - is
        String input = sc.nextLine();

        Queue<String> queue = new QueueLinkedList<>();

        for(String token : input.split("\\s")){
            if(token.equals("-")){
                System.out.println(queue.dequeue());
            }
            else {
                queue.enqueue(token);
            }
            System.out.print("[ ");
            queue.forEach(s -> System.out.print(s + " "));
            System.out.print("]");
            System.out.println();
        }
    }
}
