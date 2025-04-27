package com.akash.leetcode;

/*
 * https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/
 */
public class CountSubArrayOfLength3392 {

    public static void main(String[] args) {

        int[] nums = {1,2,1,4,1};

        int result = countGoodSubArray(nums);

        System.out.println(result);

        int response = countSubArray(nums);
        System.out.println(response);
        
    }

    private static int countGoodSubArray(int[] nums){
        int count = 0;
        for(int i=0; i<nums.length-2; i++){
            int sum = nums[i] + nums[i+2];
            if(nums[i+1]/2 == sum){
                count++;
            }
        }

        return count;
    }

    private static int countSubArray(int[] nums){

        int count = 0;
        int index = 0;

        while (index < nums.length-2) {

            if(nums[index+1]/2== nums[index]+nums[index+2]){
                count++;
            }
            index++;
        }
        return count;
    }



    

    

}


