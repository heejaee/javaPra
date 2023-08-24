package org.example.StreamEx;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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


public class partitionPra {

    public static void main(String[] args) {
        Student[] stuArr={new Student("나자바",true,1,1,300),
                new Student("김지미",false,1,2,60),
                new Student("김자마",false,1,3,150),
                new Student("구구구",false,1,2,20),
                new Student("김딱",true,1,1,300),
                new Student("오나",false,1,1,300),
                new Student("나자바",true,1,3,20)
        };

        System.out.println("1. 단순분할(성별로 분할)");
        Map<Boolean, List<Student>> stuBySex = Stream.of(stuArr).collect(partitioningBy(Student::isMale));
        List<Student> maleStudent = stuBySex.get(true);
        List<Student> femaleStudent = stuBySex.get(false);

        for(Student s: maleStudent) System.out.println(s);
        for(Student s: femaleStudent) System.out.println(s);

        System.out.println("2. 단순분할 + 통계(성별 학생수)");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(partitioningBy(Student::isMale, counting()));
        System.out.println("남학생 수: "+ stuNumBySex.get(true));
        System.out.println("여학생 수: "+ stuNumBySex.get(false));

        System.out.println("3. 단순분할 + 통계(성별 1등)");
        Map<Boolean, Optional<Student>> topScoreBySex =
                Stream.of(stuArr).collect(partitioningBy(Student::isMale, maxBy(comparingInt(Student::getScore))));
        System.out.println("남학생 1등 = " + topScoreBySex.get(true));
        System.out.println("여학생 1등 = " + topScoreBySex.get(false));

        Map<Boolean, Student> topScoreBySex2 =
                Stream.of(stuArr).collect(partitioningBy(Student::isMale,
                        collectingAndThen(maxBy(comparingInt(Student::getScore)),Optional::get)));

        System.out.println("남학생 1등 = " + topScoreBySex2.get(true));
        System.out.println("여학생 1등 = " + topScoreBySex2.get(false));

        System.out.println("4. 다중분할(성별 불합격자, 100점 이하)");
        Map<Boolean, Map<Boolean, List<Student>>> failedStuBySex = Stream.of(stuArr).collect(partitioningBy(Student::isMale, partitioningBy(s -> s.getScore() <= 100)));

        List<Student> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student> failedFemaleStu = failedStuBySex.get(false).get(true);

        for (Student s : failedMaleStu) {
            System.out.println(s);
        }

        for (Student s : failedFemaleStu) {
            System.out.println(s);
        }
    }



}

