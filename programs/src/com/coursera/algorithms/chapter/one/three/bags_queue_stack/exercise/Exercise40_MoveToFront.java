package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
    Move-to-front. Read in a sequence of characters from standard input and
    maintain the characters in a linked list with no duplicates. When you read in a previously
    unseen character, insert it at the front of the list. When you read in a duplicate
    character, delete it from the list and reinsert it at the beginning. Name your program
    MoveToFront: it implements the well-known move-to-front strategy, which is useful for
    caching, data compression, and many other applications where items that have been
    recently accessed are more likely to be reaccessed.
*/
public class Exercise40_MoveToFront<Item> implements Iterable<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node head;

    private void insert(Item item) {
        if(item == null) throw new IllegalArgumentException("item is null");
        delete(item);
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
    }

    private void delete(Item item) {
        if(head == null) return;
        else if(head.item.equals(item)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if(current.next.item.equals(item)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                if(!hasNext())  throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        Exercise40_MoveToFront<Character> mtf = new Exercise40_MoveToFront<Character>();
        mtf.insert('X');
        mtf.insert('B');
        mtf.insert('C');
        mtf.insert('B');
        mtf.insert('C');
        mtf.insert('A');
        mtf.insert('D');
        mtf.insert('A');

        mtf.forEach(System.out::println);
    }
}
