package com.akash.interviews.designPattern.command;

public class ProfileService {
    public void createProfile(String username) {
        System.out.println("👤 Created profile for: " + username);
    }

    public void updateProfile(String username) {
        System.out.println("✏️ Updated profile for: " + username);
    }

    public void deleteProfile(String username) {
        System.out.println("🗑️ Deleted profile for: " + username);
    }
    
}
