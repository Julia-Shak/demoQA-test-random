// src/test/java/components/DatePicker.java
package components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DatePicker {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day")
                .filter(visible)
                .filter(not(cssClass("react-datepicker__day--outside-month")))                .findBy(text(day))
                .click();
    }
}