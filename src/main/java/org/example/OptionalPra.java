package org.example;

import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class OptionalPra {

    public static void main(String[] args) {
        Optional<String> op = Optional.ofNullable("123");
        //String s = op.orElseGet(() -> "없음");
        //String s =op.orElseThrow(NullPointerException::new);

        op.ifPresent((s)->System.out.println(s));


        String str = "abc";
        Optional<String> optVal = Optional.of(str);

        System.out.println(IntStream.range(0, 10).max());

    }
}
