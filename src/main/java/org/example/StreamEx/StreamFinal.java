package org.example.StreamEx;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFinal {

    public static void main(String[] args) {
        Stream<int[]> stream = Stream.of(new int[]{2, 3, 5});
        IntStream intStream = Arrays.stream(new int[]{2, 3, 5});

//        int maxValue = intStream.reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
//        System.out.println("minValue = " + maxValue);
        intStream.max();
        System.out.println("intStream.anyMatch = " + intStream.filter(x -> x >= 3).findFirst().getAsInt());


//        OptionalInt empty = IntStream.empty().reduce(Integer::max);
//        System.out.println("empty.getAsInt( = " + empty.getAsInt());

        Integer[] arr= {1,2,3,4};
        int[] ints = Arrays.stream(arr).mapToInt(x -> x).toArray();
        int[] inarr ={5,6,7,8};

        List<Integer> collect = Arrays.stream(inarr).boxed().collect(Collectors.toList());
        ArrayList<Integer> collect1 = Arrays.stream(inarr).boxed().collect(Collectors.toCollection(ArrayList::new));

    }
}
class Person{
    int[] id = {2,3,4};

    public int[] getId() {
        return id;
    }
}
