package com.akash.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/
 */
public class MinimumDeletation3545 {

    public static void main(String[] args) {

        String str = "abc";
        int k = 2;

        int minDeletionResponse = minDeletion(str, k);    
        System.out.println(minDeletionResponse);

        int minDeletionPriority = minDeletionUsingPriorityQueue(str, k);
        System.out.println(minDeletionPriority);

        System.out.println("Response  : "+ minDeletionUsingList(str, k));
        
    }

    private static int minDeletion(String s, int k) {

        int a[] = new int[26];
        for(char c : s.toCharArray()){
            a[c-'a']++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((x,y)->x-y);
        for(int i : a){
            if (i!=0){
                q.add(i);
            }
        }
        int ans = 0;
        while(!q.isEmpty() && q.size()>k){
            ans += q.poll();
        }
        return ans;
    }

    private static int minDeletionUsingPriorityQueue(String str, int k){

        // Step 1: Frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int distinctCount = freqMap.size();
        if (distinctCount <= k) return 0;

        // Step 2: Put frequencies into a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int freq : freqMap.values()) {
            minHeap.offer(freq);
        }

        // Step 3: Remove lowest frequency characters to reach k distinct characters
        int deletions = 0;
        int removeCount = distinctCount - k;

        while (removeCount > 0) {
            deletions += minHeap.poll(); // remove full frequency of 1 char
            removeCount--;
        }

        return deletions;
    }

    private static int minDeletionUsingList(String str, int k){

        Map<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequency of each character
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: If distinct characters <= k, no need to delete
        if (freqMap.size() <= k) return 0;

        // Step 3: Sort the frequencies
        List<Integer> freqs = new ArrayList<>(freqMap.values());
        Collections.sort(freqs); // ascending order

        int deletions = 0;
        int toRemove = freqMap.size() - k;

        for (int i = 0; i < toRemove; i++) {
            deletions += freqs.get(i); // remove full character
        }

        return deletions;


    }



    
}
