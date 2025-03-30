package com.akash.interviews.singleton;
/*
 * Singleton class
 * Eager Initialization
 */
public class DBConnection {

                        /* Eager Initialization Approach */
    /*
     * static keyword is useful for load object once initialise class
     */
    private static DBConnection connection = new DBConnection();

    /*
     * can't create object that's why I have taken private constructor
     */
    private DBConnection(){

    }

    public static DBConnection getInstance(){
        return connection;
    }

}





