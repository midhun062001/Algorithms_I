package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularQueueLinkedList<Item> implements Queue<Item> {

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    @Override
    public void enqueue(Item item) {
        Node<Item> oldTail = tail;
        tail = new Node<>();
        tail.item = item;
        if(isEmpty()) head = tail;
        else {
            oldTail.next = tail;
        }
        size++;
        tail.next = head;
    }

    @Override
    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        Item item = head.item;
        head = head.next;
        tail.next = head;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = 0;
            private Node<Item> current = head;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Item next() {
                if(!hasNext()) throw new NoSuchElementException("No next element is present");
                Item item = current.item;
                current = current.next;
                i++;
                return item;
            }
        };
    }
    public static void main(String[] args) {
        Queue<String> q = new CircularQueueLinkedList<>();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.next();
            if(s.equals("-")) {
                if(q.isEmpty()) System.out.println("Queue is empty");
                else System.out.println(q.dequeue());
            }
            else {
                q.enqueue(s);
            }
        }
        System.out.println("remaining elements in queue: " + q.size());

        q.forEach(System.out::println);
    }
}
