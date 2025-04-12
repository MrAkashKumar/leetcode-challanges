package com.akash.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview/
 * Arrays
 */
public class ProductOfArrayExceptSelf238 {

    public static void main(String[] args) {
        
        int[] arr = {21,10, 11, 16, 17, 19, 12};
        int[] response = productOfArrayExceptSelf(arr);
        System.out.println(response);

    }

    /* time complexity: O(n)
     * space complexity: O(1) */
    /* * The idea is to use two passes to calculate the product of all elements to the left and right of each element.
     * In the first pass, we calculate the product of all elements to the left of each element and store it in the result array.
     * In the second pass, we calculate the product of all elements to the right of each element and multiply it with the value in the result array.
     * This way, we get the product of all elements except for the current element.
     */
    /* * The first pass calculates the product of all elements to the left of each element and stores it in the result array.
     * The second pass calculates the product of all elements to the right of each element and multiplies it with the value in the result array.
     * This way, we get the product of all elements except for the current element.
     */ 
    private static int[] productOfArrayExceptSelf(int[] nums){

        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for(int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for(int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

}
