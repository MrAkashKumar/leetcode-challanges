package com.akash.interviews.immutable;

import java.util.Date;

public class ImmutableWithDate {

    private final String title;
    private final Date launchDate; /* mutable field */

    public ImmutableWithDate(String title, Date launchDate) {
        this.title = title;
        this.launchDate = new Date(launchDate.getTime()); /* defensive copy */ 
    }

    public String getTitle() {
        return title;
    }

    public Date getLaunchDate() {
        return new Date(launchDate.getTime()); /* defensive copy again */ 
    }

    public static void main(String[] args) {
        Date date = new Date();
        ImmutableWithDate emp = new ImmutableWithDate("Akash", date);

        System.out.println("Original: " + emp.getLaunchDate());

        // Try to modify external reference
        date.setTime(0);
        System.out.println("After external mutation: " + emp.getLaunchDate());

        // Try to modify through getter
        emp.getLaunchDate().setTime(0);
        System.out.println("After internal mutation attempt: " + emp.getLaunchDate());

        
    }

    
}