package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

public interface Stack<E> extends Iterable<E>{
    void push(E e);
    E pop();
    E peek();
    int size();
    boolean isEmpty();
}
