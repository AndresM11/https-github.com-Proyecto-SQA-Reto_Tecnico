# language: en
@datepicker
Feature: Datepicker on jQuery UI

  Background:
    Given I open the datepicker page
    And I enter the demo iframe

  @scenario1
  Scenario: Select a day in the current month
    When I open the calendar and select day "15" in the current month
    Then the date field should display day "15" of the current month in MM/dd/yy format

  @scenario2
  Scenario: Select a day in the next month
    When I move to the next month and select day "10"
    Then the date field should display day "10" of the next month in MM/dd/yy format

  @scenario3 @negative
  # NOTA: el campo en la pagina es editable
  Scenario: Attempt to edit the field manually
    When I try to type "01/01/2050" in the field
    Then manual editing should not be allowed
