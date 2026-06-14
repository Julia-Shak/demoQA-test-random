package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {

    private final Faker faker = new Faker(new Locale("en"));

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getFullName() {
        return faker.name().fullName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getMobile() {
        return String.valueOf(faker.number().numberBetween(1000000000L, 10000000000L));
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getRandomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String[] getRandomStateAndCity() {
        String[][] statesCities = {
                {"NCR", "Delhi"},
                {"Uttar Pradesh", "Agra"},
                {"Haryana", "Karnal"},
                {"Rajasthan", "Jaipur"}
        };
        return faker.options().option(statesCities);
    }

    public String[] getRandomDateOfBirthParts() {
        int day = faker.number().numberBetween(1, 29);
        String month = faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
        int year = faker.number().numberBetween(1950, 2026);
        return new String[]{String.valueOf(day), month, String.valueOf(year)};
    }
}