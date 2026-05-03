// src/test/java/tests/TextBoxTest.java
package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    @Test
    void fillTextBoxFormTest() {
        new TextBoxPage()
                .openPage()
                .closeBanners()
                .setFullName("Shak Montan")
                .setEmail("montana90@gmail.ru")
                .setCurrentAddress("001 Haryana Karnal")
                .setPermanentAddress("Same as current")
                .submit()
                .checkOutput(
                        "Shak Montan",
                        "montana90@gmail.ru",
                        "001 Haryana Karnal",
                        "Same as current"
                );
    }
}