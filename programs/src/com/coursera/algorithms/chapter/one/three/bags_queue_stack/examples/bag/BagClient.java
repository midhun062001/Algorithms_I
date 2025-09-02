package com.coursera.algorithms.chapter.one.three.bags_queue_stack.examples.bag;

public class BagClient {
    public static void main(String[] args) {
        Bag<Double> bag = new BagLinkedList<>();

        System.out.println(bag.size());
        System.out.println(bag.isEmpty());

        bag.add(20.0);
        bag.add(40.0);
        bag.add(30.0);
        bag.add(10.0);

        System.out.println(bag.size());
        System.out.println(bag.isEmpty());

        double sum = 0;

        for(double d : bag) {
            sum += d;
        }

        System.out.printf("sum: %f", sum);
    }
}
