package com.akash.leetcode;
/*
 * https://leetcode.com/problems/sort-array-by-parity/description/
 */

import java.util.Arrays;

public class SortArrayByParity905 {

    public static void main(String[] args) {

        /*
         * Two pointer approach
         */
        int[] arr = {3,1,2,4};
        int[] res = sortArrayByParity(arr);

        /*
         * Java8
         */
        int[] response = sortArrayByParityUsingJava8(arr);

        System.out.println(res);
        System.out.println(response);

        int[] result = sortArrayByParityUsingTwoPointer(arr);
        
        System.out.println(result); /* Output: [2, 4, 3, 1] (Relative order maintained) */ 
    }
    
    /*
     * Two pointer program
     */

    public static int[] sortArrayByParity(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            /* Swap if left is odd and right is even */
            if (nums[left] % 2 > nums[right] % 2) { 
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) left++;  /* Move left pointer if it's even */
            if (nums[right] % 2 == 1) right--; /* Move right pointer if it's odd */
        }
        return nums; 
    }

    /*
     * Java8
     */
    private static int[] sortArrayByParityUsingJava8(int[] arr){
        return Arrays.stream(arr)
                 .boxed()
                 .sorted((a, b) -> (a % 2) - (b % 2))
                 .mapToInt(Integer::intValue)
                 .toArray();
    }

    /*
     * Using Sorting (Less Efficient)
     */
    private static int[] sortArrayByParityUsingTwoPointer(int[] nums) {
        
        int left = 0; int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 == 0) {
                left++;
            } else {
                // swap with right
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }
        }

        return nums;
    }
    
}
