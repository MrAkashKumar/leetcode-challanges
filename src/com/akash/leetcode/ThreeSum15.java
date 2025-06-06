package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *
 * https://leetcode.com/problems/3sum/description/
 * two pointer technique
 * Array Questions
 */
public class ThreeSum15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    /*  Time Complexity: O(n^2)
        Space Complexity: O(1)
        1. Sort the array
        2. Fix one element and use two pointers to find the other two elements
        3. If the sum of the three elements is equal to zero, add them to the result
        4. If the sum is less than zero, move the left pointer to the right
        5. If the sum is greater than zero, move the right pointer to the left
    */
    /*   * 1. Sort the array
        2. Fix one element and use two pointers to find the other two elements
        3. If the sum of the three elements is equal to zero, add them to the result
        4. If the sum is less than zero, move the left pointer to the right
        5. If the sum is greater than zero, move the right pointer to the left
    */
    private static List<List<Integer>> threeSum(int[] nums){
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(set);
        return output;
    }

}
