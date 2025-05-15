package com.akash.interviews.designPattern.command;

public class CreateProfileCommand implements CommandApp{

    private final ProfileService service;
    private final String username;

    public CreateProfileCommand(ProfileService service, String username) {
        this.service = service;
        this.username = username;
    }

    public void execute() {
        service.createProfile(username);
    }
    
}
