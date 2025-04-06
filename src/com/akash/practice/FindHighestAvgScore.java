package com.akash.practice;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given a 2-D String array of student-marks find the student with the highest average and output his average score. 
 * If the average is in decimals, floor it down to the nearest integer.
 * 
 *  Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
 *  Output: 99
 *  Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
 */

public class FindHighestAvgScore {
    
    public static void main(String[] args) {
        String [][] str = {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};

        Double response = findHighestAvgScoreFromStudent(str);
        System.out.println(response);
    }

    private static double findHighestAvgScoreFromStudent(String[][] scores){

        /* grouping */
        Map<String, Integer> totalScoreMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String[] str : scores) {
            String name = str[0];
            int score = Integer.valueOf(str[1]);
            totalScoreMap.put(name, totalScoreMap.getOrDefault(name, 0)+score);
            countMap.put(name, countMap.getOrDefault(name, 0)+1);
        }

         /* find Avg score */
        double maxAvg = 0.0;
        for (String name : totalScoreMap.keySet()) {
            double avg = totalScoreMap.get(name)/countMap.get(name);
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }

    
}
