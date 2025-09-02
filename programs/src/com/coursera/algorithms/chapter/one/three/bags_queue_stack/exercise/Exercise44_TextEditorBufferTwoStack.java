package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.ResizingArrayStack;
import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack.Stack;

import java.util.NoSuchElementException;

public class Exercise44_TextEditorBufferTwoStack {
    private Stack<Character> leftStack;
    private Stack<Character> rightStack;

    Exercise44_TextEditorBufferTwoStack(){
        leftStack = new ResizingArrayStack<>();
        rightStack = new ResizingArrayStack<>();
    }

    public void insert(char ch){
        leftStack.push(ch);
    }

    public char delete(){
        if(leftStack.isEmpty()){throw new NoSuchElementException();}
        char ch = leftStack.pop();
        return ch;
    }

    public void left(int k){
        for(int i = 0; !leftStack.isEmpty() && i < k; i++){
            rightStack.push(leftStack.pop());
        }
    }

    public void right(int k){
        for(int i = 0; !rightStack.isEmpty() && i < k; i++){
            leftStack.push(rightStack.pop());
        }
    }

    public int size(){
        return leftStack.size() + rightStack.size();
    }

    @Override
    public String toString(){
        Stack<Character> copy = new ResizingArrayStack<>(leftStack);
        rightStack.forEach(copy::push);
        StringBuilder sb = new StringBuilder();
        copy.forEach(c -> sb.append(c).append(" "));
        return sb.toString();
    }
    public static void main(String[] args) {
        Exercise44_TextEditorBufferTwoStack buffer = new Exercise44_TextEditorBufferTwoStack();
        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.insert('e');
        buffer.insert('f');
        buffer.insert('g');
        buffer.insert('h');
        buffer.insert('i');
        buffer.insert('j');
        buffer.insert('k');
        System.out.println(buffer);
        buffer.left(2);
        System.out.println(buffer.delete());
        System.out.println(buffer);
        buffer.right(3);
        System.out.println(buffer.delete());
        System.out.println(buffer);
    }
}
