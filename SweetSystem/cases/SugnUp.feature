Feature: Sign up to the system
  Scenario Outline: User SignUp
    Given the user is on sign up page
    When the user enter a valid username '<userName>'
    And the user enter a valid password '<password>'
    And the user enter a valid email '<email>'
    And the user enter a valid location '<location>'
    And the user enter a valid role '<role>'
    Examples:
      |userName|password|email|location|role|
      |"osama"|"oossaammaa1234"|"os@gmail.com"|"nablus"|"admin"|
      |"ahmed"|"ahmed123"|"ahmed@gmail.com"|"jnien"|"Client"|
      |"najwa"|"naj1234wa"|"najwa@gmail.com"|"nablus"|"admin"|
      |"asem"|"asemhesham1234"|"asem@gmail.com"|"nablus"|"supplaieyr"|

  Scenario: sign up with invalid email fromat
    Given the user is on sign up page
    When the user provide invalid email format
    Then the system will display erorr message

  Scenario: sign up with missing any data
    Given the user is on sign up page
    When the user miss any info
    Then the system will display erorr message


