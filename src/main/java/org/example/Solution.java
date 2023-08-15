package org.example;

import java.util.Stack;

class Solution {

    static boolean  solution(String s) {

        Stack<String> st = new Stack<>();
        String[] ans = s.split("");

        for(String ss : ans){
            if(ss=="(") st.push(")");
            else{
                if(!st.isEmpty()) st.pop();
                else{
                    return false;
                }
            }

        }

        return st.isEmpty();
    }


    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a={73,74,75,71,69,72,76,73};
        dailyTemperatures(a);
    }
}