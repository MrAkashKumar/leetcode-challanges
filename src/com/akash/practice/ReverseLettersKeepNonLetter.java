package com.akash.practice;
/*
 * @author Akash Kumar
 */
public class ReverseLettersKeepNonLetter {
    
    public static void main(String[] args) {
        String input = "a1b!c-d@e2";  
        String result = reverseLetters(input);
        System.out.println("Reversed: " + result);  
    }

    /*
     * reverse letter and keep non-letter 
     */
    public static String reverseLetters(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;
    
        while (left < right) {
            if (!Character.isLetter(arr[left])) {
                left++;  // Skip non-letters
            } else if (!Character.isLetter(arr[right])) {
                right--; // Skip non-letters
            } else {
                // Swap letters
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
