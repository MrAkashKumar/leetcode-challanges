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
     * brute Force 
     * 
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


    private static double maximumAverageSubArrayWithSlidingWindow(int arr[], int k){
        


        return 0.0;
    }


}
