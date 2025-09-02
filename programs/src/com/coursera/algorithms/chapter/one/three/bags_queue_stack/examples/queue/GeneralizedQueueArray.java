package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.queue;

import java.util.NoSuchElementException;

public class GeneralizedQueueArray<Item> implements GeneralizedQueue<Item> {
    private int size;
    private Item[] items;
    private int front;
    private int rear;

    public GeneralizedQueueArray() {
        items = (Item[]) new Object[16];
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = items[(i+front)%items.length];
        }
        items = temp;
        front = 0;
        rear = size;
    }

    @Override
    public void insert(Item item) {
        if(size == items.length) {
            resize(size * 2);
        }
        items[rear++] =  item;
        size++;
        if(rear == items.length){
            rear = 0;
        }
    }

    @Override
    public Item delete(int k) {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        if(k > size) throw new IndexOutOfBoundsException(String.format("Index %d is greater than size (%d)",k,size));
        if(k<=0)  throw new IndexOutOfBoundsException(String.format("Index %d is less than 0, negative index not supported!",k));
        Item temp = items[(front+k-1)%items.length];
        for(int i=k; i<size; i++){
            items[(front+i) % items.length] = items[(front+i+1) % items.length];
        }
        rear = (rear-1)%items.length;
        if(items.length/4 == size) resize(items.length/2);
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        GeneralizedQueueArray<Integer> q = new GeneralizedQueueArray<Integer>();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);

        System.out.println(q.delete(5));

        q.insert(6);
    }
}
