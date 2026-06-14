// src/test/java/pages/PracticeFormPage.java
package pages;

import com.codeborne.selenide.SelenideElement;
import components.DatePicker;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class PracticeFormPage {
    private final SelenideElement firstName = $("#firstName"), lastName = $("#lastName"), userEmail = $("#userEmail"), genderFemale = $("#genterWrapper").$(byText("Female")), userNumber = $("#userNumber"), dateOfBirthInput = $("#dateOfBirthInput"), subjectsInput = $("#subjectsInput"), uploadPicture = $("#uploadPicture"), currentAddress = $("#currentAddress"), state = $("#state"), city = $("#city"), submitButton = $("#submit");

    private final DatePicker datePicker = new DatePicker();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage closeBanners() {
        executeJavaScript("document.querySelector('#fixedban')?.remove()");
        executeJavaScript("document.querySelector('footer')?.remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public PracticeFormPage setLastName(String name) {
        lastName.setValue(name);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public PracticeFormPage selectGenderFemale() {
        genderFemale.click();
        return this;
    }

    public PracticeFormPage setMobile(String number) {
        userNumber.setValue(number);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        datePicker.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage addSubject(String subject) {
        subjectsInput.click();
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public PracticeFormPage setStateAndCity(String stateName, String cityName) {
        state.click();
        $(byText(stateName)).click();
        city.click();
        $(byText(cityName)).click();
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}