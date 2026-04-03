package com.akash.leetcode;

/**
 * https://leetcode.com/problems/valid-perfect-square/
 */

/**
 * 🧠 Idea Behind the Question
 *    This question tests your understanding of:
 *       ✔ Mathematical reasoning
 *       ✔ Binary Search
 *       ✔ Newton’s Method (Fast)
 *       ✔ Handling overflow
 *       ✔ Avoiding Math.sqrt()
 */

public class validPerfectSquare367 {
    
    public static void main(String[] args) {

        /**
         * Input: num = 16  Output: true  
         * Explanation: 4 * 4 = 16
         */
        int input = 16;
        boolean isValid = isPerfectSquare(input);
        System.out.println("Binary Search  " + isValid);

        System.out.println("Newton’s Method  "+ isPerfectSquareNewtonMethod(input));

        System.out.println("Brute Force "+ isPerfectSquareBruteForce(input));

        System.out.println(" Using Odd Number "+ isPerfectSquareUsingOddNumber(input));
    }

    /*
    * ✅ 🥇 Best Interview Approach
        ✔ Binary Search
        Why?
        1. Cannot use sqrt() directly
        2. Multiplication might overflow
        3. Fast: O(log n)
    *
        mid * mid == num → perfect square  
        mid * mid < num → search right  
        mid * mid > num → search left

        ⏳ Time & Space Complexity

        Best Case
        mid * mid == num on first check
        ➡ O(1)

        Worst Case
        Binary search over range [1…num]
        ➡ O(log n) time
        ➡ O(1) space


    */

    public static boolean isPerfectSquare(int num) {
        if (num < 1) return false;

        long left = 1, right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;

            if (sq == num) return true;
            else if (sq < num) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }

    /**
     * ✅ 🧮 APPROACH 2 — Newton’s Method (Fastest)
     * Faster than Binary Search (O(log n) time)
     * 
     * Complexity
     *  | Case  | Time     | Space |
     *  | ----- | -------- | ----- |
     *  | Best  | O(1)     | O(1)  |
     *  | Worst | O(log n) | O(1)  |
     * 
     *  Logic - 
     *   x = (x + num/x) / 2
     *   Repeat until x*x <= num
     *
     */

    public static boolean isPerfectSquareNewtonMethod(int num) {
        if (num < 1) return false;

        long x = num;

        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    /**
     * ✅ 🧮 APPROACH 3 — Brute Force (Not recommended)
     *  | Case  | Time            | Space |
        | ----- | --------------- | ----- |
        | Best  | O(1) (if num=1) | O(1)  |
        | Worst | O(√n)           | O(1)  |
     */
    public static boolean isPerfectSquareBruteForce(int num) {
        for (long i = 1; i * i <= num; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    /**
     * ✅ 🔢 APPROACH 4 — Using Odd Number Sum Property
     *  | Case  | Time  | Space |
        | ----- | ----- | ----- |
        | Best  | O(1)  | O(1)  |
        | Worst | O(√n) | O(1)  |
     * 
        Logic

        1. Keep subtracting odd numbers from num
        2. If it becomes zero → perfect square
     */

    public static boolean isPerfectSquareUsingOddNumber(int num) {
        int odd = 1;
        while (num > 0) {
            num -= odd;
            odd += 2;
        }
        return num == 0;
    }


    /**
     * 
     * 🧠 How to Think Step-by-Step (Interview Process)
        Step 1 — Understand Input Range

            1 <= num <= 2^31 - 1
            Square root fits in int range.
        Step 2 — Avoid Math.sqrt
            Because floating rounding error.
        Step 3 — Choose Binary Search
            Safe from overflow
            Efficient
        Step 4 — Think Newton’s Method
            Even faster
            But more math-heavy
        Step 5 — Write clean code
        Use long to avoid overflow
     * 
     */

    
}
