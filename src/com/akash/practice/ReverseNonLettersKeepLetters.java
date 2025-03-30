package com.akash.practice;
/*
 * @author Akash Kumar
 */
public class ReverseNonLettersKeepLetters {
    
    public static void main(String[] args) {
        String input = "a1b!c-d@e2";  
        String result = reverseNonLetters(input);
        System.out.println("Reversed: " + result);  
    }

    /*
     * keep letter and reverse non-letters
     */
    public static String reverseNonLetters(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (Character.isLetter(arr[left])) {
                left++;  // Skip letters
            } else if (Character.isLetter(arr[right])) {
                right--; // Skip letters
            } else {
                // Swap non-letters (numbers & special characters)
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }


}
