package com.akash.interviews.designPattern.builder;

public class Runner {

    /*
     * Builder Pattern is used to create complex objects with many optional parameters, 
     * without needing a telescoping constructor (i.e., a constructor with many parameters).
     */

    public static void main(String[] args) {
        
        User user1 = new User.Builder("akash@email.com")
                        .phone("9876543210")
                        .name("Akash")
                        .username("akash")
                        .build();

        User user2 = new User.Builder( "rahul@email.com")
                        .build();

        System.out.println("User1: " + user1.getUsername() + ", " + user1.getPhone());
        System.out.println("User2: " + user2.getUsername() + ", " + user2.getPhone());
    }
    
    
}
