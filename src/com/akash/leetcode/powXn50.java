package com.akash.leetcode;
/*
 * https://leetcode.com/problems/powx-n/description/
 * 
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 * write a program for convert decimal to binary and binary to decimal in java
 * Type Arrays
 * 
 */
public class powXn50 {


    public static void main(String[] args) {
        double x=2.00000; 
        int n= 10;
        double response = powerXnLeetcode(x, n);
        System.out.println(response);
    }

    /* algorithm
     * 1. if x is 1 then return 1
     * 2. if x is -1 then return -1 if n is odd else return 1
     * 3. if n is 0 then return 1
     * 4. if n is Integer.MIN_VALUE then return 1/(powerXnLeetcode(x, Integer.MAX_VALUE) * x)
     * 5. create a variable result and set it to 1.0
     * 6. create a variable power and set it to the absolute value of n
     * 7. while power > 0 do the following:
     *    a. if power is odd then multiply result by x
     *    b. multiply x by itself
     *    c. divide power by 2
     * 8. return result if n is positive else return 1/result
     */
    /* * Time complexity: O(log n)
     * Space complexity: O(1)
     * 
     * 1. The time complexity is O(log n) because we are dividing the power by 2 in each iteration of the while loop.
     * 2. The space complexity is O(1) because we are using a constant amount of space to store the result and power variables.
     */
    private static double powerXnLeetcode(double x, int n){

        if (x == 1D) return 1D; 
        if (x == -1D) return (n % 2 == 0) ? 1D : -1D; 
        if (n == 0) return 1D; 
        if (n == Integer.MIN_VALUE) { 
            return 1 / (powerXnLeetcode(x, Integer.MAX_VALUE) * x);
        }
        
        double result = 1.0;
        long power = Math.abs((long) n);
        while (power > 0) {
            if (power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power /= 2;
        }
        
        return (n < 0) ? 1.0 / result : result;
    }
}
