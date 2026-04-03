package com.akash.interviews.designPattern.ObjectPool;

/* Runner - how to call dbConnection */
public class Client {
    public static void main(String[] args) {
        DBConnectionPoolManager poolManager =  DBConnectionPoolManager.getInstance();


        DBConnection dbConnection1 = poolManager.getDbConnection();
        DBConnection dbConnection2 = poolManager.getDbConnection();
        DBConnection dbConnection3 = poolManager.getDbConnection();
        DBConnection dbConnection4 = poolManager.getDbConnection();
        DBConnection dbConnection5 = poolManager.getDbConnection();
        DBConnection dbConnection6 = poolManager.getDbConnection();
        poolManager.getDbConnection();
        poolManager.releaseDBConnection(dbConnection6);
        poolManager.releaseDBConnection(dbConnection5);
        poolManager.releaseDBConnection(dbConnection4);
        poolManager.releaseDBConnection(dbConnection3);
        poolManager.releaseDBConnection(dbConnection2);
        poolManager.releaseDBConnection(dbConnection1);
    }
}
