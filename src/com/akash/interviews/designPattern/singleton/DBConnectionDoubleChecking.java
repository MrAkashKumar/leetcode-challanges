package com.akash.interviews.designPattern.singleton;

public class DBConnectionDoubleChecking {
    /* Volatile instance variable to ensure visibility and ordering */ 
    private static volatile DBConnectionDoubleChecking instance;

    /* Private constructor to prevent instantiation */ 
    private DBConnectionDoubleChecking() {
        /* Initialize connection resources here */ 
    }
    /* Static method to get the singleton instance */
    /* Double-checked locking to ensure thread safety */
    /* memory issues can occur if the instance is not declared volatile */
    /* ordering issues can occur if the instance is not declared volatile */
    public static DBConnectionDoubleChecking getInstance() {
        if (instance == null) { /* First check (no locking) */ 
            synchronized (DBConnectionDoubleChecking.class) {
                if (instance == null) { /* Second check (with locking) */ 
                    instance = new DBConnectionDoubleChecking();
                }
            }
        }
        return instance;
    }
}