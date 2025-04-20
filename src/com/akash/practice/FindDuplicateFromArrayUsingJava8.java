package com.akash.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;

public class FindDuplicateFromArrayUsingJava8 {
    

    public static void main(String[] args) {
        
        /*
       * String str[] = {"Sonali","soNali", "RAm"}; 
       */
      String str[] = {"Sonali","Sonali", "Ram"};
      Map<String, Long> duplicateMap = findDuplicateInListFromArray(str);
      System.out.println(duplicateMap);

    }

    private static Map<String, Long> findDuplicateInListFromArray(String[] str){
        List<String> list = Arrays.asList(str);
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().filter(res-> res.getValue()>1)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    
}
