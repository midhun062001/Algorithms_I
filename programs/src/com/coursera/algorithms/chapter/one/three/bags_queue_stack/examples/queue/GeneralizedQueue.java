package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

public interface GeneralizedQueue<Item> {
    public void insert(Item item);
    public Item delete(int k);
    boolean isEmpty();
}
