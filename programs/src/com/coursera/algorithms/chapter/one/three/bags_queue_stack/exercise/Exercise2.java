package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.ResizingArrayStack;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.Stack;

public class Exercise2 {
    public static void main(String[] args) {
        Stack<String> stack = new ResizingArrayStack<>();

        String input = "it was - the best - of times - - - it was - the - -";

        for(String token : input.split("\\s")) {
            if(token.equals("-")) {
                System.out.print(stack.pop()+" ");
            }
            else {
                stack.push(token);
            }
        }
        System.out.println();
        System.out.println("Remaining number of tokens: " + stack.size());
        System.out.print("Remaining tokens: [ ");
        stack.forEach(s -> System.out.print(s + " "));
        System.out.print("]");
        System.out.println();
    }
}
