package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

public interface Queue<Item> extends Iterable<Item> {
    void enqueue(Item item);
    Item dequeue();
    boolean isEmpty();
    int size();
}
