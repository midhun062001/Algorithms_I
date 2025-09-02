package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.ResizingArrayStack;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.Stack;

public class Exercise12_CopyStack {
    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> copy = new ResizingArrayStack<>();

        for (String s : stack) {
            copy.push(s);
        }

        return copy;
    }
}
