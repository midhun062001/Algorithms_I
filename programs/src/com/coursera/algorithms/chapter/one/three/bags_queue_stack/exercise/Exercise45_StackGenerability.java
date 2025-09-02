package com.coursera.algorithms.chapter.one.three.bags_queue_stack.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise45_StackGenerability {

    public static boolean isValidStack(List<Integer> permutation) {
        int maxPushed = -1;
        int expectedTop = -1; // last popped element

        for (int num : permutation) {
            if (num > maxPushed) {
                // push all numbers from maxPushed+1 to num
                maxPushed = num;
            } else {
                // num should be the next expected pop
                if (num != expectedTop - 1) {
                    return false;
                }
            }
            expectedTop = num;
        }
        return true;
    }

    private static List<List<Integer>> generatePermutation(int n){

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i);
        }
        backtrack(result, 0, list);
        return  result;
    }

    private static void backtrack(List<List<Integer>> result, int start, List<Integer> list){
        if(start == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < list.size(); i++){
            Collections.swap(list, start, i);
            backtrack(result, start + 1, list);
            Collections.swap(list, start, i);
        }
    }

    private static void test(int n){
        List<List<Integer>> result = generatePermutation(n);
        for(List<Integer> list : result){
            boolean isValid = isValidStack(list);
            System.out.print(list +" -> ");
            if(isValid){
                System.out.println("Valid");
            }
            else {
                System.out.println("Invalid");
            }
        }
    }

    public static void main(String[] args) {
        test(4);
    }
}
