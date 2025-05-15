package com.akash.interviews.designPattern.command;

public class DeleteProfileCommand implements CommandApp{
    
    private final ProfileService service;
    private final String username;

    public DeleteProfileCommand(ProfileService service, String username) {
        this.service = service;
        this.username = username;
    }

    public void execute() {
        service.deleteProfile(username);
    }
}
