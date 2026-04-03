package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-paths
 */
/**
 * 🧠 Idea Behind the Question
 *      A root-to-leaf path is a sequence of nodes from root until a leaf.
 *      This can be solved naturally using:
 *          DFS (Depth First Search) → Best & most common interview approach
 *          BFS (Queue)
 *          Backtracking
 */

public class BinaryTreePaths257 {
    
    public static void main(String[] args) {

        /*
            Input: [1,2,3,null,5]
            Output: ["1->2->5","1->3"]
        */
       List<Integer> list = Arrays.asList(1, 2, 3, null, 5);
       Integer[] input = {1, 2, 3, null, 5};
       System.out.println("Orginal list  "+ list);
           
       TreeNode root = TreeNode.build(input);

       List<String> paths = binaryTreePathsViaDFS(root);
       System.out.println(" Binary Tree Path via DFS " +paths);

       List<String> pathList = binaryTreePathsBFS(root);
       System.out.println(" Binary Tree Path via BFS " +pathList);
        
    }

    /**
     * ✅ 1. DFS Recursive Approach (Most Recommended in Interviews Section)
     * ✔ Logic
     *   Traverse tree from root.
     *   Add node value to path.
     *   If leaf → add path to result.
     *   Otherwise explore left & right.
     * 
     *  Let n = number of nodes, h = height of tree.
     *  
     *  Best Case (Balanced Tree)
     *      Time: O(n), Space: O(h) ≈ O(log n)
     * 
     *  Worst Case (Skewed Tree)
     *      Time: O(n), Space: O(n)
     *  
     * Input Tree:
     *    1
        /   \
        2     3
        \
         5
     *  
     *  DFS Steps:
     *      dfs(1, "")
            → path = "1"

            dfs(2, "1")
            → path = "1->2"

            dfs(null) → return
            dfs(5, "1->2")
            → leaf → add "1->2->5"

            dfs(3, "1")
            → leaf → add "1->3"
     *  
     *       
     */

    public static class TreeNode {
        public Integer val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        /* Build tree from level order array */ 
        public static TreeNode build(Integer[] arr) {
            if (arr == null || arr.length == 0) return null;

            TreeNode root = new TreeNode(arr[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int i = 1;
            while (i < arr.length) {
                TreeNode curr = queue.poll();

                if (arr[i] != null) {
                    curr.left = new TreeNode(arr[i]);
                    queue.add(curr.left);
                }
                i++;

                if (i < arr.length && arr[i] != null) {
                    curr.right = new TreeNode(arr[i]);
                    queue.add(curr.right);
                }
                i++;
            }
            return root;
        }
    }


    public static List<String>  binaryTreePathsViaDFS(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private static void  dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // add current node to path
        path = path.length() == 0 ? "" + node.val : path + "->" + node.val;

        // leaf node condition
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }

    /**
     *  OR 
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        StringBuilder sb = new StringBuilder();
        dfs(root, sb, result);
        return result;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        int len = path.length();

        if (len == 0) path.append(node.val);
        else path.append("->").append(node.val);

        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            if (node.left != null) dfs(node.left, path, result);
            if (node.right != null) dfs(node.right, path, result);
        }

        path.setLength(len); /* backtracking */ 
    }


    /*  
    * ✅ BFS Approach (Queue)
    * ✔ Logic:
        1. Level-order traversal.
        2. Maintain pair (node, path).
        3. Add to result when reaching leaf.  
    * 
        Complexity

    */
    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    } 
   
    public static List<String> binaryTreePathsBFS(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Pair<TreeNode, String>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, String.valueOf(root.val)));

        while (!queue.isEmpty()) {
            Pair<TreeNode, String> curr = queue.poll();
            TreeNode node = curr.getKey();
            String path = curr.getValue();

            if (node.left == null && node.right == null) {
                result.add(path);
            }

            if (node.left != null)
                queue.add(new Pair<>(node.left, path + "->" + node.left.val));

            if (node.right != null)
                queue.add(new Pair<>(node.right, path + "->" + node.right.val));
        }
        return result;
    }

    /*
        🔍 Brute Force Approach
        Traverse every path without storing and check manually for leaves.
    */
   void bruteForce(TreeNode root, String path) {
        if (root == null) return;

        path += root.val + "->";

        if (root.left == null && root.right == null) {
            System.out.println(path.substring(0, path.length() - 2));
            return;
        }

        bruteForce(root.left, path);
        bruteForce(root.right, path);
    }


    /**
     * 
     * 📌 Step-by-Step Approach for Interviews
            Step 1 — Identify problem type
                ✔ Tree traversal
                ✔ Generate root-to-leaf paths
            Step 2 — Choose traversal
                DFS is best because:
                    naturally builds path
                    path is linear from root → leaf
            Step 3 — Handle leaf node
                When left & right are NULL → path is complete.
            Step 4 — Return list of strings.
     */

    /**
     * 
     * ⚠ Edge Cases to Consider
     * 
     * | Case                       | Output                  |
       | -------------------------- | ----------------------- |
       | Empty tree → `root = null` | `[]`                    |
       | Single node tree           | `["value"]`             |
       | Skewed tree                | Large depth → long path |
       | Negative values            | Should still work       |
       | Duplicate values           | No issue                |
     * 
     */

}
