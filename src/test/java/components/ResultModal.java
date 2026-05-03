// src/test/java/components/ResultModal.java
package components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

public class ResultModal {
    public ResultModal checkField(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
        return this;
    }

    public ResultModal checkStateAndCity(String stateAndCity) {
        $(".table-responsive").$(byText("State and City")).closest("tr")
                .shouldHave(text(stateAndCity));
        return this;
    }

    public void close() {
        $("#closeLargeModal").click();
    }
}