package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise43_ListFileName {
    public static void main(String[] args) {
        File file = new File("D:\\learning\\DSA\\coursera_algorithms_I");

        Queue<String> queue = new LinkedList<>(Arrays.asList(file.list()));
        for(String filename : queue){
            System.out.println(filename);
        }
    }
}
