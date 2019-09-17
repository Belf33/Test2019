package net.thucydides.showcase.junit.utils;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

public class Helpers {
    private static Properties prop = new Properties();

    public static String validEmail;
    public static String validPassword;

    public static void loadValidUserFromProp() throws IOException {
        prop.load(new FileInputStream(""));

        validEmail = prop.getProperty("email");
        validPassword = prop.getProperty("password");
    }

    public static int getRandomNumberInRange(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }

    public static String getUniqueId() {
        return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5),
                String.valueOf(System.currentTimeMillis() / 1000));
    }

    public static String getAlphabeticalRandomString(int length) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        while (randomString.length() <= length) {
            int index = (int) (random.nextFloat() * letters.length());
            randomString.append(letters.charAt(index));
        }

        return randomString.toString();
    }

    public static String getAlphanumericRandomString(int length) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        String letters = "abcdefghijklmnopqrstuvwxyz1234567890";

        while (randomString.length() <= length) {
            int index = (int) (random.nextFloat() * letters.length());
            randomString.append(letters.charAt(index));
        }

        return randomString.toString();
    }

    public static String generateEmail(String domain) {
        return String.format("%s@%s", getUniqueId(), domain);
    }

    /**
     * Waits for "true" result.
     */
    public static void waitFor(int sec, Supplier<Boolean> check, String message) {
        waitForResult(sec, () -> check.get(), b -> b, message);
    }

    /**
     * Waits for result meeting condition
     */
    public static <T> T waitForResult(int sec, Supplier<T> producer, Function<T, Boolean> check, String message) {
        long end = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(sec);

        while (true) {
            T result = producer.get();

            if (check.apply(result)) {
                return result;
            }

            if (System.currentTimeMillis() > end) {
                Assert.fail(String.format("%s (waited %s sec, latest result is %s)", message, sec, result));
            }

            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(sec / 10));
            } catch (InterruptedException e) {
                Assert.fail(e.getMessage());
            }
        }
    }

}
