package co.sqasa.StepDef;

import co.sqasa.Steps.DatepickerSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import org.assertj.core.api.Assertions;

public class TestStepDefinition {

    @Steps
    DatepickerSteps datepicker;

    @Given("I open the datepicker page")
    public void open_demo_page() {
        datepicker.openDatepickerPage();
    }

    @And("I enter the demo iframe")
    public void enter_iframe() {
        datepicker.switchIntoDemoIFrame();
    }

    // Scenario 1
    @When("I open the calendar and select day {string} in the current month")
    public void select_today(String day) {
        datepicker.openCalendar();
        datepicker.selectDay(day);
    }

    // import io.cucumber.java.en.Then;  // <- asegúrate de usar este import, no otro

    @Then("^the date field should display day \"([^\"]+)\" of the current month in MM\\/dd\\/yy format$")
    public void assert_today(String day) {
        String expected = datepicker.expectedToday(day);
        org.assertj.core.api.Assertions.assertThat(datepicker.inputValue()).isEqualTo(expected);
    }




    // Scenario 2
    @When("I move to the next month and select day {string}")
    public void select_next_month(String day) {
        datepicker.openCalendar();
        datepicker.goToNextMonth();
        datepicker.selectDay(day);
    }

    @Then("^the date field should display day \"([^\"]+)\" of the next month in MM\\/dd\\/yy format$")
    public void assert_next_month(String day) {
        String expected = datepicker.expectedNextMonth(day);
        org.assertj.core.api.Assertions.assertThat(datepicker.inputValue()).isEqualTo(expected);
    }

    // Scenario 3 (negative)
    @When("I try to type {string} in the field")
    public void type_manually(String text) {
        datepicker.openCalendar();
        datepicker.typeManually(text);
    }

    @Then("^manual editing should not be allowed$")
    public void assert_manual_not_allowed() {
        String value = datepicker.inputValue();

        // Si el campo permite escribir, esta aserción FALLA → escenario rojo en Serenity
        org.assertj.core.api.Assertions.assertThat(value)
                .as("Expected the input to be readonly (no manual typing allowed)")
                .isNullOrEmpty();
    }
}
