package com.akash.leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/description/
 * 🌟 CORE IDEA — How do we evaluate expressions?
        Since only +, -, and ( ) exist, the main challenge is:
            ✔ Handling parentheses by restoring previous calculation context
            ✔ Tracking current number and sign
            ✔ Using a stack to “freeze” state when encountering (
        This is a classic stack-based arithmetic evaluator.
    ✅ Problem Summary — Basic Calculator
            You must evaluate a mathematical expression string containing:
                Integers
                '+', '-'
                Parentheses '(', )'
                Spaces
            ✔ No * or /
            ✔ Expression is guaranteed valid
            ✔ Must return the computed integer
 * 🧠 Idea Behind The Question
        This problem tests:
                ✔ Expression evaluation
                ✔ Using stacks to save multi-level context
                ✔ Handling parentheses
                ✔ Tracking sign properly
                ✔ Clean & maintainable parsing logic

                It is a must-solve for interviews:
                    Parsing
                    Stacks
                    Arithmetic evaluation
                    Recursion
 */
public class BasicCalculator224 {
    
    public static void main(String[] args) {
        /*
        Input: s = "1 + 1"
        Output: 2

        Input: s = " 2-1 + 2 "
        Output: 3

        Input: s = "(1+(4+5+2)-3)+(6+8)"
        Output: 23
        */
       String str = "1 + 1";
       int output = calculate(str);
       System.out.println("Calculate :-  " + output);

    }

    /**
     * ⭐ BEST INTERVIEW APPROACH
     * ✅ Approach 1 — Stack-based Evaluation (Most Accepted Solution)
     * ✔ Steps / Logic Flow
            Let:
                result = current processed sum
                sign = +1 or -1
                num = number currently being built digit-by-digit
                stack = keeps state before parentheses
        Traverse each character c:
        1. Digit → build number
            num = num * 10 + (c - '0')
        2. ‘+’ or ‘-’ → apply previous number
            result += sign * num
            sign = +1 or -1
            num = 0
        3. ‘(’ → push current context
            stack.push(result)
            stack.push(sign)
            reset result = 0, sign = +1
        4. ‘)’ → close parentheses
            result += sign * num    // finish inside
            result *= stack.pop()   // multiply with sign before "("
            result += stack.pop()   // add previous result before "("
            num = 0
        5. Ignore spaces
            result += sign * num
        
        ⏳ Time & Space Complexity
        --------------------------------------------------------------------------------------
        | Case                                                      | Time | Space            |
        | --------------------------------------------------------- | ---- | ---------------- |
        | **Best Case** (No parentheses)                            | O(n) | O(1)             |
        | **Worst Case** (Deeply nested parentheses like (((()))) ) | O(n) | O(n) stack depth |
        | **Average**                                               | O(n) | O(n)             |
        ---------------------------------------------------------------------------------------

     */

    public static int calculate(String s) {
        int result = 0, num = 0, sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }

            else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }

            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }

            else if (c == ')') {
                result += sign * num;
                num = 0;

                result *= stack.pop();     /* previous sign */ 
                result += stack.pop();     /* previous result */ 
            }
        }

        return result + sign * num;
    }
    /**
     * 💡 Approach 2 — Using Two Stacks (Dijkstra Shunting Yard Simplified)
            Uses:
                number stack
                operator stack

            But since only + and - exist, we skip precedence rules.
        Complexity
            Same as approach 1
            ✔ O(n) time
            ✔ O(n) space

            
     */
    public static int calculateUsingTwoStacks(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int num = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            else if (c == '+' || c == '-') {
                nums.push(num);
                num = 0;

                while (!ops.isEmpty() && ops.peek() != '(') {
                    compute(nums, ops);
                }
                ops.push(c);
            }

            else if (c == '(') {
                ops.push(c);
            }

            else if (c == ')') {
                nums.push(num);
                num = 0;

                while (ops.peek() != '(')
                    compute(nums, ops);

                ops.pop(); // remove '('
            }
        }

        nums.push(num);
        while (!ops.isEmpty())
            compute(nums, ops);

        return nums.pop();
    }

    private static void compute(Stack<Integer> nums, Stack<Character> ops) {
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();

        if (op == '+') nums.push(a + b);
        else nums.push(a - b);
    }

    /**
     * 💡 Approach 3 — Recursive Parsing (DFS Evaluate)
     * Whenever encountering ( → recursively evaluate substring.
     * Complexity
     * -------------------------------------------------------
     *  | Case                | Time | Space                |
        | ------------------- | ---- | -------------------- |
        | Best                | O(n) | O(1)                 |
        | Worst (deep nested) | O(n) | O(n) recursion depth |
        --------------------------------------------------------
     */
    public static int calculateRecursiveUsingDFS(String s) {
        return helper(s.toCharArray(), new int[]{0});
    }

    private static int helper(char[] arr, int[] idx) {
        int num = 0, sum = 0, sign = 1;

        while (idx[0] < arr.length) {
            char c = arr[idx[0]];

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            else if (c == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            }

            else if (c == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            }

            else if (c == '(') {
                idx[0]++;
                num = helper(arr, idx);    // evaluate inside parentheses
            }

            else if (c == ')') {
                break;
            }

            idx[0]++;
        }

        return sum + sign * num;
    }

    /**
     * 💡 Approach 4 — Reverse Parsing (Elegant Trick)
            Parse from right to left and treat ( as ).
            Rare in interviews but clever.
        
     */
    public static int calculateReverseParsing(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0, sign = 1, result = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num + (c - '0') * (int)Math.pow(10, s.length() - 1 - i);
            }

            else if (c == '+' || c == '-') {
                result += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            }

            else if (c == ')') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }

            else if (c == '(') {
                result += sign * num;
                num = 0;

                result *= stack.pop();
                result += stack.pop();
            }
        }

        return result + sign * num;
    }

    /*
        📐 Sequence Diagram (Conceptual)
            scan → digit? → build number
            scan → '+'/'-'? → apply sign → reset number
            scan → '('? → push state → reset
            scan → ')'? → finalize nested → pop sign → pop result
            end → apply last number
            return result

    */

}
