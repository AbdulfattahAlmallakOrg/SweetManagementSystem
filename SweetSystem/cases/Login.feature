@tag2
Feature: User login to the system

  Scenario Outline: User login with valid username and password
    Given the user is on the login page
    When the user enters a valid username "<username>" and a valid password "<password>"
    And clicks the login button
    Then the user is successfully logged in

    Examples:
      | username | password   |
      | osama    | 1234       |
      | ahmed    | ah123      |
      | smsm     | 1234       |


  Scenario Outline: User login with invalid username
    Given the user is on the login page
    When the user enters an invalid username "<username>"
    And clicks the login button2
    Then the login attempt fails with an error message
    Examples:
      | username |
      | abood    |
      | batekha  |


  Scenario: User login with invalid password
    Given the user is on the login page
    When the user enters an invalid password "<password>"
    And clicks the login button3
    Then the login attempt fails with an error pass message



  Scenario: User login with missing username or password
    Given the user is on the login page
    When the user leaves the username field empty and enters a password "password1"or empty pass with valid username"osama"
    And clicks the login button4
    Then the login attempt fails with an error message for missing username



