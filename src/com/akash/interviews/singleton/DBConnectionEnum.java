package com.akash.interviews.singleton;
/* singleton enum example
 * 
 * This is a singleton class that uses an enum to ensure that only one instance of the class is created.
 * The enum has a single instance, which is created when the enum is loaded.
 * The getInstance() method returns the single instance of the class.
 * 
 * This approach is thread-safe and prevents multiple instances from being created.
 */
public enum DBConnectionEnum {
    /* solve by only one JVM instance
     * 
     * The enum is loaded only once, so the instance is created only once.
     * This ensures that only one instance of the class is created, even in a multi-threaded environment.
     */
    INSTANCE;

    /* Add any instance variables or methods here */ 
    private String connectionString;

    public String getConnectionString() {
        return connectionString;
    }
    

}
