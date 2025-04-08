package com.akash.basic;
/*
 *  
 */
public class Runner2 {

    public static void print(int value) {
        System.out.println("Primitive int method called with value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("Integer object method called with value: " + value);
    }

    public static void print(Object value){
        System.out.println("object method called with value: " + value);
    }

    public static void main(String[] args) {
        
        /* Calling with primitive int */ 
        print(10); /* Output: Primitive int method called with value: 10 */ 
        
        /* Calling with Integer object */ 
        print(Integer.valueOf(20)); /* Output: Integer object method called with value: 20 */ 
        
        /* Calling with autoboxed int */ 
        print(30); /* Output: Primitive int method called with value: 30 */ 
        
        /* Calling with autoboxed Integer */ 
        print(Integer.valueOf(40)); /* Output: Integer object method called with value: 40 */ 

        print(210);
    }
    
}
