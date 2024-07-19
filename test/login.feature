Feature: Login

  # The first example has two steps
  Scenario: Valid login
    When User enter email "aaaaa@hotmail.com"
    And User enter password "88888888"
    Then User logged in succefuly

  # The second example has three steps
  Scenario: Invalid login
    When User enter email "bbbbb@hotmail.com"
    And User enter password "77777777"
    Then User log in failed