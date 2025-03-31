package com.akash.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
 * length of string
 */
public class StringNoOfLengthUsingStreamApi {
    /*
     * 
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Hello", "Video", "Hi", "Program", "Microsoft");
        Map<String, Integer> mapValue = findLengthOfStringUsingStream(list);
        System.out.println(mapValue);
    }


    /*
     * find length from string if using stream api
     */
    private static Map<String, Integer> findLengthOfStringUsingStream(List<String> list){
        return list.stream().collect(Collectors.toMap(str-> str, String::length));
    }

}
