package org.example;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

class Student{
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    public Student(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString(){
        return String.format("[%s, %s, %d학년%d반, %3d점]",name,isMale ? "남":"여",hak,ban,score);
    }

    enum Level{HIGH, MID, LOW}
}


public class groupingPra {

    public static void main(String[] args) {
        Student[] stuArr={new Student("나자바",true,1,1,300),
                new Student("김지미",false,1,2,60),
                new Student("김자마",false,1,3,150),
                new Student("구구구",false,1,2,20),
                new Student("김딱",true,2,1,300),
                new Student("오나",false,2,1,300),
                new Student("나자바",true,1,3,20),
                new Student("구지",true,3,3,20),
                new Student("으악",true,3,3,20),
        };

//        Map<Integer, List<Student>> collect = Stream.of(stuArr).collect(groupingBy(Student::getBan));
//        for (Integer integer : collect.keySet()) {
//            System.out.println("collect.get(integer) = " + collect.get(integer));
//        }


        Map<Integer, Set<Student.Level>> collect = Stream.of(stuArr).collect(groupingBy(s -> s.getBan()
                , mapping(s -> {
                    if (s.getScore() > 100) return Student.Level.HIGH;
                    else if (s.getScore() > 50) return Student.Level.MID;
                    else return Student.Level.LOW;
                }, toSet())
        ));
        for (Integer integer : collect.keySet()) {
            System.out.println("integer = " + integer+" 점수"+ collect.get(integer));
        }

        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3));
        System.out.println("set = " + set);
        int[] arr ={2,3,4};
        System.out.println("arr = " + arr);
        Integer[] arr2 ={2,3,4};
        System.out.println("arr2 = " + arr2);
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println("list = " + list);
    }
}
