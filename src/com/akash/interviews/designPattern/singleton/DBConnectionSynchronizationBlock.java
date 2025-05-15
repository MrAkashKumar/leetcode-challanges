package com.akash.interviews.designPattern.singleton;

public class DBConnectionSynchronizationBlock {
    
    private static DBConnectionSynchronizationBlock instance;

    private DBConnectionSynchronizationBlock() {
        /* private constructor to prevent instantiation */
    }

    /* synchronized block to ensure thread safety */
    /* This method is synchronized to ensure that only one thread can access it at a time */
    /* This is a locking mechanism to prevent multiple threads from creating multiple instances */

    /* disadvantage of this approach is that it can lead to performance issues (slow)
     * if multiple threads are trying to access the method at the same time 
     * */
    synchronized public static DBConnectionSynchronizationBlock getInstance() {
        if (instance == null) {
            instance = new DBConnectionSynchronizationBlock();
        }
        return instance;
    }
    /* This method is synchronized to ensure that only one thread can access it at a time */
    /* This is a locking mechanism to prevent multiple threads from creating multiple instances */
    
    public void connect() {
        System.out.println("Connected to the database.");
    }

    public static void main(String[] args) {
        DBConnectionSynchronizationBlock connection = DBConnectionSynchronizationBlock.getInstance();
        connection.connect();
    }
    
}
