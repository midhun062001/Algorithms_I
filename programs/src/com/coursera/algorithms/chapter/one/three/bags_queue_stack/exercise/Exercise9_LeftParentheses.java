package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;


import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.ResizingArrayStack;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.Stack;

public class Exercise9_LeftParentheses {
    public static String fixExpression(String expression){
        Stack<String> operands = new ResizingArrayStack<>();
        Stack<Character> operators = new ResizingArrayStack<>();

        for(char ch : expression.toCharArray()){
            if(ch-'0' >= 0 && ch-'0'<= 9) {
                operands.push(ch+"");
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                operators.push(ch);
            }
            else if(ch == ')') { // check for optimality
                String x = operands.pop();
                String y = operands.pop();
                char operator = operators.pop();
                operands.push("("+y+operator+x+")");
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        System.out.println(fixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
        System.out.println(fixExpression("1 + 2 ) * 3 - 4 )) * 5 - 6 ) )"));
    }
}
