package com.akash.leetcode;
import java.util.*;
/*
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 * 
 */
public class RemoveUniqueConsequtiveChar1209 {
    
    public static void main(String[] args) {

        String str = "deeedbbcccbdaa"; int k =3;
        String response = removeConsectiveIdentical(str, k);
        System.out.println(response);
        
    }
    
    /*
     * Time complexity - o(n)
     * Space complexity - o(n)
     */
    private static String removeConsectiveIdentical(String str, int k){

        Deque<PairOccur> stack = new ArrayDeque<>();

        for(char ch : str.toCharArray()){

            if(!stack.isEmpty() && stack.peek().ch == ch){
                stack.peek().count++;
                if(stack.peek().count==k){
                    stack.pop();
                }
            }else{
                stack.push(new PairOccur(ch, 1));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(PairOccur pair : stack){
            for(int i = 0; i< pair.getCount(); i++){
                stringBuilder.append(pair.ch);
            }
        }

        return stringBuilder.reverse().toString();
    }

    private static class PairOccur{

        private int count;
        private char ch;

        PairOccur(char ch, int count){
            this.ch = ch;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "PairOccur [count=" + count + ", ch=" + ch + "]";
        }
    }

    /*
     *      Metric           | Complexity
     * 
     *  Time Complexity      | O(n)
     *  Space Complexity     | O(n)
     */

    public String removeDuplicates(String s, int k) {
        int len = s.length();
        int slow = -1;
        int[] count = new int[len];
        char[] ch = s.toCharArray();

        for (int fast = 0; fast < s.length(); fast++) {
            ch[++slow] = ch[fast];
            count[slow] = slow > 0 && ch[slow] == ch[slow - 1] ? count[slow - 1] + 1 : 1;
            if (count[slow] >= k) {
               slow -= count[slow];
            }    
        }
        return new String(ch, 0, slow + 1);
   }

}
