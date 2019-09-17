package net.thucydides.showcase.junit.utils;

import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class Strings {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Strings.class);
    private static Properties appProps = new Properties();

    static {
        try {
            appProps.load(new FileInputStream("text.properties"));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public static String format(String key, Object... value) {
        assertTrue(appProps.containsKey(key));
        return String.format(appProps.getProperty(key), value);
    }

    public static String get(String key) {
        assertTrue("Input String is empty, please check if you passed value in method",
                appProps.containsKey(key));
        return String.valueOf(appProps.get(key));
    }
}
