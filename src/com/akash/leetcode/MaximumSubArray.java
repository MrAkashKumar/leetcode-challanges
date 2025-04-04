package com.akash.leetcode;
/*
 * https://leetcode.com/problems/maximum-subarray/description/
 * Leetcode - 53
 * Array
 */
public class MaximumSubArray {

    public static void main(String[] args) {
        
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
        int response = findMaximumSubArray(arr);
        System.out.println(response);
    }

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
