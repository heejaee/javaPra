package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class ArrayCopy {

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
//        int[] nums={4,5,1,2,3};
//        System.out.println(findMin(nums));
        ArrayList<Integer>[] graph2 = new ArrayList[2];

        graph2[0] = new ArrayList<>();
        graph2[0].add(2);
        graph2[0].add(1);
//        graph2[1].add(2);
//        graph2[2].add(1);
        for (ArrayList<Integer> integers : graph2) {
            for (Integer integer : integers) {
                System.out.println("integer = " + integer);
            }
        }

    }


}
