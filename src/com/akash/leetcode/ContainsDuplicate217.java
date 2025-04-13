package com.akash.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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
                boolean isResponse = containsDuplicateUsingStream(arr);
                boolean isStreamResponse = containsDuplicateUsingStreamWithSet(arr);
                boolean isSetCountresponse = containsDuplicateUsingStreamWithSetAndCount(arr);
                System.out.println(isResponse);
                System.out.println(isStreamResponse);
                System.out.println(isSetCountresponse);
                
            }

            /*
             * This algorithm uses a HashSet to store the elements of the array.
             * It iterates through the array and checks if each element is already in the HashSet.
             * If it is, a duplicate is found and the function returns true.
             * If no duplicates are found after checking all elements, it returns false.
             */
            /*
             * Time complexity - O(n)
             * Space complexity - O(n)
             */

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
    
            /*
             * This algorithm sorts the array first and then checks for duplicates.
             * It compares each element with the previous one in the sorted array.
             * If they are equal, a duplicate is found and the function returns true.
             * If no duplicates are found after checking all elements, it returns false.
             */
            /*  
             * Time complexity - O(nlogn)
             * Space complexity - O(1)
             */
            
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
            /*
             * Brute force algorithm
             * Time complexity - O(n^2)
             * Space complexity - O(1)
             */
            /*
             * This algorithm checks each element with every other element in the array.
             * It uses two nested loops to compare each pair of elements.
             * If a duplicate is found, it returns true.
             * If no duplicates are found after checking all pairs, it returns false.
             */
            /*
             * Time complexity - O(n^2)
             * Space complexity - O(1)
             */

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

            private static boolean containsDuplicateUsingStream(int[] arr) {
                return Arrays.stream(arr).distinct().count() != arr.length;
            }
            private static boolean containsDuplicateUsingStreamWithSet(int[] arr) {
                return Arrays.stream(arr).boxed().collect(Collectors.toSet()).size() != arr.length;
            }
            private static boolean containsDuplicateUsingStreamWithSetAndCount(int[] arr) {
                return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values().stream().anyMatch(count -> count > 1);
            }
}
