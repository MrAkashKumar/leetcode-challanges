package com.akash.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
    https://leetcode.com/problems/random-pick-with-weight
    ✔ Best Interview Approach — Prefix Sum + Binary Search
        This is the most optimal and the expected solution in interviews.

🧠 Key Idea Behind the Question (Very Important)
    This is a classic Prefix Sum + Binary Search problem.
    Transform weight array into cumulative sums:
        w = [1,3,2], prefix = [1,4,6]
        Total weight = 6
    Generate random number in range [1,6].
        If random = 2 → index 1
        If random = 5 → index 2
        If random = 1 → index 0
We find this using binary search on prefix array.

    🧩 Comparison of Approaches
        ------------------------------------------------------------------------------------
        | Approach               | Constructor | pickIndex | Space    | Notes             |
        | ---------------------- | ----------- | --------- | -------- | ----------------- |
        | Prefix + Binary Search | O(n)        | O(log n)  | O(n)     | **BEST**          |
        | TreeMap                | O(n log n)  | O(log n)  | O(n)     | Clean alternative |
        | Brute Force            | O(sum w)    | O(1)      | O(sum w) | BAD               |
        -------------------------------------------------------------------------------------
*/
public class RandomPickWithWeight528 {

    /* --- MAIN METHOD START --- */ 
    public static void main(String[] args) {
        /**
         * Input: ["Solution","pickIndex"]
         *        [[[1]],[]]
            Output:  [null,0]
            Explanation:
                Solution solution = new Solution([1]);
                solution.pickIndex(); 
                // return 0. The only option is to return 0 since there is only one element in w.
         * 
         */
        /* 1. Define weights: Index 0 has weight 1, Index 1 has weight 3
         This means Index 1 should appear roughly 75% of the time. */
        int[] weights = {2,5, 3};

        Solution sol = new Solution(weights);

        // 2. Map to track how many times each index is picked
        Map<Integer, Integer> countMap = new HashMap<>();
        int totalPicks = 10000;

        System.out.println("Picking indices " + totalPicks + " times...");

        for (int i = 0; i < totalPicks; i++) {
            int index = sol.pickIndex();
            countMap.put(index, countMap.getOrDefault(index, 0) + 1);
        }

        // 3. Print the results and percentages
        for (int index : countMap.keySet()) {
            double percentage = (double) countMap.get(index) / totalPicks * 100;
            System.out.println("Index " + index + ": picked " + countMap.get(index) + 
                               " times (" + String.format("%.2f", percentage) + "%)");
        }
        
    }

    /**
     * ✔ Best Interview Approach — Prefix Sum + Binary Search
     * This is the most optimal and the expected solution in interviews.
     * 🟩 APPROACH 1 — Prefix Sum + Binary Search (BEST)
            ✔ Time Complexity
            Constructor: O(n)
            pickIndex(): O(log n)
            Space: O(n)

     * 🧪 Example
     *  w = [2,5,3]
        Prefix sum:
        [2, 7, 10]
        Total = 10

        random = 1..2 → index 0 (20%)
        random = 3..7 → index 1 (50%)
        random = 8..10 → index 2 (30%)
     * 
     */

    public static class Solution {
        int[] prefix;
        int total;

        public Solution(int[] w) {
            prefix = new int[w.length];

            prefix[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                prefix[i] = prefix[i - 1] + w[i];
            }

            total = prefix[prefix.length - 1];
        }

        public int pickIndex() {
            int target = 1 + (int)(Math.random() * total);  // random 1..total

            int left = 0, right = prefix.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (target > prefix[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }


    
    /**
     * 🧵 Step-by-step Trace
     * 
     * Input:
     *      w = [1, 4, 2]
            prefix = [1, 5, 7]
            total = 7
        
        Suppose random = 6
        Binary search:
            left = 0, right = 2
            mid = 1 → prefix[1]=5 < 6 → left = 2
            mid = 2 → prefix[2]=7 >= 6 → right = 2
            Return 2
     * 
     */

    /**
     * 
     * 🟩 APPROACH 3 — Using TreeMap (Alternative)
     * Stores prefix weights and uses ceilingEntry().
     *  Complexity
     *      ✔ Time: O(log n)
     *      ✔ Space: O(n)
     */
    class TreeMapSolution {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int total = 0;

        public TreeMapSolution(int[] w) {
            for (int i = 0; i < w.length; i++) {
                total += w[i];
                map.put(total, i);
            }
        }

        public int pickIndex() {
            int r = 1 + (int)(Math.random() * total);
            return map.ceilingEntry(r).getValue();
        }
    }

    /**
     * 🧩 Comparison of Approaches
     *  -----------------------------------------------------------------------------------
     *  | Approach               | Constructor | pickIndex | Space    | Notes             |
        | ---------------------- | ----------- | --------- | -------- | ----------------- |
        | Prefix + Binary Search | O(n)        | O(log n)  | O(n)     | **BEST**          |
        | TreeMap                | O(n log n)  | O(log n)  | O(n)     | Clean alternative |
        | Brute Force            | O(sum w)    | O(1)      | O(sum w) | BAD               |
        -----------------------------------------------------------------------------------
     */

    /**
     * 🧠 How Should You Explain in an Interview?
        1. Convert weights to prefix sum
        2. Choose a random number in that total range
        3. Use binary search to find corresponding index
            Works because prefix array defines continuous numeric intervals.
     */

    
    
}
