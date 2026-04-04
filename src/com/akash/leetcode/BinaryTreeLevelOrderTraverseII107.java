package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 🧠 Idea Behind the Question
        This is a classic BFS (Breadth-First Search) problem with one twist:
        Instead of returning top→bottom, you return bottom→top.
    Key idea:
        ✔ Use a queue to traverse level by level
        ✔ Collect nodes at each level
        ✔ Reverse result list at the end
    
    ✖ NOT Applicable
        ❌ Two-pointer → not for tree BFS
        ❌ Sliding window → not for hierarchical tree levels
    Those are array/string techniques; this problem is about tree traversal.

    🧩 Possible Approaches
    | Approach                    | Time        | Space | Notes                            |
    | --------------------------- | ----------- | ----- | -------------------------------- |
    | BFS + Post-Reverse          | O(n)        | O(n)  | Best & Simple                    |
    | DFS with Depth Info         | O(n)        | O(n)  | Good                             |
    | Recursion + Insert at Front | O(n²) worst | O(n)  | Inefficient if inserting at head |

 */
public class BinaryTreeLevelOrderTraverseII107 {

    
    public static void main(String[] args) {
        /**
         * 
         * Input:   
         *     3
              / \
             9  20
                / \
               15  7

           Output:
           [
            [15,7],
            [9,20],
            [3]
           ]

         */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        /* Execute the method */ 
        List<List<Integer>> result = levelOrderBottomViaBFS(root);

        /* Print the result */ 
        System.out.println("Bottom-up Level Order Traversal:");
        System.out.println(result);
        
    }

    /**
     * 
     * ✅ APPROACH 1 — BFS (Queue) + Reverse at End 🚀
        Best interview approach
        ✔ Logic
            Use a queue to traverse level by level
            Add each level’s values into a list
            After BFS, reverse the result
     * ⏱ Time & Space Complexity
            Time Complexity
                ✔ Every node is visited once → O(n)
                ✔ Reversing final list of levels → O(h) where h = number of levels ≤ n
            ➡ Total → O(n)
            Space Complexity
                ✔ Queue stores at most O(w) nodes where w = max width
                ✔ Result list stores all nodes → O(n)
            ➡ Total → O(n)
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> levelOrderBottomViaBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(currentLevel);
        }

        // Reverse the list before returning
        Collections.reverse(result);
        return result;
    }

    /**
     * 🧠 Why This Is Best for Interviews
        ✔ Straightforward BFS logic
        ✔ Easy to explain
        ✔ Optimal time & space
        ✔ Doesn’t require tricky insertion at start
     */
    /**
     * 🧪 Example Trace
     * Input Tree:
     *        3
             / \
            9   20
                / \
               15  7
        Step-by-step:
            Queue = [3]
            level 1 → [3] → result = [[3]]

            Queue = [9,20]
            level 2 → [9,20] → result = [[3],[9,20]]

            Queue = [15,7]
            level 3 → [15,7] → result = [[3],[9,20],[15,7]]
        Reverse result:
            [[15,7],[9,20],[3]]
     */

    /**
     * ======================================================================>>>>>>>>>
     */

    /*
    🚫 APPROACH 2 — Recursion Using DFS (Depth)
        We collect values by depth and then reverse order.
        Time Complexity - ✔ O(n)
        Space Complexity - ✔ O(n)
    Note: BFS is easier and less error-prone than DFS here.
    */
    public static List<List<Integer>> levelOrderBottomViaDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private static void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;

        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);

        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }

    /**
     * 🛠 Steps / Approach
            1. If root is null → return []
            2. Add root to queue
            3. While queue not empty:
                Measure current level size
                Loop that many times:
                    Pop node
                    Add its children
                Add level list
            4. Reverse result
            5. Return
     */

    /*
    
    ⚠ Edge Cases

    | Case            | Input             | Output        |
    | --------------- | ----------------- | ------------- |
    | Empty tree      | null              | []            |
    | Single node     | [1]               | [[1]]         |
    | Left skew tree  | [1,2,null,3]      | [[3],[2],[1]] |
    | Right skew tree | [1,null,2,null,3] | [[3],[2],[1]] |

    */



}
