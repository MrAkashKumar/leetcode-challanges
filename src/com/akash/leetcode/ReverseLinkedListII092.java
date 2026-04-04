package com.akash.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii
 * 
*/
/**
 * 🧠 Idea Behind This Question
        This problem tests:
            ✔ Pointer manipulation
            ✔ Mastery of linked list reversal
            ✔ Ability to reverse only a sub-portion of the list
            ✔ Handling edge cases (left=1, left=right, small lists)
        Interviewers check for clean pointer logic and writing bug-free code.

        ⏱ Time & Space Complexity
            | Scenario                                                  | Time                         | Space    |
            | --------------------------------------------------------- | ---------------------------- | -------- |
            | **Best Case** *(left=right → no reversal)*                | **O(1)**                     | O(1)     |
            | **Average/Worst Case** *(reverse m = right-left+1 nodes)* | **O(n)**                     | O(1)     |
            | **Reason**                                                | Full traversal may be needed | In-place |
 * 
 */
public class ReverseLinkedListII092 {
    
    public static void main(String[] args) {
        /**
         * 
         * Input: head = [1,2,3,4,5], left = 2, right = 4
         * Output: [1,4,3,2,5]
         * Explaination -  1 => 2 => 3 => 4 => 5
         *               - 1 => 4 => 3 => 2 => 5 
         * Input:[5], left = 1, right = 1
         * Output:[5]
         * 
         */

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);
        System.out.println(" =====================> ");
        /* Execute the reversal = reverseBetween */ 
        int left = 2, right = 4;
        ListNode response  = reverseBetween(head, left, right);

        System.out.println("Modified List reverseBetween (reversed from index " + left + " to " + right + "):");
        printList(response);
        System.out.println(" =====================> ");
        ListNode headRequest = new ListNode(1);
        headRequest.next = new ListNode(2);
        headRequest.next.next = new ListNode(3);
        headRequest.next.next.next = new ListNode(4);
        headRequest.next.next.next.next = new ListNode(5);
        /* Execute the reversal => bruteReverseBetweenApproach  */ 
        ListNode responseBrute  = bruteReverseBetweenApproach(headRequest, left, right);
        System.out.println("Modified List bruteReverseBetweenApproach - Brute force (reversed from index " + left + " to " + right + "):");
        printList(responseBrute);

    }

    /**
     * ✅ BEST INTERVIEW APPROACH — In-Place Reversal Using Three Pointers
     * ⭐ Steps
            1. Move to the node before left index → prev
            2. Start reversing from left to right
            3. Use standard linked-list reversal logic
            4. Connect:
                    prev.next = reversedHead
                    tail.next = nodeAfterRight
            | Scenario                                                  | Time                         | Space    |
            | --------------------------------------------------------- | ---------------------------- | -------- |
            | Best Case- *(left=right → no reversal)                    | O(1)                         | O(1)     |
     */

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 1. Move prev to the node before 'left'
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2. Start reversing the sublist
        ListNode start = prev.next;      // First node of the reversal segment
        ListNode then = start.next;      // Node to be moved

        // 3. Reverse nodes from left to right
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 🧪 Brute Force Approach (NOT recommended for interview)
     * Reverse entire list → cut → join segments.
     * ⏱ Complexity
        Time: O(n)
        Space: O(n) ❌
     */
    
    public static ListNode bruteReverseBetweenApproach(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Convert to array
        List<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }

        // Reverse subarray
        while (left < right) {
            int t = arr.get(left - 1);
            arr.set(left - 1, arr.get(right - 1));
            arr.set(right - 1, t);
            left++; right--;
        }

        // Convert back to list
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : arr) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 🧩 Sequence Diagram (Conceptual)
     *          beforeLeft -> (L) → a → b → c → (R) -> afterRight
                Reverse segment:
                beforeLeft -> (R) → c → b → a → (L) -> afterRight
     */

    /*
    *
    ⚠️ Edge Cases You MUST Handle
        | Case                  | Example                 | Result          |
        | --------------------- | ----------------------- | --------------- |
        | left == right         | `[1,2,3], 2,2`          | Return original |
        | reverse whole list    | left=1, right=n         | Works           |
        | list size 1           | `[5]`                   | `[5]`           |
        | null head             | `head=null`             | null            |
        | contiguous or minimal | `[1,2], left=1,right=2` | reversed        |

    */

    

}
