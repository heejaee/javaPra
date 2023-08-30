package org.example;


import java.util.*;

public class SetAddArray {

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        int start =0;
        int target = n* times[times.length-1];
        int result = 0;
        while(start <=target){
            int mid = (start +target)/2;
            int cnt=0;
            for(int x: times){
                cnt += mid/x;}

            if( cnt >=n) {
                result = mid;
                target = mid-1;
            }
            else start = mid+1;
        }
        return result;

    }


    public static void main(String[] args) {
        int n = 6;
        int[] times={7,10};
        System.out.println(solution(n,times));
    }

}
