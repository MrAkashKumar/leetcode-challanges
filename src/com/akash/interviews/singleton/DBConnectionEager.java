package com.akash.interviews.singleton;
/*
 * Singleton class
 * Eager Initialization
 */
public class DBConnectionEager {

                        /* Eager Initialization Approach */
    /*
     * static keyword is useful for load object once initialise class
     */
    private static DBConnectionEager connection = new DBConnectionEager();

    /*
     * can't create object that's why I have taken private constructor
     */
    private DBConnectionEager(){

    }

    public static DBConnectionEager getInstance(){
        return connection;
    }

}





