package com.akash.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {

    public static void main(String[] args) {
        
        String str1 = "anagram";
        String str2 = "nagaram";
        
        System.out.println(validAnagram(str1, str2)); // true
        //System.out.println(isValidAnagram("rat", "car")); // false
        //System.out.println(isValidAnagram("a", "ab")); // false
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

    /*
     * added character into map and then after removing same character from map
     * 
     */
    private static boolean isValidAnagramUsingHashMap(String str1, String str2){

        if(str1.length() != str2.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str1.toCharArray()) {
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
            /*map.put(c, map.getOrDefault(c, 0)+1); */
        }
        for(char ch : str2.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }
            map.put(ch, map.get(ch)-1);
            if(map.get(ch)<0){
                return false;
            }
        }

        return true;

     }

     /*  
      Standard ASCII has:
        128 characters (0 to 127)Includes control characters 
        (like \n, \t), symbols, digits, uppercase and lowercase letters

      Type	Range	Array Size      Needed
      Standard ASCII	0–127	      128
      Extended ASCII	0–255	      256
      Unicode (UTF-16)	0–65,535+	Not recommended for arrays – use Map<Character, Integer> instead
      */
        /* 
            Time Complexity
                str1.length() != str2.length() → O(1)
                for i = 0 to n → O(n) (where n = length of the strings)
                for count in intArray → O(1) → Because size is constant (129)

            ✅ Total Time Complexity:
                O(n) — linear in terms of input size

            💾 Space Complexity
                intArray is of fixed size (129 integers) → O(1) (constant space)

                No additional space that grows with input

            ✅ Total Space Complexity:
                O(1) — constant space (assuming character set is fixed, e.g., ASCII)
        */       
    private static boolean validAnagram(String str1, String str2){

        if(str1.length()!= str2.length()){
            return false;
        }

        int[] intArray = new int[128]; /* ASCII */
        
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        for (int i = 0; i < str1.length(); i++) {
            intArray[ch1[i]]++;
            intArray[ch2[i]]--;
        }

        for(int count : intArray){
            if(count != 0){
                return false;
            }
        }
        return true;
    }




}
