package com.akash.basic;

public class Runner0 {

    public static void main(String[] args) {
        solution1();
        solution2();
        
    }

    public static void solution1(){
        byte x = 127;
            System.out.println("Before: "+ x);
            x++;
            System.out.println("After 1 increment: "+ x);
            x++;
        System.out.println("After two increment: "+x);
        System.out.println("----------------");
    }
    
    public static void solution2(){
        int[] x = {120, 200, 016}; // 016 is the octal number
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] + " ");
    
        }
    }
    
    /*
     * find octal number 
     * Each digit is multiplied by 8 power n , where n is the position from right to left (starting at 0):
     * Example - 0212
     * 0212 =(2 * 8 power 2) + (1 * 8 power 1 ) + (2 * 8 power 0) = (2 × 64) + (1 × 8) + (2 × 1) = 138 decimal
     * Example  = 014
     * 014 = (1 * 8 power 1) + (4 * 8 power 0) = (8*1) + (4*1) = 12 decimal 
     */
    
   
    
}
