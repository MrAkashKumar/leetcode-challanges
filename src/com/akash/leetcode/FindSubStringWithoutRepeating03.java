package com.akash.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class FindSubStringWithoutRepeating03 {
    
    public static void main(String[] args) {
        
        String str = "abcabcbb";
        /*
         * better approach
         */
        int subStringRepeatingCount = findSubStringWithoutRepeatingChar(str);
        System.out.println(subStringRepeatingCount);
        /*
         * Brute force
         */
        int lengthOfSubStringRepeat = findLengthOfSubStringWithoutRepeatingChar(str);
        System.out.println(lengthOfSubStringRepeat);
        /*
         * optimal solution
         */
        int lengthOfRepeatedSubString = findLengthOfRepeatedSubStringCharacter(str);
        System.out.println(lengthOfRepeatedSubString);

    }

    /*
     * Time complexity - o(n)
     * Space complexity - o(k*n)
     */
    private static int findSubStringWithoutRepeatingChar(String str){

        int n = str.length();
        int left = 0;
        int maxLengthOfSubString = 0;
        HashSet<Character> hashSet = new HashSet<>();

        /* expand window by moving right */
        for(int right = 0; right < n; right++){
            /* if a duplicate is found shrink the window from the left */
            while (hashSet.contains(str.charAt(right))) {
                hashSet.remove(str.charAt(left));
                left++;
            }
            /* add current character to window and update the max length */
            hashSet.add(str.charAt(right));
            maxLengthOfSubString = Math.max(maxLengthOfSubString, right-left+1);
        }
        return maxLengthOfSubString;
    }

    /*
     * 
     */
    private static int findLengthOfRepeatedSubStringCharacter(String str){

        int length = str.length();
        int[] freq = new int[128]; /* ASCII character frequency Array */
        int maxLength = 0;
        int left = 0;

        /* expand window by moving right */
        for(int right = 0; right < length; right++){
            char currentChar = str.charAt(right);
            freq[currentChar]++; /* increase frequency of the current charater */

            /* if there is a duplicate shrink the window from the left */
            while(freq[currentChar]>1){
                freq[str.charAt(left)]--;
                left++;
            }

            /* update maximum window size */
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    /*
     * Brute force 
     * Time complexity - o(n^3)
     * 
     */
    private static int findLengthOfSubStringWithoutRepeatingChar(String str){

        int maxLength = 0;
        int n = str.length();

        for(int i = 0; i< n; i++){
            for(int j = 1; j< n; j++){
                if(isUnique(str, i, j)){
                    maxLength = Math.max(maxLength,  j-i+1);
                }
            }
        }
        return maxLength;
    }

    private static boolean isUnique(String str, int start, int end){
        Set<Character> set = new HashSet<>();
        
        for(int k = start; k <= end; k++){
            if(set.contains(str.charAt(k))){
                return false;
            }
            set.add(str.charAt(k));
        }
        return true;
    }


}
