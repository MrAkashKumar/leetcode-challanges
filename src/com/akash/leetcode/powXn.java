package com.akash.leetcode;
/*
 * https://leetcode.com/problems/powx-n/description/
 * 
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 * write a program for convert decimal to binary and binary to decimal in java
 * Type Arrays
 * 
 */
public class powXn {


    public static void main(String[] args) {
        double x=2.00000; 
        int n= 10;
        double response = powerXnLeetcode(x, n);
        System.out.println(response);
    }


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
