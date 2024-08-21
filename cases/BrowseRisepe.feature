@tag2
Feature:Brows Resipes and Products
  Scenario: user enter the main page after login
    Given user in main page
    When User want to browse resipe click in resipe btn "btn"
    Then all posts will appear with there  info

  Scenario: user enter the main page after login
    Given user in main page
    When User want to browse product click in product btn "btn"
    Then all Products will appear with there  info


