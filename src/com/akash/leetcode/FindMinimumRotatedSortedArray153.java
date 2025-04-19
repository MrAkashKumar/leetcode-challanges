package com.akash.leetcode;
/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumRotatedSortedArray153 {

    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2}; 
        int finalValue = minimumRotatedSortedArray(arr);
        System.out.println(finalValue);
        int minValue = minimumRotatedSortedArrayWithMinimum(arr);
        System.out.println(minValue);
    }
    /*
     * example - {4,5,7,0,1,2}
     * here mid greater than right so we will move mid+1 so it will be left because this is the sorted array
     * but right will mid
     */
    /*
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private static final int minimumRotatedSortedArray(int[] nums){

        if(nums.length==1){
            return nums[0];
        }
        
        int left = 0; int right = nums.length-1;
        while(left < right){
            int mid = left + (right- left)/2;
            if(nums[mid] >= nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }

    /*
     *  int length = 9;
     *  int part1 = length / 2;
     *  int part2 = length - part1; 
    */

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int minimumRotatedSortedArrayWithMinimum(int[] nums){

        int length = nums.length;
        int minValue = nums[0];
        //int halfLength = length/2;
        for (int i = 0; i < length/2; i++) {
            minValue = Math.min(minValue, nums[i]);
        }
        //int l = length - length/2;
        for(int i = length/2; i<=length-length/2; i++){
            minValue = Math.min(minValue, nums[i]);
        }
        return minValue;
    }
    

}
