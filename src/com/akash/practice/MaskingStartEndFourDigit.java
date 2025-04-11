package com.akash.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * mask start end before and after four digit
 */
public class MaskingStartEndFourDigit {

    public static void main(String[] args) {
        
        String str = "1234567890123456";
        maskingStartAndEndFourDigit(str);
        maskStartAndEndTillBeforeFourDigit(str);
        maskStringEndAndStart(str);

    }

    /*
     * 
     */
    private static void maskingStartAndEndFourDigit(String str){

        if(str == null || str.length() < 8){
            System.out.println("Input should be at least 8 characters long.");
            return;
        }

        String response = String.format("%s%s%s", "XXXX", str.substring(4, str.length()-4), "XXXX");
        
        System.out.println(response);
    }

    /*
     * 
     */
    private static void maskStartAndEndTillBeforeFourDigit(String str){

        if (str == null || str.length() < 8) {
            System.out.println("Input should be at least 8 characters long.");
            return;
        }

        Pattern pattern = Pattern.compile("^(.{4})(.*)(.{4})$");
        Matcher matcher = pattern.matcher(str);
        
        if (matcher.matches()) {
            String masked = "XXXX" + matcher.group(2) + "xxxx";
            System.out.println(masked);
        }
    }

    /*
     * 
     */
    public static void maskStringEndAndStart(String str) {
        if (str == null || str.length() < 8) {
            System.out.println("Input should be at least 8 characters long.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("X".repeat(4)); /* Mask first 4 characters */ 
        sb.append(str.substring(4, str.length() - 4)); /* Append visible middle part */ 
        sb.append("x".repeat(4)); /* Mask last 4 characters */ 

        System.out.println(sb.toString());
    }

    
}
