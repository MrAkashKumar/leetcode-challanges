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
            int curSum =0;
            for(int x : nums){
                curSum += x;
                maxSum = Math.max(curSum, maxSum);
                if(curSum<0){
                    curSum = 0;
                }
            }
            return maxSum;
    }
    

}
