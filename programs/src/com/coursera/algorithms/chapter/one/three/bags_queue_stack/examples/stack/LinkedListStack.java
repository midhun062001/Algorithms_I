package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.stack;

import java.util.Iterator;

public class LinkedListStack<Item> implements Stack<Item> {

    private Node<Item> top;
    private int size;

    private class Node<Item>{
        Item item;
        Node<Item> next;
    }

    @Override
    public void push(Item item) {
        Node<Item> oldTop = top;
        top = new Node<>();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    @Override
    public Item pop() {

        if(isEmpty()) return null;

        Item item = top.item;
        top = top.next;
        size--;
        return item;
    }

    @Override
    public Item peek() {
        return top.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> current = top;

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
