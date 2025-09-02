package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item>{
    private class Node<Item> {
        Item item;
        Node<Item> next;
    }

    private Node<Item> first;
    private int size;

    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public void insertAfter(Item key, Item item) {
        if(key == null || item == null) return;

        Node<Item> current = first;

        while (current != null) {
            if(key.equals(current.item)) {
                Node<Item> newItem = new Node<>();
                newItem.item = item;
                newItem.next = current.next;
                current.next = newItem;
                size++;
                return;
            }
            current = current.next;
        }
    }

    /* {@param Item key} this method removes all the nodes having the passed key.
       {@return} boolean true if any keys are removed otherwise return false.
    */
    public boolean remove(Item key) {
        if(isEmpty()) return false;

        int previousSize = size;
        Node<Item> current = first;

        // start from the 2nd node and remove all matching items
        while(current.next != null) {
            if(current.next.item == null && key == null || key != null && key.equals(current.next.item)) {
                current.next = current.next.next;
                size--;
            }
            else {
                current = current.next;
            }
        }

        // remove if the first node is same as key
        if(first.item == null && key == null || key != null && key.equals(first.item)) {
            first = first.next;
            size--;
        }

        return previousSize != size;
    }

    public Item removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

         if(size == 1) {
            Item item = first.item;
            first = null;
            size--;
            return item;
        }

        Node<Item> current = first;

        while(current.next.next != null) {
            current = current.next;
        }

        Item item = current.next.item;
        current.next = null;
        size--;
        return item;
    }

    public Item removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("List is empty");
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index %d is out of bounds [0, %d)", index, size));
        }

        if(index == 0) return removeFirst();

        Node<Item> current = first;
        while (index>1) {
            current = current.next;
            index--;
        }

        Item item = current.next.item;
        current.next = current.next.next;
        size--;
        return item;
    }

    public Item removeAfter(Item item) {
        if(isEmpty()) return null;

        Node<Item> current = first;

        while (current.next != null) {
            if(current.item == null) {
                if(item == null) {
                    Item removedItem = current.next.item;
                    current.next = current.next.next;
                    size--;
                    return removedItem;
                }
            }
            else if(current.item.equals(item)) {
                Item removedItem = current.next.item;
                current.next = current.next.next;
                size--;
                return removedItem;
            }
            current = current.next;
        }

        return null;
    }

    public boolean find(Item key) {
        return indexOf(key) != -1;
    }

    public int indexOf(Item key) {
        int idx = 0;
        Node<Item> current = first;
        while (current!=null) {
            if(key == null && current.item == null) return idx;
            else if(key.equals(current.item)) return idx;
            current = current.next;
            idx++;
        }

        return -1;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            Node<Item> current = first;

            @Override
            public boolean hasNext() {
                return current!= null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }

        };
    }

    public void reverse() {
        this.first = reverse(first);
    }

//    private Node<Item> reverse(Node<Item> first) {
//        Node<Item> reverse = null;
//
//        while (first != null) {
//            Node<Item> second = first.next;
//            first.next = reverse;
//            reverse = first;
//            first = second;
//        }
//
//        return reverse;
//    }

    private Node<Item> reverse(Node<Item> current) {
        if(current == null) return null;

        else if (current.next == null) return current;
        
      Node<Item> second = current.next;
      Node<Item> reverse = reverse(current.next);

      second.next = current;
      current.next = null;

      return reverse;
    }

    // public Item max() {
    //     if(isEmpty()) throw new NoSuchElementException("List is empty");

    //     Item max = first.item;

    //     for(Node<Item> x = first.next; x != null; x = x.next) {
    //         if(max.compareTo(x.item)<0) max = x.item;
    //     }
    //     return max;
    // }


    public Item max() {
        return max(first);
    }

    public Item max(Node<Item> node) {
        if(node.next == null) return node.item;

        Item newMax = max(node.next);

        return node.item.compareTo(newMax) > 0 ? node.item : newMax;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.forEach(System.out::println);

        list.reverse();
        System.out.println("After reverse");
        list.forEach(System.out::println);
    }
}
