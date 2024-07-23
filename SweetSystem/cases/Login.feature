Feature: Login into the system

  Scenario: Valid Login with correct information
    Given the user is on the login page
    When the user enters "validUsername" in the username field
    And the user enters "validPassword" in the password field
    And the user clicks the login button
    Then the user should be on the main page

  Scenario: Valid Login with empty values
    Given the user is on the login page
    When the user clicks on the 'Login' button
    Then the field 'Username' should show an error
    And the field 'Password' should show an error

  Scenario Outline: Invalid Login with incorrect information
    Given the user is on the login page
    When the user fills 'username' with '<Username>'
    And the user fills 'password' with '<Password>'
    And the user clicks on the 'Login' button
    Then the user should see an alert message '<alert>'

    Examples:
      | Username | Password  | alert              |
      | osama    | osamaammar| Invalid credentials|
      | Ahmed    | aaa123    | Invalid credentials|
      | osama    | oossaammaa| Invalid credentials|