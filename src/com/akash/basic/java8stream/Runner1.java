package com.akash.basic.java8stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Runner1 {

    public static void main(String[] args) {
        print1T0100UsingStream();
        occuranceOfString("ABCD");
    }

    private static void print1T0100UsingStream(){

        IntStream.range(1, 100).forEach(b-> System.out.println(b)); // 1-99
        System.out.println("--------------------");
        IntStream.rangeClosed(1, 100).forEach(System.out::println); // 1-100
    }

    private static void occuranceOfString(String str){

         Map<Character, Long> occuranceOfString = str.chars().mapToObj(m -> (char) m).
         collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(occuranceOfString);

    }

    
}
