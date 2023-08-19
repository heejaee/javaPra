package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IntToInteger {

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4};
        Integer[] tmp = Arrays.stream(temp).boxed().toArray(x -> new Integer[x]);
        Integer[] tmp2=Arrays.stream(temp).boxed().toArray(Integer[]::new);
        for (Integer integer : tmp) {
            System.out.println("integer = " + integer);
        }

       String s= "12345";
        Integer integer = Integer.valueOf(s);
        int i = Integer.parseInt(s);
        System.out.println("integer.equals(i) = " + integer.equals(i));
        System.out.println("integer == i = " + (integer == i));

    }

//    public static void main(String[] args) {
//        List<Integer> ints = new ArrayList<>();
//        add(ints);
//    }
//
//    private static void add(List<? super Integer> ints){
//        ints.add(3); // 외부에서 받은 List<Integer>에 Double을 추가하는 모순 발생
//    }
}
