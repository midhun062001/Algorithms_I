package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;


import com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue.Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exercise33_DequeArray<Item> implements Deque<Item> {

    private Item[] items;
    private int size;
    private int head;
    private int tail;

    public Exercise33_DequeArray() {
        items = (Item[]) new Object[16];
        head = items.length;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for(int i=0; i<size; i++) {
            temp[i] = items[(head+i)%items.length];
        }
        items = temp;
        head = 0;
        tail = size;
        
    }

    private boolean isFull() {
        return size == items.length;
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
    public void pushLeft(Item item) {
        if(isFull()) resize(items.length*2);
        if(head == 0) head = items.length;
        items[--head] = item;
        size++;
    }

    @Override
    public void pushRight(Item item) {
        if(isFull()) resize(items.length*2);
        items[tail++] = item;
        if(tail == items.length) tail = 0;
        size++;
    }

    @Override
    public Item popLeft() {
        if(isEmpty()) throw new NoSuchElementException();
        if(head == items.length) head = 0;
        Item item = items[head];
        items[head++] = null;
        size--;
        if(items.length > 16 && size == items.length/4) resize(items.length/2);
        return item;
    }

    @Override
    public Item popRight() {
        if(isEmpty()) throw new NoSuchElementException();
        if (tail == 0) tail = items.length;
        Item item = items[--tail];
        items[tail] = null;
        size--;
        if(items.length > 16 && size == items.length/4) resize(items.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i<size;
            }

            @Override
            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = items[(head+i)%items.length];
                i++;
                return item;
            }
        };
    }

     public static void main(String[] args) {
        Deque<Integer> d = new Exercise33_DequeArray<Integer>();
         for(int i = 0; i < 100; i++) {
             if(i%2==0) {d.pushLeft(i);}
             else {d.pushRight(i);}
         }

         while (!d.isEmpty()) {
             System.out.println(d.popLeft());
         }
    }


}
