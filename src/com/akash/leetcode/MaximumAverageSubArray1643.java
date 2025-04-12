package com.akash.leetcode;
/*
 * Given an integer array nums consisting of n elements and an integer k, return the maximum average value of a subarray of length k rounded down to the nearest integer.
 * A subarray is a contiguous part of an array.
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
public class MaximumAverageSubArray1643 {

    public static void main(String[] args) {
        int arr[] = {1, 12, -5, -6, 50, 3}; 
        int k = 4;
        double maxAverageSubArrInDouble = maximumAverageSubArrayWithBruteForceApproach(arr, k);
        System.out.println(maxAverageSubArrInDouble);
        double maximumAverageSubArray = maximumAverageSubArrayWithSlidingWindow(arr, k);
        System.out.println(maximumAverageSubArray);
    }
    /*
     * Given an integer array nums consisting of n elements and an integer k, return the maximum average value of a subarray of length k rounded down to the nearest integer.
     * A subarray is a contiguous part of an array.
     * https://leetcode.com/problems/maximum-average-subarray-i/description/
     */

    /* brute force approach
     * 1. Find the sum of all subarrays of length k.
     * 2. Find the maximum sum of all subarrays of length k.
     * 3. Return the maximum sum divided by k.
     * 
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    private static double maximumAverageSubArrayWithBruteForceApproach(int[] arr, int k){

        if(arr.length == 0){
            return 0.0;
        }

        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<= n-k; i++){
            int sum =0;
            for(int j = 1; j < i+k; j++){
                sum = sum + arr[j]; 
            }
            maxSum = Math.max(maxSum, sum);

        }

        return (double) maxSum/k;
    }

    /* Sliding window approach
     * 1. Find the sum of first k elements.
     * 2. Iterate through the array and find the sum of next k elements by subtracting the first element of the previous window and adding the last element of the current window.
     * 3. Find the maximum sum of all subarrays of length k.
     * 4. Return the maximum sum divided by k.
     * 
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    private static double maximumAverageSubArrayWithSlidingWindow(int arr[], int k){
        


        return 0.0;
    }


}
