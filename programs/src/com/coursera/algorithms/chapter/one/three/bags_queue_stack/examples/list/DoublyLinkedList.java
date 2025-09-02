package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.list;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoublyLinkedList<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    private class Node<Item> { 
        Item item;
        Node<Item> previous;
        Node<Item> next;
    }

    public void insertFirst(Item item) {
        Node<Item> oldHead = head;
        head = new Node<>();
        head.item = item;
        if(isEmpty()) {
            tail = head;
        }
        else {
            head.next = oldHead;
            oldHead.previous = head;
        }
        size++;
    }

    public void insertEnd(Item item) {
        Node<Item> oldTail = tail;
        tail = new Node<>();
        tail.item = item;

        if(isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
            tail.previous = oldTail;
        }
        size++;
    }

    public Item removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        Item item = head.item;
        head = head.next;
        size--;
        if(isEmpty()) {
            tail = null;
        }
        else {
            head.previous = null;
        }
        return item;

    }

    public Item removeEnd() {
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");

        Item item = tail.item;
        tail = tail.previous;
        size--;
        if(isEmpty()){
            head = null;
        } 
        else {
            tail.next = null;
        }
        return item;
    }

    public boolean isEmpty() {return size==0;}

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int i = sc.nextInt();
            if(i%2==0) list.insertFirst(i);
            else list.insertEnd(i);
        }

        while (!list.isEmpty()) {
            System.out.println(list.removeEnd());
        }
    }
}
