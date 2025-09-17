package co.sqasa.Steps;

import co.sqasa.pageObjects.Objects;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatepickerSteps extends UIInteractionSteps {

    private static final DateTimeFormatter JQ_FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @Step("Open the datepicker page")
    public void openDatepickerPage() {
        getDriver().get("https://jqueryui.com/datepicker/");
    }

    @Step("Enter the demo iframe")
    public void switchIntoDemoIFrame() {
        WebElement frame = $(Objects.DEMO_IFRAME).waitUntilVisible();
        getDriver().switchTo().frame(frame);
    }

    @Step("Open the calendar")
    public void openCalendar() {
        $(Objects.INPUT_DATE).waitUntilClickable().click();
    }

    @Step("Select day {0}")
    public void selectDay(String day) {
        $(Objects.DAY(day)).waitUntilClickable().click();
    }

    @Step("Go to the next month")
    public void goToNextMonth() {
        $(Objects.BTN_NEXT_MONTH).waitUntilClickable().click();
    }

    @Step("Type '{0}' into the input")
    public void typeManually(String text) {
        $(Objects.INPUT_DATE).clear();
        $(Objects.INPUT_DATE).typeAndEnter(text);
    }

    @Step("Read the input value")
    public String inputValue() {
        return $(Objects.INPUT_DATE).getValue();
    }

    public String expectedToday(String day) {
        LocalDate now = LocalDate.now().withDayOfMonth(Integer.parseInt(day));
        return now.format(JQ_FORMAT);
    }

    public String expectedNextMonth(String day) {
        LocalDate next = LocalDate.now().plusMonths(1).withDayOfMonth(Integer.parseInt(day));
        return next.format(JQ_FORMAT);
    }
}
