package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreePra {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.get(0).add(1);
        list.get(0).add(2);
        list.get(0).add(3);
        list.get(1).add(3);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.println("integer = " + integer);
            }
        }

    }
}
