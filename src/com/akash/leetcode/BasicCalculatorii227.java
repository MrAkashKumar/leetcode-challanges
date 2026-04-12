package com.akash.leetcode;

import java.util.Stack;

/**
 * Problem ===>   https://leetcode.com/problems/basic-calculator-ii/description/
 * 🧠 Core Idea
    This is a single-pass expression evaluation problem with precedence.
    Key Trick:
        👉 Handle * and / immediately
        👉 Delay + and - using stack
 */
/*
    ✅ 1. Problem Summary
    You are given a string expression containing:
    Integers
        Operators: +, -, *, /
        Spaces
    👉 No parentheses
    👉 Must follow operator precedence (*, / before +, -)
    
    📊 Summary of Approaches
    ---------------------------------------------
    | Approach  | Time | Space | Interview       |
    | --------- | ---- | ----- | ----------      |
    | Stack     | O(n) | O(n)  | ⭐ BEST         |
    | Optimized | O(n) | O(1)  | ⭐⭐ BEST       |
    | Two-stack | O(n) | O(n)  | Good            |
    | Brute     | ❌    | ❌    | Not usable     |
    ----------------------------------------------

    🧠 Idea Behind Question
        This tests:
        ✔ Operator precedence handling
        ✔ Expression parsing
        ✔ Stack usage
        ✔ Single-pass optimization
        ✔ Real-world calculator logic
    👉 This is foundation for compilers / interpreters
*/

public class BasicCalculatorii227 {

    public static void main(String[] args) {
        /**
         * Input:  "3+2*2",
         * Output: 7
         * 
         * Input:  " 3+5 / 2 ",
         * Output: 5
         */

        String str = "3+2*2";
        int response = calculate(str);

        System.out.println(response);

        
    }

    /**
     * 🚀 BEST INTERVIEW APPROACH
        ✅ Approach 1 — Stack-Based (Single Pass) ⭐

        ✔ Logic Steps
            Maintain:
                num → current number
                sign → previous operator
                stack → store numbers
            Traverse string:
                If digit → build number
                If operator or end:
                    If + → push num
                    If - → push -num
                    If * → pop → multiply → push
                    If / → pop → divide → push
                Update sign
                Reset num
            Final result = sum of stack
        ⏱ Time & Space Complexity
        --------------------------------------
        | Case       | Time | Space          |
        | ---------- | ---- | -------------- |
        | Best Case  | O(n) | O(1) (few ops) |
        | Worst Case | O(n) | O(n) stack     |
        | Average    | O(n) | O(n)           |
        --------------------------------------

        🧪 Step-by-Step Example Trace
        Expression:
            "3+2*2"
        -------------------------------
        | Step | Action       | Stack |
        | ---- | ------------ | ----- |
        | 3    | push         | [3]   |
        | +    | sign update  |       |
        | 2    | push         | [3,2] |
        | *    | compute next |       |
        | 2    | 2*2=4        | [3,4] |
        | End  | sum          | 7     |
        -------------------------------

        📌 Sequence Flow (Conceptual)
        Scan char →
            digit → build number
            operator →
                apply previous operator
                push/update stack
        End →
            sum stack → result
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack) result += val;

        return result;
    }

    /*
    💡 Approach 2 — Optimized (No Stack, O(1) Space) ⭐
    ✔ Idea
    Keep:
        result
        lastNumber (for handling * /)
    Complexity 
        ------------------------
        | Case  | Time | Space |
        | ----- | ---- | ----- |
        | Best  | O(n) | O(1)  |
        | Worst | O(n) | O(1)  |
        ------------------------
    */

    public static int calculateWithoutStack(String s) {
        int num = 0, last = 0, result = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {

                if (sign == '+') {
                    result += last;
                    last = num;
                } else if (sign == '-') {
                    result += last;
                    last = -num;
                } else if (sign == '*') {
                    last = last * num;
                } else if (sign == '/') {
                    last = last / num;
                }

                sign = c;
                num = 0;
            }
        }

        return result + last;
    }

    /**
     * 💡 Approach 3 — Two Stack (Operator + Operand)
     * ✔ Idea
        Stack1 → numbers
        Stack2 → operators
        Apply precedence manually

        ⏱ Complexity
        ------------------------
        | Case  | Time | Space |
        | ----- | ---- | ----- |
        | Best  | O(n) | O(n)  |
        | Worst | O(n) | O(n)  |
        ------------------------

     */

    public int calculateUsingStack(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                nums.push(num);
                num = 0;

                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    compute(nums, ops);
                }

                if (c != ' ') ops.push(c);
            }
        }

        while (!ops.isEmpty()) compute(nums, ops);

        return nums.pop();
    }

    private int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private void compute(Stack<Integer> nums, Stack<Character> ops) {
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();

        if (op == '+') nums.push(a + b);
        else if (op == '-') nums.push(a - b);
        else if (op == '*') nums.push(a * b);
        else nums.push(a / b);
    }

    /**
     * ❌ Invalid / Not Suitable Approaches
     *  | Approach       | Why Not                    |
        | -------------- | -------------------------- |
        | Sliding Window | No contiguous constraint   |
        | Two Pointer    | Not sorted / bidirectional |
        | Greedy         | Needs full parsing         |
        | Brute Force    | Exponential parsing        |
        -----------------------------------------------

        🎯 Interview Recommendation
            👉 Start with:
                Explain precedence
                Use stack solution
                Then optimize to O(1) space
     * 
     */

    
}