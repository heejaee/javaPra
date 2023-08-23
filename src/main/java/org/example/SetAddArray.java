package org.example;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetAddArray {

    static int result;
    public static int uniquePaths(int m, int n) {

        Set<List<Integer>> set = new HashSet<>();
        return dfs(set, m-1,n-1);
    }

    public static int dfs(Set<List<Integer>> set,int m, int n){
        if(m ==0 || n==0) return 1;
        if(!set.contains(Arrays.asList(m,n))){
            set.add(Arrays.asList(m,n));
            result =dfs(set,m,n-1)+dfs(set,m-1,n);
        }
        for (List<Integer> integers : set) {
            for (Integer integer : integers) {
                System.out.print("integer = " + integer);
            }
            System.out.println();
        }
        System.out.println("=========================");
        return result;
    }

    public static void main(String[] args) {
        uniquePaths(3,7);



    }

}
