package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise33_Deque<Item> implements Iterable<Item> {
    //  implement using doubly linked list

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    private class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void pushLeft(Item item) {
        Node<Item> oldHead = head;
        head = new Node<Item>();
        head.item = item;
        head.next = oldHead;
        if(isEmpty()) tail = head;
        else oldHead.prev = head;
        size++;
    }

    public void pushRight(Item item) {
        Node<Item> oldTail = tail;
        tail = new Node<>();
        tail.item = item;
        tail.prev = oldTail;
        if(isEmpty()) head = tail;
        else oldTail.next = tail;
        size++;
    }

    public Item popLeft() {
        if(isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item = head.item;
        head = head.next;
        size--;
        if(isEmpty()) tail = null;
        else head.prev = null;;
        return item;
    }

    public Item popRight() {
        if(isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item = tail.item;
        tail = tail.prev;
        size--;
        if(isEmpty()) head = null;
        else tail.next = null;
        return item;
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
                if(!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Exercise33_Deque<Integer> d = new Exercise33_Deque<Integer>();
        for(int i = 0; i < 100; i++) {
            if(i%2==0) {d.pushLeft(i);}
            else {d.pushRight(i);}
        }

        while (!d.isEmpty()) {
            System.out.println(d.popLeft());
        }
    }
}
