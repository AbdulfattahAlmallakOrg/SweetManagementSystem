@tag1
Feature: Sign up to the system
  Scenario Outline: User SignUp with valid inputs
    Given the user is on sign up page
    When the user enter a valid username '<userName>'
    And the user enter a valid password '<password>'
    And the user enter a valid email '<email>'
    And the user enter a valid location '<location>'
    And the user enter a valid role '<role>'
    Then the alert show success signUp
    Examples:
      | userName | password        | email          | location | role    |
      | osama    | oossaammaa1234  | os@gmail.com   | nablus   | admin   |
      | ahmed    | ahmed123        | ahmed@gmail.com| jnien    | Client  |
      | najwa    | naj1234wa       | najwa@gmail.com| nablus   | admin   |
      | asem     | asemhesham1234  | asem@gmail.com | nablus   | supplaieyr |




  Scenario: User SignUp with wrong email format
    Given the user is on sign up page
    When the user enter a valid username "osama"
    And the user enter a valid password "oossaammaa1234"
    And the user enter a wrong email "osma email"
    And the user enter a valid location "nablus"
    And the user enter a valid role "Client"
    Then the alert show faile signUp wrong Email format

  Scenario: User SignUp with exist user name
    Given the user is on sign up page
    When the user enter an exist valid username "osama"
    And the user enter a valid password "111"
    And the user enter a valid email "osama@gmail.com"
    And the user enter a valid location "nablus"
    And the user enter a valid role "Admin"
    Then the alert show faile signUp UserName the same

  Scenario Outline: User SignUp with one of the input empty
    Given the user is on sign up page
    When the user enter an empty username '<userName>' or  '<password>' or '<role>' or '<location>'or'<email>'
    Then the alert show faile signUp ForEmpty input

    Examples:
      | userName | password        | email          | location | role    |
      | osama    |                 | os@gmail.com   | nablus   | admin   |
      |          | ahmed123        | ahmed@gmail.com| jnien    | Client  |
      | najwa    | naj1234wa       |                | nablus   | admin   |
      | asem     | asemhesham1234  | asem@gmail.com |          | supplier|


