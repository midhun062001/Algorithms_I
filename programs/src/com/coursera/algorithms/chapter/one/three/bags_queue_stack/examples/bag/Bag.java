package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.bag;

public interface Bag<E> extends Iterable<E> {
    void add(E e);
    boolean isEmpty();
    int size();
}
