package org.example;

import java.util.*;

public class IteratorPra {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        Collections.sort(list,(a,b)->a.compareTo(b));
        Collections.sort(list,Collections.reverseOrder());
        //System.out.println(list.get(1));

//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "c");
        map.put(3, "b");
        map.put(2, "a");

        // map.values()
        for (String value : map.values()) {
            System.out.println("value = " + value);
        }
//        Collection<String> values = map.values();
//        System.out.println(values);  // [Apple, Banana, Orange]
    }


}
