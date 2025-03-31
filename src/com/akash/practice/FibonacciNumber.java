package com.akash.practice;
/*
 * 
 * 
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSeriesUsingRecursion(i)+ " ");
        }
    }
    /*
     * fibonacci series upTo nth 
     */
    private static int fibonacciSeriesUsingRecursion(int number){
        if(number <=1){
            return number;
        }
        return fibonacciSeriesUsingRecursion(number-1) + fibonacciSeriesUsingRecursion(number-2);
    }

}
