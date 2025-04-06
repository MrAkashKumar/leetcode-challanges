package com.akash.practice;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * reverse string word
 * reverse word order
 * reverse string 
 */

public class ReverseStringUsingJava8 {

    public static void main(String[] args) {
        String str = "This is my world";
        reverseStringWithJava8(str);
        reverseWordUsingJava8(str);
        String response = reverseWordUsingRecursion(str);
        System.out.println(response);
        reverseOrder(str);
        ReverseWordOrderUsingJava8(str);
    }

    private static void reverseStringWithJava8(String str){

         /* Split the string into words, reverse each word, and join them back */ 
        String result = Stream.of(str.split(" "))
                              .map(word -> new StringBuilder(word).reverse().toString())
                              .collect(Collectors.joining(" "));
        
        System.out.println("Reversed char: " + result);
    }

    private static void reverseWordUsingJava8(String str){
        /* Split, reverse, and join words */ 
        String reversed = Arrays.stream(str.split("\\s+"))
                                .reduce((a, b) -> b + " " + a)
                                .orElse("");
        
        System.out.println("Reversed words: " + reversed);
    }

    private static String reverseWordUsingRecursion(String str){

        if (str.isEmpty()) {
            return str; /* Base case: empty string */ 
        } else {
            return reverseWordUsingRecursion(str.substring(1)) + str.charAt(0);
        }
    }

    private static void reverseOrder(String str){

        String[] array = str.split("\\s+");
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // Swap elements
            String temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        String response = String.join(" ", array);
        System.out.println(response);
    }

    private static void ReverseWordOrderUsingJava8(String str){

        /* Split, reverse, and join words */ 
        String reversed = Arrays.stream(str.split("\\s+"))
                                .reduce((a, b) -> b + " " + a)
                                .orElse("");
        
        System.out.println("Reversed words order: " + reversed);

    }


    
}
