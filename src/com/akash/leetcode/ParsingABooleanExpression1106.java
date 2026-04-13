package com.akash.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/parsing-a-boolean-expression/description/
 * 
 * ✅ 1. Problem Summary (Simple)

        You are given a Boolean expression:

            Operators:
                '!' → NOT
                '&' → AND
                '|' → OR
            Operands:
                't' → true
                'f' → false
        Parentheses: (...)
        Commas separate arguments.
        You must evaluate the Boolean expression and return true/false.

        🚀 Core Approaches
        ------------------------------------------------------------------------------------------------------------------------------------------
        | Approach                                     | Description                                                   | Time          | Space |
        | -------------------------------------------- | ------------------------------------------------------------- | ------------- | ----- |
        | **1. Stack-based (Best Interview Approach)** | Parse like expression evaluator using operator/operand stacks | O(n)          | O(n)  |
        | **2. Recursion + DFS**                       | Evaluate expression by recursively evaluating subexpressions  | O(n)          | O(n)  |
        | **3. Two-Pass Parsing + Reduce**             | Convert tokens then reduce                                    | O(n)          | O(n)  |
        | **4. Brute Force (Invalid)**                 | Try evaluating all possibilities                              | ❌ exponential | ❌    |
        ------------------------------------------------------------------------------------------------------------------------------------------


 * 
 */
public class ParsingABooleanExpression1106 {
    
    public static void main(String[] args) {

       /**
        * Input: expression = "|(f,f,f,t)"
        * Output: true
        * Explanation: The evaluation of (false OR false OR false OR true) is true.
        */
       /**
        * Input: expression = "!(&(f,t))"
        * Output: true
        * Explanation: First, evaluate &(f,t) --> (false AND true) --> false --> f. The expression is now "!(f)".
        * Then, evaluate !(f) --> NOT false --> true. We return true.
        */
       /**
        *   Input: expression = "&(|(f))"
            Output: false
            Explanation: 
            First, evaluate |(f) --> f. The expression is now "&(f)".
            Then, evaluate &(f) --> f. The expression is now "f".
            Finally, return false.
       */

        String input = "|(&(t,f,t),!(f))";
        boolean response = parseBoolExprViaStack(input);
        System.out.println(response);

        
    }

    /**
     * ✅ APPROACH 1 — STACK-BASED (BEST Interview APPROACH)
     * 
     * ✔ Logic Steps
            Use a stack of characters.
            For every char:
            If it is ')' → pop until '(', evaluate subexpression.
            Else push to stack (except commas).
            Replace evaluated subexpr with result 't' or 'f'.
            Final result is top of stack.
        
        📊 Time & Space Complexity (Stack Approach)
        -----------------------------------------------------
        | Case                               | Time | Space |
        | ---------------------------------- | ---- | ----- |
        | **Best Case** (Shallow expression) | O(n) | O(n)  |
        | **Worst Case** (Deep nested)       | O(n) | O(n)  |
        -----------------------------------------------------


     * 
     */

    public static boolean parseBoolExprViaStack(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',') continue;

            if (ch != ')') {
                stack.push(ch);
                continue;
            }
            /** Now ) encountered → evaluate subexpression */ 
            int tCount = 0, fCount = 0;

            while (!stack.isEmpty() && stack.peek() != '(') {
                char val = stack.pop();
                if (val == 't') tCount++;
                else if (val == 'f') fCount++;
            }

            stack.pop(); // remove '('
            char op = stack.pop(); // operator: ! & |

            char result;
            if (op == '!') {
                result = (fCount == 1) ? 't' : 'f';
            } else if (op == '&') {
                result = (fCount > 0) ? 'f' : 't';
            } else { // '|'
                result = (tCount > 0) ? 't' : 'f';
            }

            stack.push(result);
        }

        return stack.pop() == 't';
    }

    /**
     * ✅ APPROACH 2 — RECURSIVE PARSER (DFS)
     * ✔ Logic Steps
            A recursive function:

            If starts with t or f → return boolean
            Else find operator
            Recursively evaluate inside parentheses
            Apply operator to recursive results
        ✔ Complexity
        ----------------------------------------
        | Case  | Time                 | Space |
        | ----- | -------------------- | ----- |
        | Best  | O(n)                 | O(n)  |
        | Worst | O(n²) (deep parsing) | O(n)  |
        ----------------------------------------

     */

    public static boolean parseBoolExprRecursiveParser(String exp) {
        return eval(exp, 0, exp.length() - 1);
    }

    private static boolean eval(String s, int l, int r) {
        if (l == r) return s.charAt(l) == 't';

        char op = s.charAt(l);
        List<Boolean> vals = new ArrayList<>();

        int i = l + 2; // skip op + '('

        while (i < r) {
            int start = i;

            if (s.charAt(i) == 't' || s.charAt(i) == 'f') {
                vals.add(s.charAt(i) == 't');
                i += 2; // skip value + comma
            } else {
                int count = 0;
                while (i <= r) {
                    if (s.charAt(i) == '(') count++;
                    if (s.charAt(i) == ')') count--;
                    if (count == 0) break;
                    i++;
                }
                vals.add(eval(s, start, i));
                i += 2; // skip comma
            }
        }

        if (op == '!') return !vals.get(0);
        if (op == '&') return vals.stream().allMatch(v -> v);
        return vals.stream().anyMatch(v -> v);
    }

    /**
     * ✅ APPROACH 3 — TOKENIZE + REDUCE
     * ✔ Logic
            Convert expression to tokens
            Use stacks to evaluate tokens in a reduction phase.

            This is similar to Approach 1 but more "compiler-like".

            ✔ Complexity
                Same as Approach 1.
     */

    public boolean parseBoolExprTokenize(String exp) {
        Stack<Character> stk = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (c == ',') continue;
            if (c != ')') {
                stk.push(c);
                continue;
            }

            int t = 0, f = 0;
            while (stk.peek() != '(') {
                char ch = stk.pop();
                if (ch == 't') t++;
                else if (ch == 'f') f++;
            }
            stk.pop();

            char op = stk.pop();
            stk.push(
                op == '&' ? (f > 0 ? 'f' : 't') :
                op == '|' ? (t > 0 ? 't' : 'f') :
                (f == 1 ? 't' : 'f')
            );
        }

        return stk.pop() == 't';
    }


    /**
     * 🧠 Idea Behind the Question

            This question tests:

            ✔ Expression parsing
            ✔ Handling operators, parentheses
            ✔ Stack usage
            ✔ Recursive thinking
            ✔ Evaluating nested boolean expressions
            ✔ Compiler-like parsing skill

            This is a parsing + stack → tree evaluation problem.
     */
    /*
    🔍 Sequence Diagram (Conceptual)
        Expression → Iterate →
            '(' → push  
            't','f' → push  
            ',' → skip  
            ')' → pop until '(' → evaluate → push result
        End → check final stack → result
    */
   /*
   🧭 Step-by-Step Trace (Approach 1)
        Expression:
            "|(&(t,f),!(t))"
        
        Stack evolution:
            | ( & ( t , f ) , ! ( t ) )
            push |
            push (
            push &
            push (
            push t
            push f
            ) → evaluate &(t,f)=f → push f
            push ,
            push !
            push (
            push t
            ) → evaluate !(t)=f → push f
            ) → evaluate |(f,f)=f → final f
   */

    /**
     * ⚠️ Edge Cases
        ✔ Single operand (e.g., t)
        ✔ Nested NOT (e.g., !(!(t)))
        ✔ Single argument operators
        ✔ Multiple nested levels
        ✔ Large expression size (limit ~20k)
        ✔ Only one operator
        ✔ Mix of AND, OR, NOT
     */



}
