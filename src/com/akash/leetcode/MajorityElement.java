package com.akash.leetcode;

/*
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,1};
        int response = findMajorityElement(nums);
        System.out.println(response);

    }
    
    /*
     * 
     *   Approach 4: Boyer-Moore Voting Algorithm
     */
    private static int findMajorityElement(int[] nums){
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
        count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    
}
