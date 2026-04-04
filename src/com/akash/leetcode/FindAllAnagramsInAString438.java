package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *  ✔ Anagram: same characters, same frequencies
    ✔ Order doesn’t matter
    🧠 Idea Behind This Question
        We must find all substrings of length |p| that are anagrams of p.
        The most efficient way:
            👉 Sliding Window + Frequency Count
        This is the BEST interview approach.
 */
/**
 *  🧩 Multiple Approaches Overview
 * 
 *  | Approach              | Time           | Space    | Interview Value          |
    | --------------------- | -------------- | -------- | -------------------------|
    | Brute Force           | O(n · m log m) | O(m)     | ❌ Bad                   |
    | Sorting Check         | O(n · m log m) | O(m)     | ❌ Bad                   |
    | HashMap + Compare     | O(26·n)        | O(1)     | ✔ Good                   |
    | Sliding Window (best) | **O(n)**       | **O(1)** | ⭐ BEST for Interview    |
    | Two-Pointer Variation | O(n)           | O(1)     | ✔ Same concept           |

 */

public class FindAllAnagramsInAString438 {
    
    public static void main(String[] args) {

        /**
         * Input: s = "cbaebabacd", p = "abc"
            Output: [0, 6]

            Explanation: 
                - s[0..2] = "cba" → anagram of "abc"
                - s[6..8] = "bac" → anagram of "abc"

            
            Input: s = "abab", p = "ab"
            Output: [0,1,2]
         */

        String s = "abab";
        String p = "ab";
        List<Integer> response = findAnagrams(s, p);
        System.out.println("Find all Anagram via sliding window "+ response);
        System.out.println(" ======================> ");

        System.out.println("Find all anagram via brute force "+ bruteForce(s,p));

        System.out.println("Find all anagram via two pointer "+ twoPointerWay(s,p));
    
    }

    /**
     * 🏆 BEST APPROACH (Sliding Window) — Recommended in Interviews
     *       ✔ Time: O(n)
     *       ✔ Space: O(1) (26 chars only)
     * 🧠 Step-by-Step Logic
            Window size = length of p
            Slide over s:
            At each step:
                Add new right char
                Check if frequencies match
                Remove left char
                Move window
        
        🗂️ Time & Space Complexity
        ------------------------------------------------------------------------------------------------
        | Case                             | Time                                | Space               |
        | -------------------------------- | ----------------------------------- | ------------------- |
        | **Best Case** (s shorter than p) | O(1)                                | O(1)                |
        | **Average/Worst Case**           | **O(n)**                            | **O(1)**            |
        | Why?                             | Every char added once, removed once | Only 26-size arrays |
        ------------------------------------------------------------------------------------------------
     * 
     */
    
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] countP = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int k = p.length();

        while (right < s.length()) {
            /* add current char */ 
            window[s.charAt(right) - 'a']++;

            /* keep window size == k */ 
            if (right - left + 1 == k) {
                if (Arrays.equals(window, countP)) {
                    result.add(left);
                }

                /* remove outgoing character */ 
                window[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }

        return result;
    }

    /**
     * 📝 Steps You Should Follow in Interview
     *      Understand anagram = same frequency
            Use sliding window of size |p|
            Maintain frequency arrays (size 26)
            Move window (right++, left++)
            Compare frequency arrays
            Collect indices
     * 
     */


    /**
     * 🧪 Brute Force Approach (Not Good in Interview)
     * ⛔ Complexity:
     *      Time: O(n · m log m), Space: O(m)
     * 
     */
    public static List<Integer> bruteForce(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = p.length();

        char[] sortedP = p.toCharArray();
        Arrays.sort(sortedP);

        for (int i = 0; i + m <= s.length(); i++) {
            char[] sub = s.substring(i, i + m).toCharArray();
            Arrays.sort(sub);

            if (Arrays.equals(sub, sortedP)) {
                result.add(i);
            }
        }
        return result;
    }

    /*
    🔍 Example Trace
        s = "cbaebabacd", p = "abc"
        Window size = 3
        i=0..2 → "cba" → match → add 0  
        i=1..3 → "bae" → no  
        i=2..4 → "aeb" → no  
        i=6..8 → "bac" → match → add 6

        Output → [0, 6]
    */

    /**
     * ⭐ Two-Pointer Variant (Same as Sliding Window)
     * 
     */
    public static List<Integer> twoPointerWay(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] freq = new int[26];
        for (char c : p.toCharArray()) freq[c - 'a']++;

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a']-- >= 1) count--;

            if (count == 0) result.add(left);

            if (right - left + 1 == p.length()) {
                if (++freq[s.charAt(left) - 'a'] > 0) count++;
                left++;
            }
            right++;
        }
    return result;
}
    



}
