package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise14_ResizingArrayQueue <Item> implements Queue<Item> {

    private Item[] items;
    private int head;
    private int tail;
    private int size;

    public Exercise14_ResizingArrayQueue() {
        items = (Item[]) new Object[16];
        size = 0;
    }

    private void resize(int newSize) {
        System.out.println("Queue resized to " + newSize);
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = items[(head+i) % items.length];
        }
        items = temp;
        head = 0;
        tail = size;
    }

    @Override
    public void enqueue(Item item) {
        // resize if queue is full
        if(size == items.length) resize(items.length * 2);

        items[tail++] = item;
        if(tail == items.length) tail = 0;
        size++;
    }

    @Override
    public Item dequeue() {
        if(size == 0) throw new NoSuchElementException("Queue is empty");

        Item item = items[head];
        items[head++] = null; // prevent loitering.
        if(head == items.length) head = 0;
        size--;

        if(items.length/4 == size && items.length > 16) resize(items.length/2);

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
        Queue<Integer> queue = new Exercise14_ResizingArrayQueue<>();

        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
            if(i%2 == 0) System.out.println(queue.dequeue());
        }
        System.out.println("Remaining elements: " + queue.size());
        queue.forEach(System.out::println);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
