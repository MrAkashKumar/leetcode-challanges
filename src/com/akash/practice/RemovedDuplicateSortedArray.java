package com.akash.practice;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
/*
 * removed duplicate sorted array and remaining add null value
 */
public class RemovedDuplicateSortedArray {
    
    public static void main(String[] args) {
        
        int arr[] = {1, 2, 2, 3, 4, 4 };
        /*
         * output - {1, 2, 3, 4, null, null}
         */
        int length = arr.length;
        removeDuplicateSortedArrayWithNull(arr, length);
    }

    private static void removeDuplicateSortedArrayWithNull(int arr[], int length){

        int index = 0;
        Integer[] num = new Integer[arr.length];

        Set<Integer> setValue = new LinkedHashSet<>();
        for (Integer integer : arr) {
            setValue.add(integer);
        }
        /*
         * fill array
         */
        for(Integer setVal : setValue){
            num[index++] = setVal;
        }
        /*
         * fill remaining num array
         */
        while (index < num.length) {
            num[index++] = null;
        }
        System.out.println(Arrays.toString(num));
    }
}