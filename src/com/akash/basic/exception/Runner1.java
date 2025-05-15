package com.akash.basic.exception;

public class Runner1 {

    public static void main(String[] args) {
		try {
			String value = null;
			int number = Integer.parseInt(value); // NumberFormatException
			System.out.println("Number: " + number);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException occurred." + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occurred." + e.getMessage()); // 
		}
	}
    
}
