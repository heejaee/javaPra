package org.example;

public class Main{
    public static void main(String[] args) {

        Th th1 = new Th();
        th1.start();
        
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) { }
        System.out.println("<Main 종료>");
        
    }


}

class Th extends Thread{

    @Override
    public void run() {

        for(int i = 0; i<20000;i++){};
        System.out.println("th1 시작");
    }

}