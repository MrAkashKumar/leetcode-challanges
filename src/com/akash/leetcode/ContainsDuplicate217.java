package com.akash.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/contains-duplicate/description/
 * https://leetcode.com/problems/contains-duplicate/solutions/3672475/4-method-s-c-java-python-beginner-friendly/
 * Type - Array
 * 
 */
public class ContainsDuplicate217 {

            public static void main(String[] args) {
                int arr[] = {1,2,3,1};
                boolean response = containsDuplicateForBruteAlgorithm(arr);
                System.out.println(response);
                boolean sortResponse = containsDuplicateCheckViaSorting(arr);
                System.out.println(sortResponse);
                boolean setResponse = containDuplicateCheckViaHashSet(arr);
                System.out.println(setResponse);
            }

            

            private static boolean containDuplicateCheckViaHashSet(int[] arr){
                Set<Integer> setValue = new HashSet<>();
                for(Integer num : arr){
                    if(setValue.contains(num)){
                        return true;
                    }
                    setValue.add(num);
                }
                return false;
            }

            private static boolean containsDuplicateCheckViaSorting(int[] arr){
                /* first sort array */
                Arrays.sort(arr);
                int length = arr.length;
                for(int i = 1; i<length; i++){
                    if(arr[i] == arr[i-1]){
                        return true;
                    }
                }
                return false;
            }
        
            private static boolean containsDuplicateForBruteAlgorithm(int[] arr) {
                
                int length = arr.length;

                for(int i = 0; i< length-1; i++){
                    for(int j = i+1; j<length; j++){
                        
                        if(arr[i]==arr[j]){
                            return true;
                        }
                    }
                }
                return false;
            }

}
