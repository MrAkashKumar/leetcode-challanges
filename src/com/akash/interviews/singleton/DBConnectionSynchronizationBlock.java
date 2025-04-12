package com.akash.interviews.singleton;

public class DBConnectionSynchronizationBlock {
    // Singleton instance
    // Using double-checked locking for thread-safe singleton instance creation
    // This ensures that the instance is created only when needed and is thread-safe
    // without the overhead of synchronization on every access
    // This is a lazy initialization approach
    // The instance is declared as volatile to ensure visibility across threads
    private static DBConnectionSynchronizationBlock instance;

    private DBConnectionSynchronizationBlock() {
        // private constructor to prevent instantiation
    }

    public static DBConnectionSynchronizationBlock getInstance() {
        if (instance == null) {
            synchronized (DBConnectionSynchronizationBlock.class) {
                if (instance == null) {
                    instance = new DBConnectionSynchronizationBlock();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }

    public static void main(String[] args) {
        DBConnectionSynchronizationBlock connection = DBConnectionSynchronizationBlock.getInstance();
        connection.connect();
    }
    
}
