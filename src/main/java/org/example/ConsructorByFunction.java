package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

class ConstructorByFunction {
    int val;
    public ConstructorByFunction() {
       this.val = 0;
        System.out.println("기본 생성자");
    }
    @Override
    public String toString() {
        return "val 값은: "+val;
    }

    public ConstructorByFunction(String s) {
        this.val = 10;
        System.out.println("기본 생성자 "+s);
    }

    public static void main(String args[]) {
        Supplier<ConstructorByFunction> s= ConstructorByFunction::new;
        ConstructorByFunction cf = s.get();
        System.out.println("cf = " + cf);

        Function<String,ConstructorByFunction> f = x->new ConstructorByFunction(x);
        ConstructorByFunction cf2= f.apply("아니야");
        System.out.println("cf2 = " + cf2);
    }
}
