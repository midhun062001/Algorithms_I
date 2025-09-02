package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class RandomQueue<Item> implements Queue<Item> {

    private Item[] items;
    private int size;
    private int head;
    private int tail;

    public RandomQueue() {
        items = (Item[]) new Object[16];
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for(int i=0; i<size; i++) {
            temp[i] = items[(head+i) % items.length];
        }
        items = temp;
        head = 0;
        tail = size;
    }
    @Override
    public void enqueue(Item item) {
        if(items.length == size) resize(size*2); // enlarge the array by doubling the current capacity
        items[tail++] = item;
        if(tail == items.length) tail = 0;
        size++;
    }

    @Override
    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        Random random = new Random();
        int idx = random.nextInt(size);
        Item item = items[(head+idx)%items.length];
        items[(head+idx)%items.length] = items[head];
        items[head++] = null;
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
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private int i = 0;
        private Item[] temp;

        private RandomQueueIterator() {
            temp = (Item[]) new Object[size];

            for(int i=0; i<size; i++) {
                temp[i] = items[(head+i) % items.length];
            }

            // shuffling

            Random random = new Random();
            for(int i=0; i<temp.length; i++) {
                int j = random.nextInt(i+1);
                Item t = temp[i];
                temp[i] = temp[j];
                temp[j] = t;
            }
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException("Queue is empty");
            return temp[i++];
        }
    }

    public static void main(String[] args) {
        RandomQueue<String> queue = new RandomQueue<String>();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.equals("-")) System.out.println(queue.dequeue());
            else queue.enqueue(s);
        }

        System.out.println("Remaining elements in queue: ");
        queue.forEach(System.out::println);
    }
}
