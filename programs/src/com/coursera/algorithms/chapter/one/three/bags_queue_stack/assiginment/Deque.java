package com.coursera.algorithms.chapter.one.three.bags_queue_stack.assiginment;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public Deque() {}

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if(item == null) throw new IllegalArgumentException("null value is not allowed");
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        if(isEmpty()) tail = head;
        else oldHead.prev = head;
        size++;
    }

    public void addLast(Item item) {
        if(item == null) throw new IllegalArgumentException("null value is not allowed");
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.prev = oldTail;
        if(isEmpty()) head = tail;
        else oldTail.next = tail;
        size++;
    }

    public Item removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("Deque is empty");
        Item item = head.item;
        head = head.next;
        size--;
        if(isEmpty()) tail = null;
        else head.prev = null;
        return item;
    }

    public Item removeLast() {
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
        return new Iterator<Item>() {

            private Node current = head;

            @Override
            public boolean hasNext() {
               return current != null;
            }

            @Override
            public Item next() {
                if(!hasNext()) throw new NoSuchElementException("No more elements");
                Item item = current.item;
                current = current.next;
                return item; 
            }
        };
    }

    public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        d.addFirst("a");
        d.addFirst("b");
        d.addLast("c");
        StdOut.println(d.size());
        StdOut.println(d.isEmpty());
        Iterator<String> iterator = d.iterator();
        while(iterator.hasNext()) {
            StdOut.print(iterator.next() + " ");
        }
        StdOut.println();
        StdOut.println(d.removeLast());
        StdOut.println(d.removeFirst());
        StdOut.println(d.removeLast());
        StdOut.println(d.size());
        StdOut.println(d.isEmpty());
    }
}