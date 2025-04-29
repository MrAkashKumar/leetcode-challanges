package com.akash.leetcode;

import java.util.Arrays;
/*
 * https://leetcode.com/problems/maximize-greatness-of-an-array/description/
 */

public class FindMaximumGreatness2592 {
    
    public static void main(String[] args) {

        int[] nums = {1,3,5,2,1,3,1};
        maximizeGreatness(nums);
        
    }

    /*
     * Two pointer approach
     */
    public static int maximizeGreatness(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[left]) {
                left++;
            }
        }
        return left;
    }


}
