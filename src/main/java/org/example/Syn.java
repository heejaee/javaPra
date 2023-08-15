package org.example;

public class Syn {
    public static void main(String[] args) {
        Runnable r = new RunnableEx();
        new Thread(r).start();
        new Thread(r).start();
    }

}
class Account{
    private int balance= 1000;

    public int getBalance(){
        return balance;
    }

    public void withdraw(int money)
    {
        if(balance >= money)
        {
            try
            {
                Thread.sleep(1000);
            } catch(Exception e) {}
            balance -= money;
        }
    }
}


class RunnableEx implements Runnable{

    Account acc = new Account();
    int money = 200;

    @Override
    public void run() {
        System.out.println("money = " + money);
        while(acc.getBalance()>0){
            acc.withdraw(money);
            System.out.println("balance = " + acc.getBalance());
        }
    }
}