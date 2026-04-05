package com.akash.leetcode;
/**
 * 🧠 Idea Behind This Question (Interview Perspective)
        Interviewers test if you can:
        Use sliding window + two pointers
        Optimize brute force from O(n³) to O(n)
        Track character frequency effectively
        Solve advanced string/window problems
        This problem separates beginners from advanced candidates.

        💡 Approach Comparison Table
        -----------------------------------------------------------------------
        | Approach         | Time  | Space | Notes                           |
        | ---------------- | ----- | ----- | --------------------------------|
        | ❌ Brute Force    | O(n³) | O(1)  | Only for learning              |
        | ❌ Improved Check | O(n²) | O(1)  | Still too slow                 |
        | ⭐ Sliding Window | O(n)  | O(1)  | Best for interviews answer     |
        ----------------------------------------------------------------------

 */
public class MinimumWindowSubstring76 {
    
    public static void main(String[] args) {
        /**
         * Input: s = "ADOBECODEBANC", t = "ABC", 
         * 
         * Output: "BANC"
         * 
         * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
         */

        /**
         * Input: s = "a", t = "a", 
         * Output: "a"
         * Explanation: The entire string s is the minimum window.
         */
        /**
         * Input: s = "a", t = "aa", Output: ""
         * Explanation: Both 'a's from t must be included in the window.
         * Since the largest window of s only has one 'a', return empty string.
         */

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String response = minWindowViaSlidingWindow(s, t);
        System.out.println("Min Window via sliding window : => " +response);

        System.out.println("Min Window via Brute force : => " +minWindowBruteForce(s, t));



    }

    /**
     * 🔥 Approach 2 — Sliding Window + Two Pointers (BEST APPROACH for Interview)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) / O(128) ≈ constant
     *     WHY This Works?
     *          We expand and shrink a window until it becomes “valid”—meaning it contains all characters of t.
     *      Steps:
     *          Build freq map of t
     *          Expand right pointer → include characters
     *          When window becomes valid → shrink left pointer
     *          Keep track of minimum window
     *          Continue until right pointer reaches end
     * This is the method interviewers expect.
     * ⭐ Cleanest Production-Ready Java Sliding Window Code (O(n))
     */

    public static String minWindowViaSlidingWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] freq = new int[128];   // ASCII
        for (char c : t.toCharArray()) freq[c]++;

        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);

            if (freq[rChar] > 0) {
                required--;
            }
            freq[rChar]--;
            right++;

            while (required == 0) { // Valid window
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);

                freq[lChar]++;
                if (freq[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    /**
     * Explanation:
     * All windows that contain A, B, C:
     *  ADOBEC       → valid (length 6)
        BECODEBA     → valid (length 8)
        BANC         → valid (length 4) ← minimum
     * 
     */
    /**
     * 📊 Sequence Diagram (Sliding Window)
     *  right -> expands window
     *  left  -> shrinks window
     *   
     *  ADOBECODEBANC
     *  ^     ^
     *  l     r   (valid window)
     *
     *  Flow:
     * 1. Expand r until window valid  
     * 2. Shrink l to minimize  
     * 3. Repeat  
     */
    /**
     * Expand right until valid:
     *  | Window   | required | Valid? | Action          |
        | -------- | -------- | ------ | --------------- |
        | "A"      | 2        | ❌      | expand          |
        | "AD"     | 2        | ❌      | expand          |
        | "ADO"    | 2        | ❌      | expand          |
        | "ADOB"   | 1        | ❌      | expand          |
        | "ADOBE"  | 1        | ❌      | expand          |
        | "ADOBEC" | 0        | ✔      | **shrink left**  |

        Shrink to find min:
            Window	Action
                "ADOBEC" → remove 'A'	becomes invalid → stop shrink
     * 
     */

    /**
     * 📌 Approach 1 — Brute Force (Very Slow, for understanding)
        Logic
            Check every substring s[i..j]
            For each substring check if it contains all characters of t
            Track minimum length
            Time Complexity
                Worst Case: O(n³)
                (Choose substring O(n²) × check frequency O(n))
                Space: O(1)
        
     */
    public static String minWindowBruteForce(String s, String t) {
        if (t.length() > s.length()) return "";

        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (containsAll(sub, t) && sub.length() < minLen) {
                    minLen = sub.length();
                    result = sub;
                }
            }
        }
        return result;
    }

    private static boolean containsAll(String sub, String t) {
        int[] freq = new int[128];
        for (char c : sub.toCharArray()) freq[c]++;

        for (char c : t.toCharArray()) {
            if (--freq[c] < 0) return false;
        }
        return true;
    }



}
