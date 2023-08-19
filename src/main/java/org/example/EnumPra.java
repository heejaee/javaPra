package org.example;

enum Direction{
    EAST(5,"1"),WEST(6,"2"),SOUTH(7,"3"),NORTH(8,"4");

    private final int value;
    private final String symbol;

    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue(){return value;}

    public String getSymbol() {
        return symbol;
    }
}

public class EnumPra {


    public static void main(String[] args) {

        Direction d1 = Direction.EAST;

        System.out.println("d1.getValue() = " + d1);
        System.out.println("d1.get = " + d1.getSymbol());

//        Direction[] dArr = Direction.values();
//        for (Direction d : dArr) {
//            System.out.println(d.name()+"  "+ d.ordinal());
//        }
//
//        System.out.println("(d2==d3) = " + (d2==d3));
//        System.out.println("d2.equals(d3) = " + d2.equals(d3));
//        System.out.println("d2.compareTo(d3) = " + d2.compareTo(d3));
//        En en = new En();
//        en.init();


    }

}

class En{
    int x,y;
    Direction dir;

    void init(){
        dir = Direction.EAST;
    }

}
