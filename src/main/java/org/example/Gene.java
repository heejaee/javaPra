package org.example;

import java.util.ArrayList;
import java.util.List;

class Fruit{ public String toString(){return "Fruit";}}
class Apple extends Fruit{public String toString(){return "Apple";}}
class Grape extends Fruit {public String toString(){return "Grape";}}

class Juice{
    String name;
    Juice(String name) {this.name = name+"Juice";}
    public String toString(){return name;}
}

class Juicer{
    static <T extends Fruit> Juice makeJuice(FruitBox<T> box){
        String tmp="";
        for (T fruit : box.getList()) {
            tmp += fruit+ " ";
        }
        return new Juice(tmp);
    }
}

public class Gene {

    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();

        FruitBox<? extends Fruit> appleBox = new FruitBox<Apple>();
        //appleBox.add(new Apple());

        fruitBox.add(new Fruit());
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());


        grapeBox.add(new Grape());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(grapeBox));
    }
}

class FruitBox<T extends Fruit> extends Box<T>{}


class Box<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item) {list.add(item);}
    T get(int i) {return list.get(i);}

    ArrayList<T> getList(){return list;}
    int size() {return list.size();}
    //public String toString(){ return list.toString();}
}
