package com.akash.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicateArray442 {

    /*
        note - number will be range 1 to n 
    */

    public static void main(String[] args) {
        
        int[] num = {4,3,2,7,9,2,3,1};
        List<Integer> response = findAllDuplicateVisitedArray(num);
        System.out.println(response);
        List<Integer> duplicateList =  findAllDuplicateFromArrayUsingSet(num);
        System.out.println(duplicateList);

        List<Integer> duplicateCount = findAllDuplicateCountFromArray(num);
        System.out.println(duplicateCount);
    }

    /*
     * if number visited then add otherwise mark visited number 
     * Time Complexity - 0(n)
     * Space complexity - 0(1)
     */

    private static List<Integer> findAllDuplicateVisitedArray(int[] nums){

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                result.add(index + 1); /* if you have visited on above number then you can add into list */
            } else {
                nums[index] = -nums[index]; /* this respresentation is use for visited number */
            }
        }
        return result;
    }

     /*
     * created memoery and counting duplicate from array if more than 1 or equal 2 then adding into list
     * Time Complexity - 0(n)
     * Space complexity - 0(n)
     */
    public static List<Integer> findAllDuplicateCountFromArray(int[] nums){
        List<Integer> list = new ArrayList<>();

        int[] arr = new int[nums.length+1]; /* +1 because  this will be 1 to n so added  here creating extra space */
        for(int i= 0; i< nums.length; i++){

            arr[nums[i]]++;
            if(arr[nums[i]]==2){
                list.add(nums[i]);
            }
        }
        return list;

    }

    /*
     * using set interface for avoiding duplicate and check if found then we are adding into list
     * Time complexity - 0(n)
     * Space complexity - 0(n)
     */
    private static List<Integer> findAllDuplicateFromArrayUsingSet(int[] nums){
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)){
                list.add(n);
            }else{
                set.add(n);
            }
        }
        return list;
    }


    
}
