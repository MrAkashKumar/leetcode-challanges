package com.akash.basic.stream;

import java.util.stream.IntStream;

public class Runner1 {

    public static void main(String[] args) {
        
        IntStream.range(1, 100).forEach(b-> System.out.println(b));

        IntStream.rangeClosed(1, 100).forEach(System.out::println);

    }
    
}
