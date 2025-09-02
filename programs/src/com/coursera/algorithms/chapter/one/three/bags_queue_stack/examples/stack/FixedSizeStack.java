package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

import java.util.Iterator;

public class FixedSizeStack<E> implements Stack<E>{

    private E[] values;
    private int top;

    public FixedSizeStack(int size) {
        this.values = (E[])new Object[size];
        this.top = 0;
    }

    public void reverse() {
        int left = 0;
        int right = top-1;
        while(left < right){
            E temp = values[right];
            values[right] = values[left];
            values[left] = temp;
        }
    }
    @Override
    public void push(E e) {
        if(top == values.length) throw new RuntimeException("Stack Overflow");

        values[top++] = e;
    }

    @Override
    public E pop() {
        if(isEmpty()) throw new RuntimeException("stack underflow");
        return values[--top];
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new RuntimeException("stack underflow");
        return values[top-1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == values.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){
            int current = top;

            @Override
            public boolean hasNext() {
                return current==0;
            }

            @Override
            public E next() {
                return values[--current];
            }
        };
    }
}
