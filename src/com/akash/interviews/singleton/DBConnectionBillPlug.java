package com.akash.interviews.singleton;
/* Bill Pugh Singleton Design Pattern
 * This is a thread-safe singleton implementation using a static inner helper class.
 * The instance of the singleton is created only when it is needed, which is efficient in terms of memory usage.
 * This pattern is also known as the Initialization-on-demand holder idiom.
 */
public class DBConnectionBillPlug {

    private DBConnectionBillPlug() {
        /* private constructor to prevent instantiation */ 
    }
    private static class SingletonHelper {
        private static final DBConnectionBillPlug INSTANCE = new DBConnectionBillPlug();
    }
    public static DBConnectionBillPlug getInstance() {
        return SingletonHelper.INSTANCE;
    }


    /* Example methods to simulate database operations
     * In a real-world scenario, these methods would interact with a database
     *  For demonstration purposes, we will just print messages to the console
     */
    public void initialize() {
        System.out.println("Initializing the database connection.");
    }
    public void initialize(String url, String user, String password) {
        System.out.println("Initializing the database connection with URL: " + url);
        System.out.println("Using user: " + user);
        System.out.println("Using password: " + password);
    }
    public void connect() {
        System.out.println("Connected to the database.");
    }
    public void disconnect() {
        System.out.println("Disconnected from the database.");
    }
    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }
    public void close() {
        System.out.println("Closing the connection.");
    }
    public void commit() {
        System.out.println("Committing the transaction.");
    }
    public void rollback() {
        System.out.println("Rolling back the transaction.");
    }
    public void setAutoCommit(boolean autoCommit) {
        System.out.println("Setting auto-commit to: " + autoCommit);
    }
    public void setTransactionIsolationLevel(int level) {
        System.out.println("Setting transaction isolation level to: " + level);
    }
    public void setReadOnly(boolean readOnly) {
        System.out.println("Setting read-only mode to: " + readOnly);
    }
    public void setNetworkTimeout(int timeout) {
        System.out.println("Setting network timeout to: " + timeout + " milliseconds");
    }
    public void setSchema(String schema) {
        System.out.println("Setting schema to: " + schema);
    }
    public void setCatalog(String catalog) {
        System.out.println("Setting catalog to: " + catalog);
    }
    public void setClientInfo(String name, String value) {
        System.out.println("Setting client info: " + name + " = " + value);
    }  
    

}
