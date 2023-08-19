package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FuncPra<T> {
    public static void main(String[] args) {
        Supplier<Integer> s = ()-> (int)(Math.random()*100)+1;
        BiConsumer<Integer,Integer> bc = (a, b)-> System.out.println("a = "+a+", b = "+b);
        Consumer<Integer> c= a -> System.out.println(a);
        Function<Integer,Integer> f = a ->  a*10;
        Predicate<Integer> p = a -> a%2==0;



    }

    private static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<T>(list.size());

        for (T t : list) {
            newList.add(f.apply(t));
        }
        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list){
        for (T i : list) {
            if(p.test(i)) c.accept(i);
        }
    }

    static <T> void plus(Supplier<T> s, List<T> list){
        for(int i=0; i<10;i++){
            list.add(s.get());
        }
        for (T t : list) {
            System.out.println("list = " + t);
        }
    }

}
