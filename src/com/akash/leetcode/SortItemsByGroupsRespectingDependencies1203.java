package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/description/
 * 
 * 
 * You are given:
    ✔ n items (0 to n-1)
    ✔ m groups (0 to m-1), but some items have no group (group[i] = -1)
    ✔ beforeItems[i] = list of items that must come before item i

    Your task:
    ➡️ Return a valid ordering of all items that:
            Respects all item dependencies
            Groups items respecting group dependencies
            All items in the same group appear consecutively

            If no valid ordering exists, return empty array.
    💡 Core Logic (Why this approach?)
            This is a two-level dependency problem:
            🔹 Items depend on other items
            🔹 Groups depend on other groups (inferred from item dependencies)
            So we need:
            ✅ Topological sort for items
            AND
            ✅ Topological sort for groups
    
    🚀 Solution Strategy
        Assign unique groups to items that have group[i] = -1
        Build:
        Item dependency graph
        Group dependency graph (derived from item dependencies)
        Topological sort items
        Topological sort groups
        Merge based on group order

    📌 Breakdown of Logic
        ✅ Step-By-Step (High Level)
            Convert ungrouped items (-1) into unique groups
            Build item & group dependency graphs
            Topo sort items → ensures intra-group logic
            Topo sort groups → ensures inter-group logic
            Merge items sorted by group order
    
    
 */
public class SortItemsByGroupsRespectingDependencies1203 {
    
    public static void main(String[] args) {
        /**
     * 📋 Example
     * Input
     *  n = 8, m = 2
            group = [-1,-1,1,0,0,1,0,-1]
            beforeItems = [
            [],
            [6],
            [5],
            [6],
            [3,6],
            [],
            [],
            []
            ]
        Output- [6,1,5,2,3,4,0,7]

     */

    /*
        Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
        Output: []
        Explanation: This is the same as example 1 except that 4 needs to be before 6 in the sorted list.
    */
        int n = 8, m =2;
        int groups[] = {-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = new ArrayList<>();
        beforeItems.add(new ArrayList<>()); // 0
        beforeItems.add(Arrays.asList(6));  // 1
        beforeItems.add(Arrays.asList(5));  // 2
        beforeItems.add(Arrays.asList(6));  // 3
        beforeItems.add(Arrays.asList(3, 6)); // 4
        beforeItems.add(new ArrayList<>()); // 5
        beforeItems.add(new ArrayList<>()); // 6
        beforeItems.add(new ArrayList<>()); // 7

        int[] response = sortItems(n, m, groups, beforeItems);
        System.out.println(" response: "+ response);
    }

    /**
     * 📌 Best Approach — Double Topological Sort - Best Interview
     * 
     * 📊 Time & Space Complexity (Best Case & Worst Case)
     *  | Scenario       | Time Complexity                               | Space Complexity |
        | -------------- | --------------------------------------------- | ---------------- |
        | **Best Case**  | O(n + m)                                      | O(n + m)         |
        | **Worst Case** | O(n + m + E) where E = total dependency edges | O(n + m + E)     |

     * 
     */

    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // -----------------------
        // STEP 1: Reassign ungrouped items to unique groups
        // -----------------------
        int nextGroup = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = nextGroup++;
            }
        }
        
        int totalGroups = nextGroup;

        // -----------------------
        // STEP 2: Build graphs
        // -----------------------

        // groupGraph: group -> groups that depend on it
        List<List<Integer>> groupGraph = new ArrayList<>();
        int[] groupIndegree = new int[totalGroups];
        for (int i = 0; i < totalGroups; i++) {
            groupGraph.add(new ArrayList<>());
        }

        // itemGraph: item -> items that depend on it
        List<List<Integer>> itemGraph = new ArrayList<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        // Fill edges
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {

                // item -> item graph edge
                itemGraph.get(prev).add(curr);
                itemIndegree[curr]++;

                // if dependency crosses groups  
                if (group[prev] != group[curr]) {
                    groupGraph.get(group[prev]).add(group[curr]);
                    groupIndegree[group[curr]]++;
                }
            }
        }

        // -----------------------
        // STEP 3: Topologically sort items
        // -----------------------
        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree);
        if (itemOrder.isEmpty()) {
            return new int[0];  // cycle among items
        }

        // -----------------------
        // STEP 4: Topologically sort groups
        // -----------------------
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);
        if (groupOrder.isEmpty()) {
            return new int[0];  // cycle among groups
        }

        // -----------------------
        // STEP 5: Arrange items by group order
        // -----------------------
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (int item : itemOrder) {
            buckets.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }

        List<Integer> output = new ArrayList<>();
        for (int g : groupOrder) {
            if (buckets.containsKey(g)) {
                output.addAll(buckets.get(g));
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }

    // Generic Topological Sort
    private static List<Integer> topoSort(List<List<Integer>> graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);

            for (int next : graph.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (order.size() == indegree.length) {
            return order;
        }
        return new ArrayList<>();  // cycle detected
    }
    /**
     * ⚠️ Edge Cases to Consider
            ✔ Circular dependency among items
            ✔ Circular dependency propagated to groups
            ✔ Items with no group
            ✔ All items belong to unique groups
            ✔ No dependencies at all
     */
    /**
     * 🔍 6. Step-by-step Execution Trace (Important for Interview)
     * 
     * After assigning groups:
     *  Item: 0 1 2 3 4 5 6 7
        Group:2 3 1 0 0 1 0 4

        Item graph edges:
        1 → 6
        2 → 5
        3 → 6
        4 → 3,6

        Group graph edges:
            group(1)=3 → group(6)=0
            group(4)=0 → group(3)=0 (ignored, same group)

        Item Topo Sort result
            [6,1,5,2,3,4,0,7]
        
        Group Topo Sort:
            Example:
                [0,1,2,3,4]
            
        Combined:
            [ items in group 0 ][ group 1 ][ group2 ]...

     * 
     */

    /**
     * 📈 Sequence Diagram (Conceptual)
     *  Items ----> Item Dependency Builder ----> Item Topological Sort ----\
                                                                             ---> Merge ---> Final Output
        Groups <--- Group Dependency Builder <--- Group Topological Sort ----/
     */
}
