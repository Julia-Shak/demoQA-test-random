// src/test/java/tests/PracticeFormTest.java
package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.RandomUtils;
import components.ResultModal;

public class PracticeFormTest extends TestBase {

    @Test
    void fillPracticeFormWithRandomDataTest() {
        String firstName = RandomUtils.getFirstName();
        String lastName = RandomUtils.getLastName();
        String email = RandomUtils.getEmail();
        String mobile = RandomUtils.getMobile();
        String address = RandomUtils.getAddress();
        String hobby = RandomUtils.getRandomHobby();
        String[] stateCity = RandomUtils.getRandomStateAndCity();
        String state = stateCity[0];
        String city = stateCity[1];
        String[] dob = RandomUtils.getRandomDateOfBirthParts();

        new PracticeFormPage()
                .openPage()
                .closeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGenderFemale()
                .setMobile(mobile)
                .setDateOfBirth(dob[0], dob[1], dob[2])
                .addSubject("English")
                .selectHobby(hobby)
                .uploadPicture("img/1.png")
                .setAddress(address)
                .setStateAndCity(state, city)
                .submit();

        new ResultModal()
                .checkField("Student Name", firstName + " " + lastName)
                .checkField("Student Email", email)
                .checkField("Gender", "Female")
                .checkField("Mobile", mobile)
                .checkStateAndCity(state + " " + city)
                .close();
    }
}