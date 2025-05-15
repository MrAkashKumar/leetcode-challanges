package com.akash.interviews.designPattern.command;

public class Runner {
    
    /*
     * Command Design Pattern — a powerful behavioral design pattern
     * The Command Pattern turns a request into a stand-alone object that contains all the information about the request. 
     * This lets you parameterize methods, delay execution, and support undoable operations.
     */

    public static void main(String[] args) {

        ProfileService service = new ProfileService();

        CommandApp createCmd = new CreateProfileCommand(service, "akash");
        CommandApp updateCmd = new UpdateProfileCommand(service, "akash");
        CommandApp deleteCmd = new DeleteProfileCommand(service, "akash");

        CommandExecutor executor = new CommandExecutor();

        executor.run(createCmd);  // 👤 Created profile for: akash
        executor.run(updateCmd);  // ✏️ Updated profile for: akash
        executor.run(deleteCmd);  // 🗑️ Deleted profile for: akash

        

        
    }
}
