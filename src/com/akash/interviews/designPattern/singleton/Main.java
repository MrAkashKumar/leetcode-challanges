package com.akash.interviews.designPattern.singleton;

public class Main {
    
    public static void main(String[] args) {
        DBConnectionEager dbConnection = DBConnectionEager.getInstance();
        System.out.println(dbConnection);
    }
}
