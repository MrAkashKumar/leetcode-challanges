package com.akash.leetcode;
/*
 * https://leetcode.com/problems/maximum-subarray/description/
 * Leetcode - 53
 * Array
 */
public class MaximumSubArray53 {

    public static void main(String[] args) {
        
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
        int response = findMaximumSubArray(arr);
        System.out.println(response);
    }
    /*
     * The idea is to use a variable to keep track of the current sum of the subarray
     * and another variable to keep track of the maximum sum found so far.
     * If the current sum becomes negative, we reset it to zero.
     * This way, we can find the maximum sum of any contiguous subarray in linear time.
     */
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    /*
     * The function takes an array of integers as input and returns the maximum sum of a contiguous subarray.
     * It uses a single loop to iterate through the array, keeping track of the current sum and the maximum sum found so far.
     * If the current sum becomes negative, it resets it to zero.
     */
    private static int findMaximumSubArray(int[] nums){
            int maxSum = nums[0];
            int currentSum =0;
            for(int x : nums){
                currentSum = currentSum + x;
                maxSum = Math.max(currentSum, maxSum);
                if(currentSum<0){
                    currentSum = 0;
                }
            }
            return maxSum;
    }
    

}
