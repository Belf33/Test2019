package net.thucydides.showcase.junit.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ValidUser {

    private static Properties prop = new Properties();

    public String email;
    public String password;

    public ValidUser() {

        try {
            loadValidUserFromProp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadValidUserFromProp() throws IOException {
        prop.load(new FileInputStream("env.properties"));

        email = prop.getProperty("email");
        password = prop.getProperty("password");
    }
}
