package com.akash.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
/**
 * 🎯 Idea Behind This Question
        The interviewer wants to check:
        Do you understand LinkedLists?
        Can you use two-pointer technique?
        Can you merge efficiently without extra space (in-place)?
        Can you handle null nodes, edge cases, ordering logic?
        This is a top-5 most asked LinkedList problem in interviews.
 */

public class MergeTwoSortedList21 {
    
    public static void main(String[] args) {
        /*
        Input -
            list1 = [1, 2, 4]
            list2 = [1, 3, 4]
        Output -
            [1, 1, 2, 3, 4, 4]
        */
        int input1[] = {1,2,4};
        int input2[] = {1,3,4};
        ListNode l1 = createList(input1);
        ListNode l2 = createList(input2);

        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        // 2. Merge them
        ListNode result = mergeTwoLists(l1, l2);

        // 3. Print the result
        System.out.print("Merged List: ");
        printList(result);
    }

    /* Helper method to create a linked list from an array */ 
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    /* Helper method to print the linked list */ 
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 🧠 Approach 1 (BEST) — Two Pointers (Iterative)
        ✔ Most recommended in interviews ------>  Best For Interview
        ✔ In-place merge (no extra memory for new nodes)
        ⚡ Steps (Iterative Two-pointer)
        Two pointers:
        You compare values and attach the smaller one to the new list.

        Sequence:
            Create a dummy node
            Maintain a tail pointer
            Compare p1.val and p2.val
            Attach smaller node to tail
            Move the pointer forward
            Continue until one list ends
            Attach remaining nodes
        ⏳ Time & Space Complexity
            | Case                           | Time     | Space |
            | ------------------------------ | -------- | ----- |
            | Best Case (one list empty)     | O(1)     | O(1)  |
            | Worst Case (iterate all nodes) | O(n + m) | O(1)  |
            | Average Case                   | O(n + m) | O(1)  |
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { 
            this.val = val; 
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        tail.next = (p1 != null) ? p1 : p2;

        return dummy.next;
    }

    /**
     * 
     * 🔍 Example Trace
     *  p1=1, p2=1  → take p2  
        Merged: 1  

        p1=1, p2=3 → take p1  
        Merged: 1 → 1

        p1=2, p2=3 → take p1  
        Merged: 1 → 1 → 2

        p1=4, p2=3 → take p2  
        Merged: 1 → 1 → 2 → 3

        p1=4, p2=4 → take p2  
        Merged: 1 → 1 → 2 → 3 → 4

        Remaining p1=4  
        Attach it
     * 
     */

        /**
         * 🌀 Approach 2 — Recursive Merge
            Logic:
                If list1 < list2
                    → list1.next = merge(list1.next, list2)
                Otherwise
                    → list2.next = merge(list1, list2.next)
            
            Complexity: 
                Time: O(n + m)
                Space: O(n + m) due to recursion stack
                ➡ Not ideal for interviews (stack overflow in large lists)
         */
    
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /**
     * 
     * ⚙️ Approach 3 — Priority Queue (Min-Heap)
        Useful when merging k sorted lists, but works here too.
        Steps:
            Insert both heads into PQ
            Poll smallest
            Push its next
            Build merged list
        
        Complexity:
        Time: O((n+m) log 2) = O(n+m)
        Space: O(1) extra (PQ has only 2 elements)
     */
    public static ListNode mergeTwoListsViaPriority(ListNode list1, ListNode list2) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);

        if (list1 != null) pq.offer(list1);
        if (list2 != null) pq.offer(list2);

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;

            if (node.next != null) pq.offer(node.next);
        }

        return dummy.next;
    }


}
