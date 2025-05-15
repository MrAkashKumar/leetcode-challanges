package com.akash.basic.stream;

import java.util.stream.IntStream;

public class Runner1 {

    public static void main(String[] args) {
        print1T0100UsingStream();
    }

    private static void print1T0100UsingStream(){

        IntStream.range(1, 100).forEach(b-> System.out.println(b)); // 1-99
        System.out.println("--------------------");
        IntStream.rangeClosed(1, 100).forEach(System.out::println); // 1-100
    }

    
}
