package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

public class StackClient {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackImpl<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        for(int i : stack) {
            System.out.println(i);
        }

        System.out.println(stack.isEmpty());

        while (!stack.isEmpty()) {
            System.out.println("pop: " + stack.pop());
        }

        System.out.println(stack.isEmpty());
    }
}
