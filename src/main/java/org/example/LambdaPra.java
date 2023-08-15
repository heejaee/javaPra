package org.example;

public class LambdaPra {

    // 함수형 인터페이스 -한개의 추상서드를 가진 인터페이스
    @FunctionalInterface
    public interface Sports {
        void run(int a,int b);
    }

    //매게변수로 함수형 인터페이스를 받는 경우
    public static void me(Sports s){
        s.run(3,4);
    }

    // 함수형 인터페이스를 리턴하는 경우
    public static Sports la(){
        return (a,b)-> System.out.println("a /b = "+ a/b);
    }

    public static void main(String[] args) {
        Sports s = (a,b) -> System.out.println("a+b = "+(a+b));
        s.run(2,3);

        me((a,b)-> System.out.println("a*b = " + a*b));

        Sports u = la();
        u.run(10,2);
    }

}


