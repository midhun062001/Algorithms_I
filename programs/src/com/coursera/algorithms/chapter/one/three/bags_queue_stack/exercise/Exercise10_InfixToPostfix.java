package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.ResizingArrayStack;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.Stack;

public class Exercise10_InfixToPostfix {
    public static String translate(String infix) {
        Stack<String> stack = new ResizingArrayStack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : infix.toCharArray()) {
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/') stack.push(ch+"");
            else if(ch == ')') sb.append(stack.pop()).append("  ");
            else if(ch =='(') continue;
            else if(ch>='0' && ch <= '9') sb.append(ch).append("    ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(translate("( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )"));
        System.out.println(translate("( 2 * ( ( ( 3 + 4 ) * (6 * ( 5 * 6 ) ) ) * 7 ) )"));
    }
}
