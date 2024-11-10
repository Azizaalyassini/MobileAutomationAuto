package utils;

import java.util.Random;

public class RandomUtils {
    public static String generateRandomEmail() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder email = new StringBuilder();
        Random random = new Random();
        while (email.length() < 10) { // Choose your desired length
            int index = (int) (random.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        email.append("@example.com");
        return email.toString();
    }
}
