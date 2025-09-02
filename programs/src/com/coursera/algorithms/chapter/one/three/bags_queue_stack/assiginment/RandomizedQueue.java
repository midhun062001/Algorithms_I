package com.coursera.algorithms.chapter.one.three.bags_queue_stack.assiginment;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] items;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[4];
        size = 0;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Null argument not permitted");
        if (size == items.length) resize(items.length * 2);
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int random = StdRandom.uniform(size);
        Item item = items[random];
        items[random] = items[--size];
        items[size] = null;
        if(items.length > 4 && size == items.length/4) resize(items.length/2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        int random = StdRandom.uniform(size);
        return items[random];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i = 0;
        private Item[] temp;
        RandomizedQueueIterator() {
            temp = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                temp[i] = items[i];
            }
            StdRandom.shuffle(temp);
        }
        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("No more items");
            return temp[i++];
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();

        // Test isEmpty on new queue
        assert rq.isEmpty();
        assert rq.size() == 0;

        // Test enqueue and size
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        assert rq.size() == 3;
        assert !rq.isEmpty();

        // Test sample does not remove
        int sample = rq.sample();
        assert rq.size() == 3 : "Sample should not remove elements";

        // Test dequeue reduces size
        int removed = rq.dequeue();
        assert rq.size() == 2 : "Size should reduce after dequeue";

        // Test exception for null enqueue
        try {
            rq.enqueue(null);
            assert false : "enqueue(null) should throw";
        } catch (IllegalArgumentException e) {}

        // Test exception for dequeue on empty
        rq.dequeue();
        rq.dequeue();
        try {
            rq.dequeue();
            assert false : "dequeue() on empty should throw";
        } catch (NoSuchElementException e) {}

        // Test iterator covers all items in random order
        rq.enqueue(10);
        rq.enqueue(20);
        rq.enqueue(30);
        Iterator<Integer> it1 = rq.iterator();
        Iterator<Integer> it2 = rq.iterator();
        assert it1.hasNext() && it2.hasNext();
        assert it1.next() != null;
        assert it2.next() != null;

        System.out.println("All tests passed!");
    }
}