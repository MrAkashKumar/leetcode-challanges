package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/invalid-transactions/description/
 * 
 * 🧠 Approach Overview
 *  ---------------------------------------------------------------------------------------
 *  | Approach                 | Idea                     | Complexity | Interview Worth  |
    | ------------------------ | ------------------------ | ---------- | ---------------  |
    | Brute Force              | Compare all pairs        | O(n²)      | Basic            |
    | HashMap + Grouping       | Compare within same name | O(n²)      | Good             |
    | Sorting + Sliding Window | Optimize comparisons     | O(n log n) | ⭐ Best          |
    | Time Bucket Optimization | Near O(n)                | Advanced   |                  |
    ---------------------------------------------------------------------------------------
    💡 Core Idea
        This is a data grouping + comparison problem
        👉 Key Observations:
            Compare transactions only within same name
            Time constraint → range check (±60 minutes)
            City must be different
 * 
 */

public class InvalidTransactions1169 {
    
    public static void main(String[] args) {

        /*
        Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
        Output: ["alice,20,800,mtv","alice,50,100,beijing"]
        Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, 
        have the same name and is in a different city. Similarly the second one is invalid too.

        ---------------------------------------------------------------
        Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
        Output: ["alice,50,1200,mtv"]

        --------------------------------------------------------------
        Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
        Output: ["bob,50,1200,mtv"]

        */
       String input[] = {"alice,20,800,mtv","alice,50,100,beijing"};
       List<String> invalidTransactionList = invalidTransactions(input);
       System.out.println(invalidTransactionList);


    }

    /*
    🥇 BEST INTERVIEW APPROACH → Sorting + Sliding Window
        🔥 Why this is best?
            ✔ Reduces unnecessary comparisons
            ✔ Efficient grouping
            ✔ Easy to explain
            ✔ Real-world scalable
    🧾 Step-by-Step Logic
        Step 1: Parse transactions
            Convert string → object
        Step 2: Group by name
            Use Map<String, List<Transaction>>
        Step 3: Sort each group by time
        Step 4: Sliding window check
            For each transaction:
            Check previous transactions within 60 minutes
            If city differs → mark both invalid
        
        📊 Time & Space Complexity
        ✔ Best Approach
        ------------------------------------------------
        | Case       | Time                    | Space |
        | ---------- | ----------------------- | ----- |
        | Best Case  | O(n log n)              | O(n)  |
        | Worst Case | O(n²) (same name dense) | O(n)  |
        ------------------------------------------------
        🔍 Execution Trace
        alice:
            (20, mtv)
            (50, beijing)

            50 - 20 = 30 <= 60
            city different → both invalid
        ⚠️ Edge Cases
            ✔ Same city → valid
            ✔ Same time → check city
            ✔ Single transaction → only amount matters
            ✔ Multiple invalid overlaps
            ✔ All same name → worst case O(n²)
    */
    static class Transaction {
        String name, city, original;
        int time, amount;

        Transaction(String t) {
            this.original = t;
            String[] parts = t.split(",");
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
        }
    }

    public static List<String> invalidTransactions(String[] transactions) {

        Map<String, List<Transaction>> map = new HashMap<>();

        // Step 1: Parse & group
        for (String t : transactions) {
            Transaction txn = new Transaction(t);
            map.computeIfAbsent(txn.name, k -> new ArrayList<>()).add(txn);
        }

        Set<String> result = new HashSet<>();

        // Step 2: Process each user
        for (List<Transaction> list : map.values()) {

            // Sort by time
            Collections.sort(list, (a, b) -> a.time - b.time);

            for (int i = 0; i < list.size(); i++) {

                Transaction curr = list.get(i);

                // Rule 1: amount > 1000
                if (curr.amount > 1000) {
                    result.add(curr.original);
                }

                // Rule 2: sliding window check
                for (int j = i - 1; j >= 0; j--) {
                    Transaction prev = list.get(j);

                    if (curr.time - prev.time > 60) break;

                    if (!curr.city.equals(prev.city)) {
                        result.add(curr.original);
                        result.add(prev.original);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    /*
        🧪 Approach 2 — HashMap + Brute Comparison
        💡 Idea
            Group by name
            Compare all pairs inside group
        ⏱ Complexity
        ---------------------------
        | Case  | Time  | Space |
        | ----- | ----- | ----- |
        | Best  | O(n²) | O(n)  |
        | Worst | O(n²) | O(n)  |
        --------------------------
    
    */
    public static List<String> invalidTransactionsBrute(String[] transactions) {

        int n = transactions.length;
        boolean[] invalid = new boolean[n];

        String[] name = new String[n];
        int[] time = new int[n];
        int[] amount = new int[n];
        String[] city = new String[n];

        /* Parse */ 
        for (int i = 0; i < n; i++) {
            String[] parts = transactions[i].split(",");
            name[i] = parts[0];
            time[i] = Integer.parseInt(parts[1]);
            amount[i] = Integer.parseInt(parts[2]);
            city[i] = parts[3];

            if (amount[i] > 1000) {
                invalid[i] = true;
            }
        }

        /* Compare all pairs */
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (name[i].equals(name[j]) &&
                    Math.abs(time[i] - time[j]) <= 60 &&
                    !city[i].equals(city[j])) {

                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (invalid[i]) res.add(transactions[i]);
        }

        return res;
    }

    /**
     * ⚡ Approach 3 — Optimized Sliding Window + Two Pass
            (Advanced)
        💡 Idea
            Sort all transactions globally by time
            Maintain window of last 60 minutes per user
        ⏱ Complexity
        ---------------------------------------------
        | Case  | Time                      | Space |
        | ----- | ------------------------- | ----- |
        | Best  | O(n log n)                | O(n)  |
        | Worst | O(n²) (conflicts marking) | O(n)  |
        ---------------------------------------------
     */

    /**
     * 📊 Sequence Diagram
     *  Input Transactions
                ↓
        Parsing → Objects
                ↓
        Group by Name
                ↓
        Sort by Time
                ↓
        Sliding Window Check
                ↓
        Mark Invalid
                ↓
        Return Result
     */

    /*
    🎯 Interview Strategy

        👉 If asked:
                Start with brute force (O(n²))
                Improve using grouping
                Then propose sorting + sliding window (BEST)
                Mention optimization idea
        🧠 Key Insight to Say in Interview
            “We only compare transactions within the same name, and by sorting them by time, 
            we reduce unnecessary comparisons using a sliding window of 60 minutes.”

        🎉 Final Summary
            ✔ Core concept = Grouping + Time Window + Condition Check
            ✔ Best solution = Sorting + Sliding Window
            ✔ Worst case still O(n²), but optimized in practice
    */

    
}
