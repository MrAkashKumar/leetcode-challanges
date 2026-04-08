package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/
*/
/*
🧠 Idea Behind This Question (Interview Goal)
The interviewer tests if you understand:

HashMap for counting frequency
Efficient top-K extraction
Heap vs Bucket sort
Optimization from O(n log n) → O(n)
Real-world concept: “frequency counting”, used in logs, analytics, ML
This is a top 5 HashMap + Heap interview problem.
*/
/**
 * 🧩 Approach Comparison Table
 *  | Approach         | Time       | Space | Notes                |
    | ---------------- | ---------- | ----- | -------------------- |
    | Brute Force Sort | O(n log n) | O(n)  | easy but slow        |
    | Heap (PQ)        | O(n log k) | O(n)  | common in interviews |
    | ⭐ Bucket Sort    | O(n)       | O(n)  | **BEST**             |

 */
public class TopKFrequentElements347 {
    
    public static void main(String[] args) {
        /**
         * Input:  nums = [1,1,1,2,2,3], k = 2  
         * Output: [1,2]
         */
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        int[] response = topKFrequentHeap(nums, k);
        System.out.println(response);

    }

    /**
     * 🔥 APPROACH 2 — Heap / Priority Queue (Most common interview solution)
     * ✔ Logic
            Build frequency map
            Use a min-heap of size K
            Push elements into heap by frequency
            If heap grows beyond K → remove smallest
            Remaining heap contains K most frequent elements
        ✔ Time Complexity
            Building frequency map → O(n)
            Push into heap → O(n log k)
            Extract → O(k log k)
            Worst Case: O(n log k)
            Best Case: O(n) (k = 1)
            Space: O(n)

     */
    public static int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] result = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll().getKey();
        }
        return result;
    }


    /*
    🔴 APPROACH 1 — Brute Force Sorting Based on Frequency (For understanding only)
        ✔ Logic
            Count frequency using HashMap
            Turn into list of pairs
            Sort list by frequency (descending)
            Take first k elements

        ✔ Time Complexity
                Building map → O(n)
                Sorting frequencies → O(n log n)
        Worst case: O(n log n)
        Best case: O(n) (if already sorted but still must count freq)
        Space Complexity: O(n)
    */
   public static int[] topKFrequentBrute(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    /*
    💥 APPROACH 3 — Bucket Sort (BEST + FASTEST)

        👉 This runs in O(n) and is the most optimal solution.
        👉 Interviewers love this.

        ✔ Logic
            Build frequency map
            Create buckets: array of lists where
            bucket[f] = list of numbers appearing f times
            Iterate buckets from high freq → low freq
            Collect first K elements
        ✔ Time Complexity
            Worst Case: O(n)
            Best Case: O(n)
            (100% linear)
            Space: O(n)
        ⭐ Final Production-Ready Java Code (Bucket Sort — O(n))
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);

        /* Bucket array: index = frequency */ 
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (bucket[count] == null) bucket[count] = new ArrayList<>();
            bucket[count].add(key);
        }

        int[] result = new int[k];
        int idx = 0;

        /* Traverse buckets from highest freq → lowest */ 
        for (int i = nums.length; i >= 1 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                    result[idx++] = val;
                    if (idx == k) break;
                }
            }
        }
        return result;
    }

    /**
     * 📊 Sequence Diagram (Bucket Sort Logic)
     *  nums → count freq → create bucket → pick from largest bucket
     * 
     *          ┌──────────────┐
        nums →  │ freq map     │
                └─────┬────────┘
                      ↓
                ┌──────────────┐
                │ bucket array │ ← index = frequency
                └─────┬────────┘
                      ↓
                Pick highest frequency buckets
     * 
     */
    /**
     * 📝 Step-by-Step Trace (Bucket Sort Example)
     * Input:
     *  nums = [1,1,1,2,2,3], k = 2
     * 
     * Step 1: Frequency Map
     *  1 → 3
        2 → 2
        3 → 1
     * 
     *  Step 2: Create Buckets
     *   
     *  Bucket index = frequency:
     *      bucket[1] = [3]
            bucket[2] = [2]
            bucket[3] = [1] 

        Step 3: Traverse buckets backwards
        i = 6..3 →    bucket[3] = [1] → add 1
        i = 2 →       bucket[2] = [2] → add 2

        Result = [1,2]

     */

    /**
     * ⚠ Edge Cases
     *  | Case             | Output                           |
        | ---------------- | -------------------------------- |
        | nums empty       | return []                        |
        | k = 0            | return []                        |
        | k > unique nums  | return all unique                |
        | all numbers same | return same number repeated once |
        | negative numbers | works fine                       |
        | very large input | bucket sort best                 |

     * 
     */

    


}
