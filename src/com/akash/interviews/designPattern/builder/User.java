package com.akash.interviews.designPattern.builder;

public class User {
    private String name;
    private String username;
    private String email;
    private String phone;

     /* ✅ Private constructor — only builder can build this */ 
    private User(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.name = builder.name;
    }

    /* ✅ Static inner Builder class  */ 
    public static class Builder {
        
        private final String email; /* Required  */

        private String username; /* optional  */
        private String phone; /*/ optional */
        private String name; /* optional  */

        public Builder(String email) {
            this.email = email;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }


        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
        
}
