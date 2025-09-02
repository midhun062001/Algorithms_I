package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<E> implements Stack<E> {

    private E[] values;
    private int N;
    private int push;
    private int pop;

    public ResizingArrayStack() {
        this.values = (E[]) new Object[4];
        this.N = 0;
    }

    public void reverse() {
       int i=0;
       int j=N-1;

       while (i<j) {
           E temp = values[i];
           values[i] = values[j];
           values[j] = temp;
       }
    }

    public ResizingArrayStack(Stack<E> stack) {
        this.values = (E[]) new Object[stack.size()];
        Stack<E> temp = new ResizingArrayStack<>();

        while (!stack.isEmpty()){
            temp.push(stack.pop());
        }

        while (!temp.isEmpty()){
            E e = temp.pop();
            stack.push(e);
            this.push(e);
        }
    }

    private void resize(int size) {
        E[] temp = (E[]) new Object[size]; // create a new array using the new size.
        for(int i=0; i<N; i++) { // copy all the elements from original array to the new array.
            temp[i] = values[i];
        }
        values = temp; // change the reference to the newly created array.
    }

    @Override
    public void push(E e) { // add element ath the top of the stack.
        if(N == values.length) { // check if the array is full.
            resize(2*values.length); // resizing the array by doubling its original size.
        }
        values[N++] = e;
        push++;
    }

    @Override
    public E pop() { // remove item from top of the stack.
        if(isEmpty()) throw new NoSuchElementException();
        E e = values[--N];
        values[N] = null; // prevent loitering.
        if(values.length > 16 && N < values.length/4) { // reduce the array size by half when the stack contains only 1/4 th of the original array size.
            resize(values.length/2);
        }
        pop++;
        return e;
    }

    @Override
    public E peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return values[N-1];
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
     public Iterator<E> iterator() {
        return new Iterator<E>() {
            private final int PUSH = push;
            private final int POP = pop;
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < N;
            }

            @Override
            public E next() {
                if(!hasNext()) throw new NoSuchElementException("Stack underflow");
                if(PUSH != push ||  POP != pop) {
                    throw new ConcurrentModificationException("Stack is in use!");
                }
                return values[i++];
            }
        };
    }
}
