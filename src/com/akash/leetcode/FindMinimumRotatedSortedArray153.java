package com.akash.leetcode;
/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */
public class FindMinimumRotatedSortedArray153 {

    public static void main(String[] args) {
        int [] arr = {3,4,5,1,2}; 
        int finalValue = minimumRotatedSortedArray(arr);
        System.out.println(finalValue);
    }
    /*
     * The idea is to use binary search to find the minimum element in the rotated sorted array.
     * We compare the middle element with the leftmost and rightmost elements to determine which half of the array is sorted.
     * Based on this information, we can decide which half to search next.
     */
    /*
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    /*
     * The function takes an array of integers as input and returns the minimum element in the rotated sorted array.
     * It initializes the left and right pointers to the start and end of the array, respectively.
     * It then enters a while loop that continues until the left pointer is less than or equal to the right pointer.
     * Inside the loop, it calculates the middle index and compares the middle element with the leftmost and rightmost elements.
     * Depending on which half of the array is sorted, it updates the left or right pointer accordingly.
     */
    /*
     * The function also keeps track of the minimum element found so far and updates it as necessary.
     * Finally, it returns the minimum element found in the rotated sorted array.
     */
    /*
     * The function is efficient and works well for large arrays, making it a good choice for finding the minimum element in a rotated sorted array.
     */
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
