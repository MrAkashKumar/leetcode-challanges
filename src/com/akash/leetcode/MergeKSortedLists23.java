package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
*/
/*
⭐ Idea Behind the Question
This problem tests:

    ✔ Priority Queue (Min-Heap)
    ✔ Divide & Conquer (Merge Sort style)
    ✔ Linked List manipulation
    ✔ Time complexity optimization
    ✔ Handling edge cases in linked lists
The goal:
Efficiently merge all lists with minimum comparisons.



*/
public class MergeKSortedLists23 {
    
    public static void main(String[] args) {
        /**
         * Input => lists = [1 -> 4 -> 5, 1 -> 3 -> 4, 2 -> 6]
         * Output = 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
         */
    }
    /**
     * ⚠️ Edge Cases
     *  --------------------------------------------------------------------
     *  | Case            | Example        | Result                       |
        | --------------- | -------------- | ---------------------------- |
        | All lists empty | `[null, null]` | return null                  |
        | One list only   | `[list1]`      | return list1                 |
        | Large lists     | stress test    | should still pass O(N log K) |
        | K = 0           | `[]`           | return null                  |
        ----------------------------------------------------------------------
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 🎯 APPROACH 1 — Two-Pointer Merge One-by-One
        Merge lists sequentially:
            (L1 merge L2) → merge with L3 → merge with L4 …
        Time Complexity
            Merging two lists of size M & N → O(M + N)
            Worst case merges repeatedly
            ➡ O(K * N)
            ❌ Very slow when K is large.
        Space Complexity
            O(1)
     * 
     */

    public ListNode mergeKListsViaTwoPointer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
    /**
     * 🎯 APPROACH 2 — Divide & Conquer (Merge Sort Style)
            ✔ Recommended Approach
            ✔ Better than sequential merging
            ✔ Balanced merges reduce repeated work
        Idea
            Pairwise merge:
                Round 1: merge in pairs → K/2 lists  
                Round 2: merge again → K/4  
                ... until only 1 list
        Time Complexity
            Each layer merges N items → O(N)
            Number of layers → log K
            ➡ O(N log K)
        Space Complexity
            O(1) extra
     * 
     */
    public ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoListsViaDivide(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    private ListNode mergeTwoListsViaDivide(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    /**
     * 🎯 APPROACH 3 — Min Heap (Priority Queue) — BEST FOR INTERVIEW
            ✔ FASTEST approach
            ✔ Clean, elegant
            ✔ Very intuitive
        Steps/Logic
            Insert head of each list into Min Heap
            Pop minimum
            Add its next node to heap
            Build result list
        Time Complexity
            Each of N nodes inserted once → O(log K) per node
            ➡ O(N log K)
        Space Complexity
            Heap size = K
            ➡ O(K)
     */
    public ListNode mergeKListsViaPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );

        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null)
                pq.add(node.next);
        }

        return dummy.next;
    }

    /*
    🔍 EXAMPLE TRACE (Heap Approach)
    Input =>> lists = [[1,4,5], [1,3,4], [2,6]]

    Initial heap content:
            1 (L1), 1 (L2), 2 (L3)
        Pop 1 → push 4
        Pop 1 → push 3
        Pop 2 → push 6
        Pop 3 → push 4
        Pop 4 → push 5
        Pop 4
        Pop 5
        Pop 6

    Final Output:
        1 → 1 → 2 → 3 → 4 → 4 → 5 → 6
    
    📊 Sequence Diagram — High Level (Heap Approach)
        Lists ---> PQ ---> Result
            \      |        |
             \     v        v
            ---> Insert -> ExtractMin -> Append -> InsertNext
    
    */

    /**
     * 
     * Best Approach for Interview?
            ✔ Priority Queue (Min Heap)
        WHY?
            Clean and optimal
            Easy to explain
            Logically intuitive
            Best time complexity
        📝 Best Case & Worst Case Analysis
            ---------------------------------------------------------------------------
            | Case           | Explanation                             | Complexity   |
            | -------------- | --------------------------------------- | ------------ |
            | **Best Case**  | All lists empty / only 1 non-empty list | O(1) or O(N) |
            | **Worst Case** | Balanced large K lists                  | O(N log K)   |
            ---------------------------------------------------------------------------
     * 
     */


    /*
    🎯 APPROACH 4 — Brute Force (Put values → Sort → Create list)
            ✔ Easiest
            ❌ NOT recommended in interviews
        Logic Steps   
            Loop all lists, extract values into array/list
            Sort
            Create linked list from sorted array
        Time Complexity
            Collect values = O(N)   
            Sorting = O(N log N)
            Build list = O(N)
            ➡ Total = O(N log N)
        Space Complexity
            Extra array = O(N)
    */
    
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> values = new ArrayList<>();

        for (ListNode head : lists) {
            while (head != null) {
                values.add(head.val);
                head = head.next;
            }
        }

        Collections.sort(values);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }


}
