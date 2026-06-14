package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import utils.RandomUtils;
import components.ResultModal;

public class PracticeFormTest extends TestBase {

    RandomUtils randomUtils = new RandomUtils();

    @Test
    void fillPracticeFormWithRandomDataTest() {
        String firstName = randomUtils.getFirstName();
        String lastName = randomUtils.getLastName();
        String email = randomUtils.getEmail();
        String mobile = randomUtils.getMobile();
        String address = randomUtils.getAddress();
        String hobby = randomUtils.getRandomHobby();
        String[] stateCity = randomUtils.getRandomStateAndCity();
        String state = stateCity[0];
        String city = stateCity[1];
        String[] dob = randomUtils.getRandomDateOfBirthParts();

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