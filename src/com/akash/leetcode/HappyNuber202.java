package com.akash.leetcode;
/*
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNuber202 {

    public static void main(String[] args) {
        int n = 10;
        boolean isHappy = isHappyNumber(n);
        System.out.println(isHappy);
    }
    /*
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle that does not include 1. Those numbers for which this process ends in 1 are happy.
     * 
     * Example:
     * Input: n = 19
     * Output: true
     * Explanation:
     * 1^2 + 9^2 = 82
     * 8^2 + 2^2 = 68
     * 6^2 + 8^2 = 100
     * 1^2 + 0^2 + 0^2 = 1
     */

    /*
     * fast and slow pointers
     */
    private static boolean isHappyNumber(int n){
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return false;
    }

    private static int getNext(int number){
        int sum = 0;
        while(number>0){
            int digit = number % 10;
            sum = digit * digit;
            number = number / 10;
        }
        return sum;
    }

}
