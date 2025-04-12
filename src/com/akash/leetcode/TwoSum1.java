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
        
        /* 
         * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
         * You may assume that each input would have exactly one solution, and you may not use the same element twice.
         * You can return the answer in any order.
         */
        /* * Example 1:
         * Input: nums = [2,7,11,15], target = 9
         * Output: [0,1]
         * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         * 
         * Example 2:
         * Input: nums = [3,2,4], target = 6
         * Output: [2,1]
         * 
         * Example 3:
         * Input: nums = [3,3], target = 6
         * Output: [0,1]
         */
        /* Time Complexity: O(n)
         * Space Complexity: O(n)
         * 
         * Approach:
         * 1. Create a HashMap to store the numbers and their indices.
         * 2. Iterate through the array, for each number, calculate the complement (target - number).
         * 3. Check if the complement exists in the HashMap.
         * 4. If it exists, return the current index and the index of the complement from the HashMap.
         * 5. If it doesn't exist, add the current number and its index to the HashMap.
         */
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

        /* * Approach:
         * 1. Iterate through the array with two nested loops.
         * 2. For each pair of numbers, check if their sum equals the target.
         * 3. If it does, print the numbers and their indices.
         * 4. Return when the first pair is found.
         */
        /* Time Complexity: O(n^2)
         * Space Complexity: O(1)
         * 
         * Note: This approach is less efficient than the HashMap approach, especially for larger arrays.
         */
        /* * Example 1:
         * Input: nums = [2,7,11,15], target = 9
         * Output: [0,1]
         * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         * 
         * Example 2:
         * Input: nums = [3,2,4], target = 6
         * Output: [2,1]
         * 
         * Example 3:
         * Input: nums = [3,3], target = 6
         * Output: [0,1]
         */
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