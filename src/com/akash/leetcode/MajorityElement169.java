package com.akash.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
 * https://leetcode.com/problems/majority-element/description/
 */
public class MajorityElement169 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,1};
        int response = findMajorityElement(nums);
        System.out.println(response);
        findMajorityElementUsingHasmMap(nums);
        System.out.println(findMajorityElementUsingHasmMap(nums));
        /*
         * 
         *   Approach 2: Sorting
         */
        int majorityElementResponse = findMajorityElementUsingSorting(nums);
        System.out.println(majorityElementResponse);
        /*
         * 
         *   Approach 3: Divide and Conquer
         */
        int majorityElement = findMajorityElementUsingDivideAndConquer(nums, 0, nums.length - 1);
        System.out.println(majorityElement);
       

    }

    /*
     * 
     *   Approach 3: Divide and Conquer
     */
    private static int findMajorityElementUsingDivideAndConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        int leftMajority = findMajorityElementUsingDivideAndConquer(nums, left, mid);
        int rightMajority = findMajorityElementUsingDivideAndConquer(nums, mid + 1, right);

        if (leftMajority == rightMajority) {
            return leftMajority;
        }

        int leftCount = countInRange(nums, leftMajority, left, right);
        int rightCount = countInRange(nums, rightMajority, left, right);

        return leftCount > rightCount ? leftMajority : rightMajority;
    }
    private static int countInRange(int[] nums, int target, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }
    /*
     * 
     *   Approach 2: Sorting
     */
    private static int findMajorityElementUsingSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
     * 
     *   Approach 1: HashMap
     */
    private static int findMajorityElementUsingHasmMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1; // This line should never be reached for valid input
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
