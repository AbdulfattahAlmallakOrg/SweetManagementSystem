@tag2
Feature: Filter on recipe needs and allergy
  Scenario Outline: User try to find cake by filter its needs
    Given the user in main page after login
    When click on filter and search by name '<name>'
    Then the list of recipe
    Examples:
      | name                    |
      | blueBarry               |
      | redBarry                |

  Scenario Outline: User try to find cake by filter its needs
    Given the user in main page after login
    When click on filter and search by Allegy '<alg>'
    Then the list of recipe
    Examples:
      | alg              |
      | Wheet            |
      | Egg        |
      | Water  |
