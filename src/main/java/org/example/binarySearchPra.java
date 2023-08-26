package org.example;

import java.util.*;

public class binarySearchPra {

    public static int[] intersection(int[] nums1, int[] nums2) {

        Integer[] arr = Arrays.stream(nums2).boxed().toArray(Integer[]::new);

        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        List<Integer> list = new ArrayList<>();


        Arrays.sort(nums1);

        for(Integer target : set){
            int start =0;
            int end = nums1.length-1;
            while(start<=end){
                int mid = end + (start - end)/2;
                if(nums1[mid] == target) {
                    list.add(target);
                    break;
                }


                if(target<nums1[mid]){
                    end = mid-1;
                }
                else if(target> nums1[mid]){
                    start = mid+1;
                }

            }
        }

        return list.stream().mapToInt(x->x).toArray();
    }


    public static void main(String[] args) {
        int[] nums1 ={4,9,5};
        int[] nums2 ={9,4,9,8,4};
        int[] intersection = intersection(nums1, nums2);
        for (int i : intersection) {
            System.out.println("i = " + i);
        }
    }


}
