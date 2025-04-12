package com.akash.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 * 
 */
public class MovesZero283 {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroesFromArray(arr);
    }

    /*
     * technique - Two pointer technique
     * space complexity = O(1)
     * Time complexity = O(n)
     */
    public static void moveZeroesFromArray(int[] nums){

        int left = 0; /* pointer for placing no-zero elements  */
        
        /*iterate the right pointer */
        for(int right = 0; right < nums.length; right++ ){
            if(nums[right] != 0){
                /*
                 * swap element if right pointer finds a non-zero elements
                 */
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; /* move left pointer forward */
            }
        }
        System.out.println(Arrays.toString(nums));

    }


    
}
