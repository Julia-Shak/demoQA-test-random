package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.RandomUtils;

public class TextBoxTest extends TestBase {

    RandomUtils randomUtils = new RandomUtils();

    @Test
    void fillTextBoxFormTest() {
        String fullName = randomUtils.getFullName();
        String email = randomUtils.getEmail();
        String currentAddress = randomUtils.getAddress();
        String permanentAddress = randomUtils.getAddress();

        new TextBoxPage()
                .openPage()
                .closeBanners()
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submit()
                .checkOutput(fullName, email, currentAddress, permanentAddress);
    }
}