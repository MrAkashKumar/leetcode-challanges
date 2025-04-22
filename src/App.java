import java.util.Set;
import java.util.function.*;
import java.util.Arrays;
import java.util.HashSet;

public class App {
    
    public static void main(String[] args) throws Exception {

        /*
         *  1. write a program for find out empty directory from local disk
         *  2. write a program to convert - one thousand three hundred two to 1302 
         *  3. Algomaster Io question will solve
         /*

         https://leetcode.com/problems/squares-of-a-sorted-array/description/
         
        /*
            Find the kth smallest element in an array using Java streams:
            int[] array = {4, 2, 7, 1, 5, 3, 6};
            int k = 3; // Find the 3rd smallest element
            Arrays.stream(array).filter(n-> n<k).count();
        */
        String s1 = "characters", s2 = "alphabets" ;
        findUniqueElementFromBothString(s1, s2);
    }
    /*
        you are given two strings s1 and s2. 
        Your task is to identify the characters that appear in either string but not in both 
        (i.e., characters that are unique to one of the strings). Return the result as a sorted string.
        Input: s1 = "characters", s2 = "alphabets"
        Output: "bclpr"
        Explanation: The characters 'b', 'c', 'l', 'p', and 'r' are present in either s1 or s2, but not in both.
        Input: s1 = "rome", s2 = "more"
        Output: ""
        Explanation: Both strings contain the same characters, so there are no unique characters. The output is an empty string.
        Find uncommon characters of the two strings
     */
     /* Input: s1 = "characters", s2 = "alphabets" */
     private static void findUniqueElementFromBothString(String str1, String str2){

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char ch1 : str1.toCharArray()) {
            set1.add(ch1);
        }

        for (char ch2 : str2.toCharArray()) {
            set2.add(ch2);
        }

        System.out.println(set1);
        System.out.println(set2);

        /* merge */ 
        Set<Character> res = new HashSet<>(set2);
        res.addAll(set1);
        System.out.println(res);
        Set<Character> commonElement = new HashSet<>(set2);
        commonElement.retainAll(set1);
        System.out.println(commonElement);

        res.removeAll(commonElement);
        System.out.println(res);
     }

    /* GIVEN A FILE CONTAINING STRING SORT THE STRING IN DICTIONARY ORDER */

    

}