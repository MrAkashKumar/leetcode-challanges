package com.akash.leetcode;
/*
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * Type - Array
 */
public class MaximumProductSubArray {

    public static void main(String[] args) {
        int arr[] = {2,3,-2,4};
        int response = maximumProduct(arr);
        System.out.println(response);
    }


    /*
     * Approach - Brute Force Approach
     * Time Complexity: O(n²) — Since we check every subarray.
     * Space Complexity: O(1) — Only a few variables are used.
     */
    private static int maximumProduct(int[] arr){
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i< arr.length; i++){
            int product = 1;
            for(int j = i; j < arr.length; j++){
                product = product * arr[j];
                maxProduct = Math.max(maxProduct, product);
            }   
        }
        return maxProduct;
    }

    /*
     * why I have used -> Integer.MIN_VALUE
     * - This is a constant in Java that represents the smallest possible integer value in the int data type.
     * - starting with Integer.MIN_VALUE ensures that:
     *      - Any valid product calculated will be greater than this initial value.
     *      - Even if all numbers in the array are negative or zero, the logic won't break.
     *      - Alternative approach - instead of you could initialize with 0 but this might fail if all element are negative
     *      - It’s commonly used in problems involving maximum values, negative values, or boundary conditions.
     */

    /*
     * Alternative approach
     *  1. Dynamic Programming (DP)
     *  2. Greedy Algorithms
     *  3. Divide and Conquer 
     */

    



}
