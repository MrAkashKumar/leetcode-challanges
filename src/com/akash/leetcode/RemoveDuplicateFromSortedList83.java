package com.akash.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 */
/**
 * 🧠 Idea Behind This Question
        Because the list is sorted, all duplicates appear adjacent.
        So the logic becomes very simple:

        If current.val == current.next.val, skip the next node.
        Otherwise, move forward.
        This is why the problem is EASY and common in interviews.
 */
public class RemoveDuplicateFromSortedList83 {

    public static void main(String[] args) {
        
        /*
        Input: head = [1,1,2]
        Output: [1,2]

        Input: [1,1,2,3,3]
        Output: [1,2,3]
        */
       // 1. Create a sorted list with duplicates: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        // 2. Call your method
        head = deleteDuplicates(head);

        // 3. Display the result
        System.out.println("After removing duplicates:");
        printList(head);

    }

    /**
     * 
     * 🏆 BEST APPROACH (Recommended in Interviews)
     *    👉 Single Pointer / Two-pointer Linked List traversal
     *  ✔ Time: O(n). ✔ Space: O(1)
     *  | Scenario                          | Time | Space |
        | --------------------------------- | ---- | ----- |
        | Best Case (no duplicates)         | O(n) | O(1)  |
        | Worst Case (all nodes duplicated) | O(n) | O(1)  |
        | Average                           | O(n) | O(1)  |

     * 
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                /* Skip the duplicate node */ 
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * 🧩 Why This Works So Well?
     *       Because of the sorted property:
     *       1 → 1 → 1 → 2 → 3 → 3
                   ↑       ↑
            Remove duplicates in place
            We simply bypass duplicate nodes.
        Explanation:
           ✔ We visit each node once
           ✔ No extra data structure → constant space
     */

    
    /**
     * 🧪 Brute Force Approach
        Convert list → HashSet → sorted again → rebuild list.
        Brute Force Code (for academic completeness only)
         =>  Time: O(n) but with overhead, Space: O(n) (bad)
     */
    public ListNode bruteDeleteDuplicates(ListNode head) {
        if (head == null) return null;

        Set<Integer> set = new LinkedHashSet<>();
        ListNode temp = head;

        while (temp != null) {
            set.add(temp.val);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : set) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }


    /**
     * 🔧 Two-Pointer Variation (Same Logic, Different Style)
     *  Why Two-pointer?
            slow indicates last unique element
            fast scans ahead
     */

    public ListNode deleteDuplicatesTwoPointer(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;

        return head;
    }


    /**
     * 🧠 Step-by-Step Approach (How to Think in Interview)
            Notice "sorted" → duplicates are consecutive
            Use a pointer current
            If current.val == current.next.val → skip
            Else move forward
            Continue until list end
     */

    /*
        🔍 Example Trace
            Input:
                1 → 1 → 2 → 3 → 3
            
            Step-by-step:
                current = 1
                    1 == 1 → skip → 1 → 2 → 3 → 3

                current = 1
                    1 != 2 → move

                current = 2
                    2 != 3 → move

                current = 3
                    3 == 3 → skip
            
            Final:
                1 → 2 → 3
    
    */

    /**
     * 📊 Sequence Diagram (Conceptual)
     * 
     *      current        next
                ↓             ↓
            [1] → [1] → [2] → [3]

            if equal → skip next pointer:
            current.next = next.next
     * 
     */



    
}
