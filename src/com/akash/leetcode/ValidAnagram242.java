package com.akash.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {

    public static void main(String[] args) {
        
        String str1 = "anagram";
        String str2 = "nagaram";
        
        System.out.println(isValidAnagram("anagram", "nagaram")); // true
        System.out.println(isValidAnagram("rat", "car")); // false
        System.out.println(isValidAnagram("a", "ab")); // false
        System.out.println(isValidAnagram(str1, str2)); // true

        boolean isValidAnagram = isValidAnagramUsingHashMap(str1, str2);
        System.out.println(isValidAnagram);
    }
    
    /*
     * 
     */
    private static boolean isValidAnagram(String str1,  String str2){

        if(str1.length()!=str2.length()){
            return false;
        }

        str1 = str1.trim().toLowerCase();
        str2 = str2.trim().toLowerCase();

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

    private static boolean isValidAnagramUsingHashMap(String str1, String str2){

        if(str1.length() != str2.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            if(map.containsKey(ch)){
                
            }

            
        }

        return false;

     }


}
