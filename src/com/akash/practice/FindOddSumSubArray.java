package com.akash.practice;

public class FindOddSumSubArray {
    
    /*
     * 
     *       Input: arr = [1,3,5]
     *       Output: 4
     *       Explanation: All subarrays are 
     *       [[1],[1,3],[1,3,5],[3],[3,5],[5]]
     * 
     */

    public static void main(String[] args) {

        int [] arr = {1,3,5};
        int response = getOddSumSubArray(arr);
        System.out.println(response);

    }

    private static int getOddSumSubArray(int[] nums){

        int oddCount = 0, eventCount = 1;
        int count = 0; int sum = 0;
        int MOD = 1_000_000_007; // To avoid overflow

        for (int n : nums) {
            sum +=n;
            if(sum % 2 == 0){
                count = (count + oddCount)% MOD;
                eventCount++;
            }else{
                count = (count + eventCount) % MOD;
                oddCount++;
            }
        }
        return count;
    }
}
