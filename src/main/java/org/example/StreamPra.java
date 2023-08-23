package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPra {
    public static void main(String[] args) {
        int[] arr= {1,2,3,4};
        Integer[] integers = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Stream<int[]> stream = Stream.of(new int[]{2, 3, 5});
        IntStream intStream = Arrays.stream(arr);

        String[] sarr = {"a b c d e f g h i j k"};
        Stream<String> str = Arrays.stream(sarr);
        str.flatMap(line -> Stream.of(line.split(" ")))
                .forEach(System.out::println);
//        str.sorted(String.CASE_INSENSITIVE_ORDER)
//                .forEach(System.out::println);



//        IntStream intStream = new Random().ints(5,10);
//        intStream.limit(5).forEach(System.out::println);
//
//
//        Stream<Integer> iterate = Stream.iterate(2, n -> n + 2);
//        Integer[] integers1 = iterate.limit(5).toArray(Integer[]::new);

    }
}
