package com.akash;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentWordBasedOnN {

    public static void main(String[] args) {
        mostFrequent();
    }

    private static void mostFrequent(){
        String arr[] = {"BA", "B.tech", "MBBS", "#2", "MBBS", "MBBS", "MBBS", "#1", "MBBS", "B.sc", "BA", "B.tech",  "B.tech", "#3", "#4"};


        // Finding the most frequent #N
        String mostFrequentN = Arrays.stream(arr)
                .filter(s -> s.startsWith("#")) // Filter elements starting with #
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())) // Count occurrences
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Get max by value
                .map(Map.Entry::getKey) // Extract key (#N)
                .orElse("No #N found"); // Default if none found
        System.out.println(mostFrequentN);

    }

}
