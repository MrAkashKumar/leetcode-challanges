package com.akash.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 🧠 Idea Behind This Problem
        The array has n numbers ranging from 0 to n → exactly n+1 distinct values but only n are present → one missing.
        Key ideas:
            Formula for sum of 0 to n = n*(n+1)/2
            Bit manipulation eliminates overflow concerns
            HashSet is straightforward but not optimal
            Sorting helps but wastes time

            The best interview approaches are:
                ✔ Math formula (sum)
                ✔ XOR bit manipulation
                ✔ (optional) Sorting
                ✔ (optional) HashSet
    
    🧩 MULTIPLE APPROACHES
    | Approach                | Time           | Space    | Interview Value            |
    | ----------------------- | -------------- | -------- | -------------------------- |
    | Sum formula             | **O(n)**       | **O(1)** | ⭐ Best                     |
    | XOR method              | **O(n)**       | **O(1)** | ⭐ Best                     |
    | Sorting                 | **O(n log n)** | **O(1)** | Sometimes OK               |
    | HashSet / Boolean array | **O(n)**       | **O(n)** | Acceptable but not optimal |

 */
public class MissingNumber268 {
    
    public static void main(String[] args) {
        /**
         *  Input: nums = [3, 0, 1]
            Output: 2
            Explanation: n = 3 → full set = {0,1,2,3} → missing = 2

            Input: nums = [0, 1]
            Output: 2
            Explanation: n = 2 → full set = {0,1,2}
         */
        int[] nums = {3, 0, 1};
        int response =  missingNumber(nums);
        System.out.println(response);
        
    }

    /*
    🥇 APPROACH 1 — Math Formula (Best Interview Approach)
    ✔ Logic
        Total sum of range [0..n] = n * (n + 1) / 2
        Missing number = total sum − sum(nums)
        ⏱ Time Complexity
            O(n) → one pass over the array
        🧠 Space Complexity
            O(1) → constant space
        🧮 Example Trace
            nums = [3, 0, 1]
            n = 3
            totalSum = 3*(3+1)/2 = 6
            arraySum = 3 + 0 + 1 = 4
            missing = 6 - 4 = 2
        
    */
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n + 1) / 2;
        int arraySum = 0;

        for (int num : nums) {
            arraySum += num;
        }

        return totalSum - arraySum;
    }

    /**
     * ⚠ Edge Cases
     *  | Case                    | Expected    |
        | ----------------------- | ----------- |
        | nums = [1]              | missing = 0 |
        | nums = [0]              | missing = 1 |
        | nums sorted or unsorted | Works       |
        | n small                 | Works       |
     */

    /*
    🥈 APPROACH 2 — XOR Method (Very Elegant)
    🔹 Logic
        Using XOR reduces numbers from both sets:
    ⏱ Complexities
        | Case  | Time | Space |
        | ----- | ---- | ----- |
        | Best  | O(n) | O(1)  |
        | Worst | O(n) | O(1)  |
    
    Example Trace
        nums = [3, 0, 1]
        n = 3

        missing = 3
        missing ^= 0 ^ 3 → missing = 0
        missing ^= 1 ^ 0 → missing = 1
        missing ^= 2 ^ 1 → missing = 2
    */
    public int missingNumberViXOR(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * 📉 APPROACH 3 — Sorting (Simpler but slower)
     *  | Time       | Space        |
        | ---------- | ------------ |
        | O(n log n) | O(1) or O(n) |


     */
    public int missingNumberSorting(int[] nums) {
        Arrays.sort(nums);
        int expected = 0;

        for (int num : nums) {
            if (num != expected) return expected;
            expected++;
        }
        return expected;
    }

    /**
     * 📌 APPROACH 4 — HashSet (Easy to Write, Extra Space)
     * Complexity -
     *  | Time | Space |
        | ---- | ----- |
        | O(n) | O(n)  |

     */
    public int missingNumberViaHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }

    /**
     * 🧠 How to Pick the Best Approach
     *  | Criteria                | Best         |
        | ----------------------- | ------------ |
        | Small code              | Math formula |
        | No extra memory         | Math / XOR   |
        | Avoid overflow concerns | XOR          |
        | Easy to explain         | Math formula |

     */

    /*
    🧪 Input / Output Example
    Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    Output: 8

    Explanation:
    n = 9
    totalSum = 9*10/2 = 45
    arraySum = 36
    missing = 9

    */

    /*
    ⚠ Edge Cases to Think About

    | Scenario                                 | Output           |
    | ---------------------------------------- | ---------------- |
    | All numbers from 0 to n−1                | Missing = n      |
    | Only 1 element                           | Missing = 0 or 1 |
    | Unsorted                                 | Works            |
    | Duplicates (invalid problem constraints) | Not expected     |
    */

    


}
