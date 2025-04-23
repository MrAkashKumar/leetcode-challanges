package com.akash.leetcode;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/majority-element/description/
 */
public class FindMajorityElement169 {
    
    public static void main(String[] args) {

         /*
         * 
         * input - 2, 2, 1, 1, 1, 2, 2, 2
         * output - 2
         * - 5, 5, 5, 8, 8
         * - 5
         * - 3, 3, 3, 3, 1, 1
         * - 3
         */
        
        int[] arr = {5, 5, 5, 8, 8};
        int response = majorityElement(arr);
        System.out.println(response);
        int majorityElement = findmajorElementFromArray(arr);
        System.out.println(majorityElement);
    }

    /*
     * 2, 2, 1, 1, 1, 2, 2, 2
     */
    private static int findmajorElementFromArray(int[] arr){
        int count = 0;
        int c = arr[0];
        for(int n : arr){
            if(count==0){
                c = n;
            }
            count += (n==c) ? 1 : -1;
        }
        return c;
    }

    /*
     * majority element
     */
    private static int majorityElement(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num  : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if(map.get(num)>nums.length/2){
                return num;
            }
        }
        return 0;
    }
}
