package com.akash.leetcode;
/*
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * 
 */
public class FindDuplicateNumber287 {

    public static void main(String[] args) {
        int[] num = {1, 3, 4, 2, 2};
        int duplicateNumber = findTheDuplicateNumber(num);
        int duplicateNumberUsingFloyd = findTheDuplicateNumberUsingFloyd(num);
        System.out.println(duplicateNumber);
        System.out.println(duplicateNumberUsingFloyd);

    }

    /*
     * using binary search
     * time complexity = o(log n)
     * space complexity = o(1)
     * Floyd’s Tortoise and Hare (Cycle Detection)
     */
    private static int findTheDuplicateNumber(int[] num) {
        int left = 1;
        int right = num.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            // Count numbers less than or equal to mid
            for (int value : num) {
                if (value <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // Duplicate lies in the left value range
                right = mid;
            } else {
                // Duplicate lies in the right value range
                left = mid + 1;
            }
        }

        return left;
    }

    /*
     * Floyd's Tortoise and Hare
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private static int findTheDuplicateNumberUsingFloyd(int[] num) {

        int slow = num[0];
        int fast = num[0];

        // Phase 1: Find the intersection point
        do {
            slow = num[slow];
            fast = num[num[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = num[0];

        while (slow != fast) {
            slow = num[slow];
            fast = num[fast];
        }

        return slow;
    }
    /*
            Feature	            Binary Search	                Floyd's Algorithm
            Time complexity	    (O(nlog n))	                    (O(n))
            Extra space	        (O(1))	                        (O(1))
            Modifies array?	     No	                            No
            Main concept	    Count values ≤ mid	            Detect a cycle
            Best for	        Practising binary search        Optimal time complexity
    */
    

}
