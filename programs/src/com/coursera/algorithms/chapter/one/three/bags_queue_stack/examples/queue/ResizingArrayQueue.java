package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ResizingArrayQueue<Item> implements Queue<Item> {

    private Item[] items;
    private int size;
    private int head;
    private int tail;

    public ResizingArrayQueue() {
        items = (Item[]) new Object[16];
    }

    public ResizingArrayQueue(Queue<Item> q) {
        items = (Item[]) new Object[q.size()];
        for(int i=0; i<q.size(); i++) {
            Item item = q.dequeue();
            this.enqueue(item);
            q.enqueue(item);
        }
        head = 0;
        size = q.size();
        tail = size;
    }

    private void resize(int capacity) {
        System.out.println("resized using new capacity: " + capacity);
        Item[] copy = (Item[]) new Object[capacity];

        for(int i=0; i<size; i++) {
            copy[i] = items[(head+i)%items.length];
        }
        items = copy;
        head = 0;
        tail = size;
    }

    @Override
    public void enqueue(Item item) {
        if(size == items.length) resize(items.length*2);
        items[tail++] = item;
        if(tail==items.length) tail = 0;
        size++;
    }

    @Override
    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        Item item = items[head];
        items[head++] = null; // prevent loitering
        if(head == items.length) head = 0;
        size--;
        if(items.length> 16 && size == items.length/4) resize(items.length/2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Item next() {
               Item item = items[(head+i) % items.length];
               i++;
               return item;
            }
        };
    }

    public static void main(String[] args) {
        Queue<String> q = new ResizingArrayQueue<>();

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

        Queue<String> remaining = new ResizingArrayQueue<>(q);
        q.forEach(s -> System.out.println(s.toUpperCase()));

        q.forEach(System.out::println);

    }
}
