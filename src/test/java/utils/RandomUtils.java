// src/test/java/utils/RandomUtils.java
package utils;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Random;

public class RandomUtils {
    private static final Faker faker = new Faker(new Locale("en"));
    private static final Random random = new Random();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getMobile() {
        return String.valueOf(1000000000L + random.nextLong(9000000000L));
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[random.nextInt(hobbies.length)];
    }

    public static String[] getRandomStateAndCity() {
        String[][] statesCities = {
                {"NCR", "Delhi"},
                {"Uttar Pradesh", "Agra"},
                {"Haryana", "Karnal"},
                {"Rajasthan", "Jaipur"}
        };
        return statesCities[random.nextInt(statesCities.length)];
    }

    // Генерирует [day, month, year] — без вызова faker.number()
    public static String[] getRandomDateOfBirthParts() {
        int day = random.nextInt(28) + 1;
        String month = faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        int year = 1950 + random.nextInt(76);
        return new String[]{String.valueOf(day), month, String.valueOf(year)};
    }
}