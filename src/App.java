import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("---------------------------------");
        String strArray[] = {"Sonali","Sonali", "RAm"};
        FindDuplicateFromArray(strArray);



        /*
         *  write a program for find out empty directory from local disk
         *  write a program to convert - one thousand three hundred two to 1302 
         *  Algomaster Io question will solve
         /*
/*
Find the kth smallest element in an array using Java streams:
int[] array = {4, 2, 7, 1, 5, 3, 6};
int k = 3; // Find the 3rd smallest element
Arrays.stream(array).filter(n-> n<k).count();

          */
          /*
           *  Longest substring without repeating character find length in given string
           * String input = "abcabcbb";
           * return - 3
           */

           /*
            * 
            abc
            abcabcbb
            
            a,
            ab,
            abc,
            bc,
            ca
            c
            b

            // if i am using hashset - then i can remove duplicate char
            i will take two point - left and right 

            */
            String str = "abcabcbb";
            //int response = findLengthOfSubString(str);
            //System.out.println(response);


           String s1 = "characters", s2 = "alphabets" ;
            //findUniqueElementFromBothString(s1, s2);

    }


    private static int findLengthOfSubString(String str){
        int n = str.length();
        int left = 0;
        int maxLengthOfSubString = 0;

        HashSet<Character> hashSet = new HashSet<>();

        for(int right = 0; right < n; right++){
            while (hashSet.contains(str.charAt(right))) {
                hashSet.remove(str.charAt(left));
                left++;
            }
            hashSet.add(str.charAt(right));
            maxLengthOfSubString = Math.max(maxLengthOfSubString, right-left+1);
        }
        return maxLengthOfSubString;

    }



    /*
     * 
     * Y
you are given two strings s1 and s2. 
Your task is to identify the characters that appear in either string but not in both 
(i.e., characters that are unique to one of the strings). Return the result as a sorted string.
 
Input: s1 = "characters", s2 = "alphabets"

Output: "bclpr"

Explanation: The characters 'b', 'c', 'l', 'p', and 'r' are present in either s1 or s2, but not in both.
 
Input: s1 = "rome", s2 = "more"

Output: ""

Explanation: Both strings contain the same characters, so there are no unique characters. The output is an empty string.
 
     * 
     */
        //Input: s1 = "characters", s2 = "alphabets" 
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

        Set<Character> res = new HashSet<>(set2);
        res.addAll(set1);

        System.out.println(res);
        Set<Character> commonElement = new HashSet<>(set2);
        commonElement.retainAll(set1);
        System.out.println(commonElement);

        res.removeAll(commonElement);
        System.out.println(res);

         /*
         "bclpr"
         */

     }

      /*
       * String str[] = {"Sonali","soNali", "RAm"}; 
       */

      private static void FindDuplicateFromArray(String[] str){

        List<String> listArray = Arrays.asList(str);
        
        Map<String, Long> duplicateMap = listArray.stream().
        collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().filter(entry-> entry.getValue()> 1)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(duplicateMap);
      }


//GIVEN A FILE CONTAINING STRING SORT THE STRING IN DICTIONARY ORDER

}