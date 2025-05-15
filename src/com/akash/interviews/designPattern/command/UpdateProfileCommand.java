package com.akash.interviews.designPattern.command;

public class UpdateProfileCommand implements CommandApp{

    private final ProfileService service;
    private final String username;

    public UpdateProfileCommand(ProfileService service, String username) {
        this.service = service;
        this.username = username;
    }

    public void execute() {
        service.updateProfile(username);
    }
    
}
