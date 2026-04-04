package com.akash.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix
 */
/**
 * 🧠 Idea Behind the Question
 *     We want the longest prefix string that is common to all input strings.
 *    ⚠ Two-pointer/sliding window techniques are not directly applicable because:
 *       We are comparing prefixes across multiple strings, not adjacent pairs.
 *       However, variations of comparing characters across index positions resemble two-pointer logic.
 */
/**
 * 📊 Multiple Approaches
 *  | Approach            | Time       | Space | Interview Value |
    | ------------------- | ---------- | ----- | --------------- |
    | Horizontal Scanning | O(S)       | O(1)  | ✔️ Good         |
    | Vertical Scanning   | O(S)       | O(1)  | ✔️ Best         |
    | Divide and Conquer  | O(S)       | O(m)  | ✔️ Good         |
    | Binary Search       | O(S log m) | O(1)  | ✔️ Advanced     |
    | Trie                | O(S)       | O(S)  | ✨ Bonus        |
    Here, m = number of strings, S = total number of characters in all strings.
 */
public class LongestCommonPrefix14 {
   
    public static void main(String[] args) {

        /**
         * 
         * Input: ["flower","flow","flight"], Output: "fl"
         * Input: ["dog","racecar","car"], Output: ""
         * Explanation: There is no common prefix among the input strings.
         * 
         */
        String input[] = {"flower","flow","flight"};
        String longestPrefix = longestCommonPrefix(input);

        System.out.println("Longest common Prefix  " + longestPrefix);
        

    }

    /**
     * 
     * 🚀 Approach 1 — Vertical Scanning (Best Interview Approach)
     * 🧠 Logic
            Compare characters at index i across all strings.
            Stop when mismatch or one string ends.
        Complexity
        | Case  | Time | Space |
        | ----- | ---- | ----- |
        | Best  | O(S) | O(1)  |
        | Worst | O(S) | O(1)  |
     */

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            /* compare with every other string */ 
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /*
        🌀 Approach 2 — Horizontal Scanning
           🧠 Logic
             Take prefix from first string, compare with next.
        
        ⏱ Complexity
        | Case  | Time | Space |
        | ----- | ---- | ----- |
        | Best  | O(S) | O(1)  |
        | Worst | O(S) | O(1)  |
    */
    public String longestCommonPrefixHorizontal(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * 🔎 Approach 3 — Divide and Conquer
     * | Case  | Time | Space |
       | ----- | ---- | ----- |
       | Worst | O(S) | O(m)  |
     */
    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        return divideConquer(strs, 0, strs.length - 1);
    }

    private String divideConquer(String[] strs, int l, int r) {
        if (l == r) return strs[l];

        int mid = (l + r) / 2;
        String leftPrefix = divideConquer(strs, l, mid);
        String rightPrefix = divideConquer(strs, mid + 1, r);

        return commonPrefix(leftPrefix, rightPrefix);
    }

    private String commonPrefix(String left, String right) {
        int minLen = Math.min(left.length(), right.length());
        int i = 0;
        while (i < minLen && left.charAt(i) == right.charAt(i)) {
            i++;
        }
        return left.substring(0, i);
    }

    /**
     * 🔢 Approach 4 — Binary Search
     *  Complexity - 
     *  | Case  | Time       | Space |
        | ----- | ---------- | ----- |
        | Worst | O(S log m) | O(1)  |
     * 
    */

    public String longestCommonPrefixBinary(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        int low = 1;
        int high = minLen;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) return false;
        }
        return true;
    }

    /**
     * 
     * Input: ["flower","flow","flight"]
     *   Compare index 0: f vs f vs f → ok
     *   index 1: l vs l vs l → ok
     *   index 2: o vs o vs i → mismatch
     *   Return: "fl"

     */
    
    /**
     * Check:
        index 0 – same
        index 1 – same
        …
        index 4 – same
        index 5 – mismatch → return "aaaaa"
    */

    /**
     * 
     *  Complexity 
     * 
     *  | Approach            | Best Case | Worst Case | Space |
        | ------------------- | --------- | ---------- | ----- |
        | Vertical Scanning   | O(S)      | O(S)       | O(1)  |
        | Horizontal Scanning | O(S)      | O(S)       | O(1)  |
        | Divide & Conquer    | O(S)      | O(S)       | O(m)  |
        | Binary Search       | O(S)      | O(S log m) | O(1)  |
        | Trie                | O(S)      | O(S)       | O(S)  |
     * 
     */


}
