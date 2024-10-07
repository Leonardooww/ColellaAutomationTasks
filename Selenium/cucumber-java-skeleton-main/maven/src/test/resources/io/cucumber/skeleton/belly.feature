Feature: User Registration

  Scenario: Successful User Registration
    Given the user is on the registration page
    When the user fills in the registration form
    And submits the form
    Then the user should be registered successfully

  Scenario: Register with missing required fields
    Given the user is on the registration page for missing fields
    When the user leaves some fields empty
    And submits the form with missing fields
    Then an error message should be displayed for the missing fields
