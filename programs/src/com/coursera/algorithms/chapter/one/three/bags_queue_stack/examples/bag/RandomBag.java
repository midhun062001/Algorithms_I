package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomBag<Item> implements Bag<Item> {

    private Node<Item> first;
    private int size;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }
    @Override
    public void add(Item item) {
        Node<Item> second = first;
        first = new Node<Item>();
        first.item = item;
        first.next = second;
        size++;
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
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item> {

        private Node<Item> current;
        private Item[] items;
        private int i;
        public RandomBagIterator() {
            current = first;
            items = (Item[]) new Object[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                Item item = current.item;
                int randomIndex = rand.nextInt(i + 1);
                items[i] = items[randomIndex];
                items[randomIndex] = item;
                current = current.next;
            }
        }
        @Override
        public boolean hasNext() {
            return i<size;
        }

        @Override
        public Item next() {
            if(!hasNext()) throw new NoSuchElementException();
            return items[i++];
        }
    }

    public static void main(String[] args) {
        RandomBag<String> bag = new RandomBag<String>();

        bag.add("Midhun");
        bag.add("Daniel");
        bag.add("John");
        bag.add("Ram");
        bag.add("Krish");

        bag.forEach(System.out::println);
    }
}
