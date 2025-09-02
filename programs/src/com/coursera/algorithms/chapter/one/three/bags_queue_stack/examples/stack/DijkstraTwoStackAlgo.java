package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

import java.util.Stack;

public class DijkstraTwoStackAlgo {
    public static double evaluate(String expression) {
        Stack<String> operators = new Stack<>();
        Stack<Double> operands =  new Stack<>();

        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            switch (token) {
                case "(":
                    break; // Do nothing for left parenthesis
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(token);
                    break;
                case ")":
                    // Pop operator and two operands, compute, and push result
                    String op = operators.pop();
                    double val2 = operands.pop();
                    double val1 = operands.pop();
                    switch (op) {
                        case "+":
                            operands.push(val1 + val2);
                            break;
                        case "-":
                            operands.push(val1 - val2);
                            break;
                        case "*":
                            operands.push(val1 * val2);
                            break;
                        case "/":
                            operands.push(val1 / val2);
                            break;

                    }
                    break;
                default:
                    // Token is a number
                    operands.push(Double.parseDouble(token));
            }
        }
        return operands.pop();
    }

    public static void main(String[] args) {
        String expr = "( ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.println("Result: " + evaluate(expr));  // Should print 101.0
    }
}
