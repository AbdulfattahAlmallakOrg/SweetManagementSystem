@tag1
Feature: Sign up to the system
  Scenario Outline: User SignUp with valid inputs
    Given the user is on sign up page
    When the user enter a valid username '<userName>' and '<password>' and '<email>' and '<location>' and '<role>'
    Then the alert show success signUp
    Examples:
      | userName | password        | email          | location | role    |
      | osamaa    | oossaammaa1234  | os@gmail.com   | nablus   | Admin   |
      | ahmed    | ahmed123        | ahmed@gmail.com| jnien    | Client  |
      | hamoda   | osamaammar      | najwa@gmail.com| nablus   | Admin   |


  Scenario Outline: User SignUp with one of the input empty
    Given the user is on sign up page
    When the user enter an empty username '<userName>' or  '<password>'  or '<location>' or '<email>' or '<role>'
    Then the alert show faile signUp ForEmpty input

    Examples:
      | userName | password        | email          | location | role    |
      | osama    |                 | os@gmail.com   | nablus   | admin   |
      |          | ahmed123        | ahmed@gmail.com| jnien    | Client  |
      | najwa    | naj1234wa       |                | nablus   | admin   |
      | asem     | asemhesham1234  | asem@gmail.com |          | supplier|







  Scenario: User SignUp with exist user name
    Given the user is on sign up page
    When the user enter an exist  username "osama"
    And the user enter a valid password "111"
    And the user enter a valid email "osama@gmail.com"
    And the user enter a valid location "nablus"
    And the user enter a valid role "Admin"
    Then the alert show faile signUp UserName the same


