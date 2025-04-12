package com.akash.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/description/
 * Array
 */
public class TwoSum1 {

        public static void main(String[] args) {
            int arr[] = {3,2,4}; 
            int arr1[] = {2,7,11,15};
            int target = 5;
            twoSumAnother(arr1, 9);
            //int[] response = twoSum(arr, target);
            
            //System.out.println(Arrays.toString(response));
            twoSum(arr, target);
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

        public static void twoSumAnother(int[] arr, int target){

            if(arr.length==0) {
                return;
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    
                    if(arr[i]+ arr[j] == target){
                        System.out.println(arr[i] + " array value " + arr[j]);
                        System.out.println(i + " index " + j);
                        return;
                    }
                }
            }

        }
        
}