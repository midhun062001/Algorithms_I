package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;


import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.ResizingArrayStack;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.Stack;

public class Exercise4_BalanceParentheses {
    public static boolean isValid(String expression) {
        Stack<Character> stack = new ResizingArrayStack<>();

        for(char c : expression.toCharArray()){
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(c == ')' || c == '}' || c == ']') {

                if (stack.isEmpty()) return false;

                char current = stack.pop();

                switch(c) {
                    case ')' -> {
                        if(current != '(') return false;
                    }
                    case '}' -> {
                        if(current != '{') return false;
                    }
                    case ']' -> {
                        if(current != '[') return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{(){[()]{}{[()()]()}}}"));
        System.out.println(isValid("[([)]"));
        System.out.println(isValid("["));
        System.out.println(isValid(""));
    }
}
