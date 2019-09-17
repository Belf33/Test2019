package net.thucydides.showcase.junit.model;

import net.thucydides.showcase.junit.utils.Helpers;

public class UserModel {

    private String email;
    private String password;

    public UserModel() {
        this.email = Helpers.generateEmail("test");
        this.password = Helpers.getAlphanumericRandomString(10);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
