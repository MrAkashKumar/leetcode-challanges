package com.akash.leetcode;

import java.util.HashSet;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class FindSubStringWithoutRepeating03 {
    
    public static void main(String[] args) {
        
        String str = "abcabcbb";
        int subStringRepeatingCount = findSubStringWithoutRepeatingChar(str);
        System.out.println(subStringRepeatingCount);
    }

    /*
     * 
     */
    private static int findSubStringWithoutRepeatingChar(String str){

        int n = str.length();
        int left = 0;
        int maxLengthOfSubString = 0;

        HashSet<Character> hashSet = new HashSet<>();

        for(int right = 0; right < n; right++){
            while (hashSet.contains(str.charAt(right))) {
                hashSet.remove(str.charAt(left));
                left++;
            }
            hashSet.add(str.charAt(right));
            maxLengthOfSubString = Math.max(maxLengthOfSubString, right-left+1);
        }
        return maxLengthOfSubString;
    }
}
