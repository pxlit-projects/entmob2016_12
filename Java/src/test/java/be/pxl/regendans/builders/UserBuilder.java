package be.pxl.regendans.builders;

import be.pxl.regendans.entity.User;

public class UserBuilder {
    private String username;
    private String password;
    private int id;
    public static UserBuilder user() {
        return new UserBuilder();
    }


    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(username, password);
    }
}