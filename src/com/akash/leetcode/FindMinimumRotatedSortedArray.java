package com.akash.leetcode;
/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumRotatedSortedArray {

    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2}; 
        int finalValue = minimumRotatedSortedArray(arr);
        System.out.println(finalValue);
    }

    private static final int minimumRotatedSortedArray(int[] nums){

        int n = nums.length;
        int min = 5000 + 1;
        int left = 0, right = n-1;
        
        while (left <= right) {
            int mid = (left + right)/2;
            if(nums[left] <= nums[mid]){
                min = Math.min(min, nums[left]);
                left = mid +1;
            }else{
                min = Math.min(min, nums[mid]);
                right = mid -1;
            }
        }
       return min;
    }

}
