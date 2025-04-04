package com.akash.leetcode;

public class MaximumAverageSubArray1 {

    public static void main(String[] args) {
        int arr[] = {1, 12, -5, -6, 50, 3}; int k = 4;
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
                sum += arr[j]; 
            }
            maxSum = Math.max(maxSum, sum);

        }

        return (double) maxSum/k;
    }


    private static double maximumAverageSubArrayWithSlidingWindow(int arr[], int k){
        


        return 0.0;
    }


}
