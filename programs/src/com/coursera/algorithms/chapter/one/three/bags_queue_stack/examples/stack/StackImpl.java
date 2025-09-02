package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

import java.util.Iterator;

public class StackImpl<E> implements Stack<E> {
    private E[] elements;
    private int size;
    private int top;

    private final int DEFAULT_CAPACITY = 10;

    public StackImpl() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        top = -1;
    }

    public void reverse() {
        int i=0;
        int j=size-1;

        while (i<j) {
            E temp = elements[i];
            elements[i] = elements[j];
            elements[j] = temp;
        }
    }

    @Override
    public void push(E e) {
        if(top == elements.length-1) throw new RuntimeException("Stack is full");
        elements[++top] = e;
        size++;
    }

    @Override
    public E pop() {
        if(top == -1) throw new RuntimeException("Stack is empty");
        E item = elements[top];
        elements[top--] = null;
        size--;
        return item;
    }

    @Override
    public E peek() {
        return elements[top];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int current = top;
            @Override
            public boolean hasNext() {
                return current != -1;
            }

            @Override
            public E next() {
                return elements[current--];
            }
        };
    }
}
