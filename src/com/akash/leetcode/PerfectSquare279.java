package com.akash.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/perfect-squares
 */
/**
 * 🧠 Key Idea Behind the Problem
    This is a minimum partition optimization problem.
    You want to express n as the sum of perfect squares such that the number of terms used is minimized.
    | Approach             | Time Complexity | Space | Comments                           |
| -------------------- | --------------- | ----- | ---------------------------------- |
| Brute Force          | O(???)          | High  | Very expensive — not viable        |
| DP (Bottom Up)       | O(n√n)          | O(n)  | Best for interviews                |
| BFS (Graph)          | ~O(n)           | O(n)  | Finds shortest path                |
| Math Formula         | O(√n)           | O(1)  | Elegant but theory dependent       |
| Two-pointer / Greedy | ✘               | ✘     | Not correct for this exact problem |

 */
public class PerfectSquare279 {

    public static void main(String[] args) {
        /**
         *  Input: n = 12, Output: 3
         *  Explanation: 12 = 4 + 4 + 4
         *
         *  Input: n = 13, Output: 2
         *  Explanation: 13 = 4 + 9
         */
        int input = 12;
        
        /** Via Dyanamic program 
         *  dp[i] = minimum number of perfect squares that sum to i
         *  We build up from 0 to n.
         *  For each square j² ≤ i:
         * dp[i] = min(dp[i], dp[i - j*j] + 1)
         * 
        */
       int perfectSquareNumber =  numSquares(input);
       System.out.println(" Min squares for " + input + " =  " + perfectSquareNumber);


    }

    /*
        ✅ Via DP Ways --  Best for Interview answers --
        Time: O(n * sqrt(n)) = O(n√n)
        Space: O(n)
    */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 squares to make 0

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }

    /** 
     *   DP trace
     * 
     *   dp[1] = 1
         dp[2] = 2 (1+1)
         dp[3] = 3 (1+1+1)
         dp[4] = 1 (2^2)
         ...
         dp[13] = dp[13-9] + 1 = dp[4] + 1 = 1 + 1 = 2
     * 
     */

    /**
     * ✅ BFS (Shortest Path Interpretation)
     * Treat the number as a node in a tree — subtract all possible squares and find shortest distance to 0.
     * Time: ~O(n), Space: O(n)
     */
    
    public static int numSquaresBFS(int n) {
        
        if (n < 2) return n;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        int level = 0;

        while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                while (size-- > 0) {
                int curr = queue.poll();
                for (int i = 1; i * i <= curr; i++) {
                    int next = curr - i * i;
                    if (next == 0) return level;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return level;
    }
    /**
     * ✅ 3) Mathematical (Fastest)
     * Rules:
        If n is a perfect square → answer = 1
        If n fits the form 4^k(8m + 7) → answer = 4
        If it can be expressed as sum of 2 perfect squares → answer = 2
        Else → answer = 3

        Time: O(√n)
        Space: O(1)
     */

    public static int numSquaresMath(int n) {
            if (isSquare(n)) return 1;

        /* Reduce n by 4^k */ 
            while (n % 4 == 0) n /= 4;

            if (n % 8 == 7) return 4;

        /* Check if sum of 2 squares */ 
            for (int i = 1; i * i <= n; i++)
                if (isSquare(n - i*i)) return 2;

        return 3;
    }
    
    private static boolean isSquare(int x) {
        int r = (int)(Math.sqrt(x));
        
        return r*r == x;
    }

    
    /**
    * 
    * 📌 Step/Approach Summary (Interview)
            Check trivial cases
                n == 0 or n ⥼ perfect square
            Use DP bottom-up
                For each number, build best possible solution using smaller dp states
            Explain complexity
            Explain BFS alternate
            Mention math theorem optimization
    * 
    */    


            /**
             *    +----------------+
Input n           |  Solution      |
------>          +----------------+
                 |  check perfect |
                 |     square?    |
                 +--------+-------+
                          |
         +----------------v-----------------+
         |   Use DP / BFS / Math approach   |
         +----------------+------------------+
                          |
          +---------------v--------------+
          |  Compute min squares & return |
          +------------------------------+
Output <<-----------------+
             * 
             */

/**
 * 
 * ❓ Why Not Two-pointer or Sliding Window?
 *  Those techniques require:
 *   monotonic sequences
 *   continuous ranges
 *  Perfect squares selection doesn’t fit linear patterns — it's a sum decomposition problem — so they aren’t applicable here.
 */

    
}
