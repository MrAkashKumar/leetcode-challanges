package com.akash.leetcode;

import java.security.SecureRandom;

public class RandomUniqueAlphaNumbericNumber {

    private static final String alphaNumbericValue= "ABCDEFGHIJKLMNOPQRSTUVWXYZ12344567890abcdefghijklmnopqrstuvwxyz";
    
    public static void main(String[] args) {
        generate15RandomUnique();
    }

    private static void generate15RandomUnique(){
        
        StringBuilder sb = new StringBuilder();
        SecureRandom secure = new SecureRandom();
        for(int i= 0; i<15; i++){
            int index = secure.nextInt(alphaNumbericValue.length());
            sb.append(alphaNumbericValue.charAt(index));
        }
        System.out.println(sb.toString());
    }


}
