package com.akash.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

        public static void main(String[] args) {
            int arr[] = {3,2,4}; 
            int target = 5;
            int[] response = twoSum(arr, target);
            System.out.println(Arrays.toString(response));
        }
        
        public static int[] twoSum(int[] nums, int target) {
            if(nums.length==0) {
                return new int[0];
            }
            
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int i = 0; i < nums.length; i++) {
                
                int number = target - nums[i];
                if(map.containsKey(number)) {
                    return new int[] {i, map.get(number)};
                }
                map.put(nums[i], i);
            }
            return new int[0];
        }
}