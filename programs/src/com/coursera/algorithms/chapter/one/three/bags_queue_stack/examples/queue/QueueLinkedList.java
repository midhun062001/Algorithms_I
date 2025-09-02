package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

import java.util.Iterator;

public class QueueLinkedList<Item> implements Queue<Item> {

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    @Override
    public void enqueue(Item item) { // add an element in the end of the queue.
        Node<Item> oldTail = tail; // create a pointer for the queue.
        tail = new Node<>(); // create the element to be inserted at the end.
        tail.item = item; // initialize node item.
        if(isEmpty()) { // if queue is empty make sure head and tail points to same element.
            head = tail;
        }
        else {
            oldTail.next = tail; // link the queue and tail node
        }
        size++;
    }

    @Override
    public Item dequeue() { // remove an element from the start.
        if(isEmpty()) return null; // if queue is empty return null.
        Item item = head.item;
        head = head.next; // move the head.
        if(isEmpty()) tail = null; // if the head is null remove the reference from the tail.
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
       return new Iterator<>() {
        private Node<Item> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
       };
    }
}
