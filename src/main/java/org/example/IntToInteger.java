package org.example;

import java.util.Arrays;

public class IntToInteger {

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4};
        Integer[] tmp = Arrays.stream(temp).boxed().toArray(x -> new Integer[x]);
        for (Integer integer : tmp) {
            System.out.println("integer = " + integer);
        }

       String s= "12345";
        Integer integer = Integer.valueOf(s);
        int i = Integer.parseInt(s);
        System.out.println("integer.equals(i) = " + integer.equals(i));
        System.out.println("integer == i = " + (integer == i));

    }
}
