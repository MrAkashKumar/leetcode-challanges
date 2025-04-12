package com.akash.leetcode;
/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=two-pointers 
 */
public class LongestPalidromeNumber5 {
    
    public static void main(String[] args) {
        String str = "babad";
        longestPalindromeWithTwoPointer(str);

        /*
         *  solved by dynamic programming
         *  solved via two pointer also
         */


    }
    // O(n^2) time complexity and O(n^2) space complexity
    private static String longestPalindromeWithDynamicProgramming(String s){

        if(s==null){
            return null;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = "";

        for(int i=0; i<n; i++){
            dp[i][i] = true;
            result = s.charAt(i) + "";
        }

        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                result = s.substring(i, i+2);
            }
        }

        for(int len=3; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    result = s.substring(i, j+1);
                }
            }
        }

        return result;

    } 
    // O(n^2) time complexity and O(1) space complexity
    // two pointer approach
    private static String longestPalindromeWithTwoPointer(String s){

        if(s==null){
            return null;
        }

        

        return null;
    }

}
