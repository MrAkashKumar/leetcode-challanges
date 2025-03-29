package com.akash.interviews.singleton;

public class Main {
    
    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance();
        System.out.println(dbConnection);
    }
}
