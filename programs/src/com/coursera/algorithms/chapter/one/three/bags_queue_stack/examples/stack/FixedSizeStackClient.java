package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

import java.util.Scanner;

public class FixedSizeStackClient {
    public static void main(String[] args) {
//        Stack<String> stack = new FixedSizeStack<>(10);
        // Stack<String> stack = new ResizingArrayStack<>();
        Stack<String> stack = new LinkedListStack<>();


        // ip -> to be or not to - be - - that - - - is
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with '-'");
        String s = sc.nextLine();

        for(String token : s.split("\\s")) {
            if(!token.equals("-")) {
                stack.push(token);
            }
            else {
                System.out.println(stack.pop() + " ");
            }
            System.out.print("[ ");
            stack.forEach(item -> System.out.printf("%s ", item));
            System.out.print("]");
            System.out.println();
        }
        System.out.println();

        System.out.printf("Remaining items in stack is %d!",stack.size());
    }
}
