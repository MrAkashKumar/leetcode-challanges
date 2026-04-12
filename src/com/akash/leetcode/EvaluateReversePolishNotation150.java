package com.akash.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
Problem - https://leetcode.com/problems/evaluate-reverse-polish-notation/
This is a must-know stack problem used in interviews to test:
    Stack fundamentals
    Expression evaluation
    Operator precedence handling
    Understanding of Reverse Polish Notation (RPN)
Operators:
    +   -   *   /
*/
/**
 * 🧠 Core Idea Behind RPN
    No parentheses needed.
    Order is naturally defined:
        When you see a number → push it
        When you see an operator → pop two numbers
        Apply operation
        Push result back
    Final stack top = answer.
    This is why RPN is used in computer compilers & calculators.
 * 
 */

public class EvaluateReversePolishNotation150 {
    
    public static void main(String[] args) {
        /**
         * input - ["2","1","+","3","*"]
         * Output - 9
         */
        /**
         * Input: ["4","13","5","/","+"]
            Output: 6
         */
        /**
         * Input: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
         * Output: 22
         */
        String input[] = {"2","1","+","3","*"};
        int output = evalRPN(input);
        System.out.println(output);
        

    }
    /**
     * 🌟 BEST Interview Approach
     * ✅ Approach 1 — Stack Evaluation (Most Standard & Accepted)
     * ✔ Steps / Logic
            Create a stack
            Traverse each token 
            If number → push
            If operator → pop b, then pop a
            Compute a (op) b
            Push result back
            End: top of stack = result
        ✔ Example
            input - ["2","1","+","3","*"]
        Evaluation:
            2 → push
            1 → push
            + → pop 1, pop 2 -> 2+1=3 → push 3
            3 → push
            * → pop 3, pop 3 -> 3*3=9 → push 9
        Output
            9
        
        ⏳ Time & Space Complexity
        ------------------------------------------
        | Operation                 | Complexity |
        | ------------------------- | ---------- |
        | Each token processed once | O(n)       |
        | Stack used for values     | O(n)       |
        ------------------------------------------

        Best Case
            Expression has no operators → only pushes
            Time: O(n), Space: O(n)
        Worst Case
            Every alternate token is operator
            Stack operations still O(1)
            Time: O(n), Space: O(n)

     */

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            // Case: Number
            if (!"+-*/".contains(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }

            // Case: Operator
            int b = stack.pop();
            int a = stack.pop();
            int result = 0;

            switch (token) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> result = a / b; // truncates toward 0 automatically
            }

            stack.push(result);
        }

        return stack.pop();
    }

    /**
     * 🔥 Approach 2 — Using Array as Stack (Faster, No Stack Object)
        This avoids Stack<Integer> overhead.
        Complexity
            Same as approach 1
            But faster (no object overhead, primitive array)
        ⏳ Time & Space Complexity
        ------------------------------------------
        | Operation                 | Complexity |
        | ------------------------- | ---------- |
        | Each token processed once | O(n)       |
        | Stack used for values     | O(n)       |
        ------------------------------------------
     */
    public int evalRPNViaStack(String[] tokens) {
        int[] st = new int[tokens.length];
        int top = -1;

        for (String t : tokens) {

            if (!"+-*/".contains(t)) {
                st[++top] = Integer.parseInt(t);
            } else {
                int b = st[top--];
                int a = st[top--];

                switch (t) {
                    case "+" -> st[++top] = a + b;
                    case "-" -> st[++top] = a - b;
                    case "*" -> st[++top] = a * b;
                    case "/" -> st[++top] = a / b;
                }
            }
        }
        return st[top];
    }

    /**
     * 🧩 Approach 3 — Recursion (Reverse Process)
        We evaluate tokens backwards using recursion.
        Key Logic
            Move from right to left
            First see an operator → evaluate two recursive calls
        Complexity
            Worst-case recursion depth = number of tokens.
            Time: O(n)
            Space: O(n) recursion stack
        
     */
    static class Solution {
        static int idx;

        public static int evalRPN(String[] tokens) {
            idx = tokens.length - 1;
            return helper(tokens);
        }

        private static int helper(String[] t) {
            String cur = t[idx--];

            if (!"+-*/".contains(cur)) {
                return Integer.parseInt(cur);
            }

            int b = helper(t);
            int a = helper(t);

            return switch (cur) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                default  -> a / b;
            };
        }
    }

    /**
     * ⚡ Approach 4 — Using Deque instead of Stack (Modern Java)
     * Deque is superior to Stack (because Stack is synchronized, legacy).
     * 
     */
    public int evalRPNUsingDeque(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String t : tokens) {
            if ("+-*/".contains(t)) {
                int b = st.pop();
                int a = st.pop();

                switch (t) {
                    case "+" -> st.push(a + b);
                    case "-" -> st.push(a - b);
                    case "*" -> st.push(a * b);
                    case "/" -> st.push(a / b);
                }
            } else {
                st.push(Integer.parseInt(t));
            }
        }
        return st.pop();
    }

    /**
     * 📌 Step-by-Step Trace (Example 2)
        Tokens:
            ["4","13","5","/","+"]
        -------------------------------------
        | Token | Action         | Stack    |
        | ----- | -------------- | -------- |
        | 4     | push           | [4]      |
        | 13    | push           | [4,13]   |
        | 5     | push           | [4,13,5] |
        | /     | pop → 13/5 = 2 | [4,2]    |
        | +     | pop → 4+2 = 6  | [6]      |
        -------------------------------------

        🎯 Sequence of Operations (Conceptual)
        scan token ->
            number? push
            operator?
                pop b
                pop a
                compute a op b
                push result
        end -> pop answer
     */

    /**
     * ⚠️ Edge Cases to Consider
     *  -------------------------------------------------------------------
     *  | Case                       | Explanation                        |
        | -------------------------- | ---------------------------------- |
        | Negative numbers           | Token like "-3"                    |
        | Large numbers              | Up to 32-bit int                   |
        | Division truncation        | Must follow truncation toward zero |
        | Only one token             | Should return that number          |
        | Many operators in sequence | Always pop 2                       |
        --------------------------------------------------------------------

        🧠 Why interviewers ask this?
                Tests:
                    Understanding of expression evaluation
                    Comfort with stacks
                    Applying order of operations without parentheses
                    Ability to write clean and bug-free parsing logic
                    Checking division & integer behavior
                    Core skill in compilers + interpreters + runtime evaluation.
        
        🏆 Final Recommendation
            Use Approach 1 (Stack) → Most intuitive, clean, and interview-friendly.
            Approach 2 (Array-Stack) → Fastest
            Approach 3 (Recursion) → Elegant, but not as good for interviews
            Approach 4 (Deque) → Modern recommendation
     */



}
