package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

public interface Deque<Item> extends Iterable<Item> {
    boolean isEmpty(); //is the deque empty?
    int size(); //number of items in the deque
    void pushLeft(Item item); //add an item to the left end
    void pushRight(Item item); //add an item to the right end
    Item popLeft(); //remove an item from the left end
    Item popRight();
}
