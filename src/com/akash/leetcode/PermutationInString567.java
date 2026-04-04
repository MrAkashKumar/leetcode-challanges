package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-in-string
 */
/**
 * 🎯 Real Interview Goal / Idea Behind Question
        The interviewer is testing:
            Understanding of fixed-size sliding window
            Ability to compare frequencies efficiently
            Avoiding expensive operations (sorting, generating permutations)
            Using two-pointer technique
            Handling window updates optimally
        This is a classic test of pattern matching using frequency maps.
 */

public class PermutationInString567 {

    public static void main(String[] args) {
        /*
            s1 = "ab"
            s2 = "eidbaooo" → "ba" is a permutation → return true

            🧪 Input / Output Example
            s1 = "abc"
            s2 = "ccccbbbbaaaaacba"

            Output: true
            Explanation: substring "cba" matches a permutation of "abc".

        */
       String s1 = "abc";
       String s2 = "ccccbbbbaaaaacba";
       boolean isPermutations = checkInclusionTwoPointers(s1, s2);
       System.out.println("is Permutations  =>  " + isPermutations);

    }

    /**
     * 
     *  ----------------------------------------------------
        ✅ APPROACH 4 — DIFFERENCE COUNT + TWO POINTERS (Best Interview Solution Approach)
        ----------------------------------------------------
        ✔ Key Logic
            Instead of comparing two arrays each time:
        We maintain:
            ➡ Matched characters count
                If counts match for all 26 chars → window contains permutation.
        Why it's best?
            O(m + n)
            No expensive array compare
            Simple logic
        Complexity - O(n) solution.
     * 
     */

    public static boolean checkInclusionTwoPointers(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) freq[c - 'a']++;

        int left = 0, right = 0, required = s1.length();

        char[] arr = s2.toCharArray();

        while (right < arr.length) {
            if (freq[arr[right] - 'a'] > 0) {
                required--;
            }

            freq[arr[right] - 'a']--;
            right++;

            if (required == 0) return true;

            if (right - left == s1.length()) {
                if (freq[arr[left] - 'a'] >= 0) {
                    required++;
                }
                freq[arr[left] - 'a']++;
                left++;
            }
        }
        return false;
    }

    /**
     * 🎯 Example Trace
        s1 = "ab"
        s2 = "eidbaooo"

        Window size = 2

        | Window | Content       | Match?       | Why    |
        | ------ | ------------- | ------------ | ------ |
        | ei     | freq mismatch | ❌           | no a/b |
        | id     | ❌            |              |        |
        | db     | ❌            |              |        |
        | ba     | ✔             | matches "ab" |        |

     * 
     */

    

    /**
     *  ----------------------------------------------------
        ✅ APPROACH 2 — Sorting Window (Sliding Window)
        ----------------------------------------------------
        ✔ Logic
            For each substring window of size len(s1) inside s2:
            Extract substring
            Sort it
            Compare with sorted s1
        ⏳ Time Complexity
            Sorting each window substring: O(n log n)
            Total windows = m − n
            ➡ Worst-case: O((m − n) * n log n)
            ➡ Best-case: first window matches
        🧠 Space Complexity
            O(n) for sorting arrays.
     */
    public static boolean checkInclusionSlidingWindow(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);

        int len = s1.length();

        for (int i = 0; i <= s2.length() - len; i++) {
            char[] temp = s2.substring(i, i + len).toCharArray();
            Arrays.sort(temp);

            if (Arrays.equals(sortedS1, temp)) return true;
        }
        return false;
    }

    /**
     *  ----------------------------------------------------
        ✅ APPROACH 3 — Frequency Array Comparison (Optimized)
        ----------------------------------------------------
        ✔  Logic
            Count frequency of s1 (count1[26])
            Slide window over s2 of length s1
            Maintain frequency counter for window (count2[26])
            Compare two arrays
        ⭐ Very efficient
        ⏳ Time Complexity
            Building counts: O(n)
            Sliding window: O(m)
        ➡ Worst-case: O(n + m)
        ➡ Best-case: found in first window: O(n)
        🧠 Space Complexity
            O(1) → 26 sized array
     * 
     */
    public static boolean checkInclusionArrayComparision(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) count1[c - 'a']++;

        int window = s1.length();
        char[] arr2 = s2.toCharArray();

        for (int i = 0; i < arr2.length; i++) {
            count2[arr2[i] - 'a']++;

            if (i >= window)
                count2[arr2[i - window] - 'a']--;

            if (Arrays.equals(count1, count2))
                return true;
        }
        return false;
    }

    /**
     *  ----------------------------------------------------
        ✅ APPROACH 1 — Brute Force (Generate All Permutations)
        ----------------------------------------------------
        ✔ Logic
            Generate all permutations of s1.
            Check whether any appears in s2.
        ❌ Extremely inefficient
            Generates n! permutations.
        ⏳ Time Complexity
            Generating permutations: O(n!)
            Checking substring for each: O(n)
            ➡ Worst-case: O(n! * m)
            ➡ Best-case: match found early
        🧠 Space Complexity
            O(n!) for storing permutations
     * 
     */

    public static boolean checkInclusion(String s1, String s2) {
        List<String> permutations = new ArrayList<>();
        generatePermutations("", s1, permutations);

        for (String p : permutations) {
            if (s2.contains(p)) return true;
        }
        return false;
    }

    private static void generatePermutations(String prefix, String remaining, List<String> list) {
        if (remaining.isEmpty()) {
            list.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            generatePermutations(prefix + remaining.charAt(i),
                                remaining.substring(0, i) + remaining.substring(i + 1),
                                list);
        }
    }

    
    /*
    🛑 Edge Cases
    
    | Case                   | Example                 | Output |
    | ---------------------- | ----------------------- | ------ |
    | s1 longer than s2      | s1="abcd", s2="abc"     | false  |
    | Repeated characters    | s1="aab", s2="aba"      | true   |
    | Characters not in s2   | s1="xyz", s2="aaaabbbb" | false  |
    | Multiple valid windows | s1="ab", s2="abab"      | true   |

    */
    



    

    
    
}
