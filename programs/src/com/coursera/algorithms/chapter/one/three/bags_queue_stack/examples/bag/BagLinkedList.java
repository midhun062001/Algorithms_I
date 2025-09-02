package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.bag;

import java.util.Iterator;

public class BagLinkedList<Item> implements Bag<Item> {
    
    private Node<Item> head;
    private int size;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    @Override
    public void add(Item item) {
        Node<Item> oldHead = head;
        head = new Node<>();
        head.item = item;
        head.next = oldHead;
        size++;
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

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }
}
