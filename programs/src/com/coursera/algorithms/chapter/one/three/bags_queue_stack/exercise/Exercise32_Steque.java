package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import java.util.NoSuchElementException;

public class Exercise32_Steque<Item> {
    // linked list based implementation
    // push()
    // pop()
    // enqueue()
    // isEmpty()
    // size()

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    public void push(Item item) {
        Node<Item> oldHead = head;
        head = new Node<>();
        head.item = item;
        head.next = oldHead;
        if(isEmpty()) tail = head;
        size++;
    }

    public void enqueue(Item item) {
        Node<Item> oldTail = tail;
        tail = new Node<>();
        tail.item = item;
        if(isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
        size++;
    }

    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException("Steque is empty");

        Item item = head.item;
        head = head.next;
        size--;
        if(isEmpty()) tail = null;
        return item;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Exercise32_Steque<Integer> steque = new  Exercise32_Steque<Integer>();

        steque.push(23);
        steque.enqueue(34);
        steque.enqueue(45);

        while(!steque.isEmpty()){
            System.out.println(steque.pop());
        }
    }
}
