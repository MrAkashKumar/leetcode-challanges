package com.akash.basic;

public class Runner0 {

    public static void main(String[] args) {
        solution1();
        solution2();
        
    }

    public static void solution1(){
        byte x = 127;
            x++;
            x++;
        System.out.print(x);
    }
    
    public static void solution2(){
        int[] x = {120, 200, 016};
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
    
        }
    }
    
    
   
    
}
