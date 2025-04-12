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
