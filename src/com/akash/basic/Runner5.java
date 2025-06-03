package com.akash.basic;

import java.util.stream.IntStream;
/*
 * check this number is odd or even without using if, for, else loop
 */
public class Runner5 {
    
    public static void main(String[] args) {
        int number = 10;
        oddEvenWithoutIfElseFor(number);
        oddEvenWithoutIfElseForUsingJava8(number);
    }

    private static void oddEvenWithoutIfElseForUsingJava8(int number) {
        String[] result = {"Even", "Odd"};
        IntStream.rangeClosed(1, 10)
                 .mapToObj(i -> "Number " + i + " is " + result[i % 2])
                 .forEach(System.out::println);
    }

    private static void oddEvenWithoutIfElseFor(int number) {

        String[] result = {"Even", "Odd"};
        System.out.println("Number " + number + " is " + result[number % 2]);
    }
}
