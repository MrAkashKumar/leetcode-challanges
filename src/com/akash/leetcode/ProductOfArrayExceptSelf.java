package com.akash.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * https://leetcode.com/problems/product-of-array-except-self/solutions/1342916/3-minute-read-mimicking-an-interview/
 * Arrays
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        
        int[] arr = {21,10, 11, 16, 17, 19, 12};
        int[] response = productOfArrayExceptSelf(arr);
        System.out.println(response);

    }

    /*time complexity - 0(n) and Auxilary Space is 0(1)  */
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
