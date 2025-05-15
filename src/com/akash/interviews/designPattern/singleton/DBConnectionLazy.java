package com.akash.interviews.designPattern.singleton;
/*
 * Singleton class
 * Lazy Initialization
 */
public class DBConnectionLazy {
    
    private static DBConnectionLazy dbConnection;

    private DBConnectionLazy(){
        
    }

    /*
        when it is required then create object of DBConnectionLazy
    */
    public static DBConnectionLazy getInstance(){
        if(dbConnection == null){
            dbConnection = new DBConnectionLazy();
        }
        return dbConnection;
    } 

}
