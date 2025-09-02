package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;


import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.ResizingArrayStack;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.Stack;

public class Exercise11_EvaluatePostfix {
    public static double evaluate(String postfix) {
        Stack<Double> stack = new ResizingArrayStack<>();

        for(char ch : postfix.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                stack.push(ch-'0'*1.0);
            }
            else if(ch == '+') {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first + second);
            }
            else if(ch == '-') {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first - second);
            }
            else if(ch == '*') {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first * second);
            }
            else if(ch == '/') {
                double second = stack.pop();
                double first = stack.pop();
                stack.push(first / second);
            }
        }
            return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate(Exercise10_InfixToPostfix.translate("( 2 + ( ( 3 * 4 ) + ( 30 - 6 ) ) )")));
    }
}
