@tag2
Feature: Comment in any post
  Scenario Outline: User is try to comment in any post
    Given the use is in main page
    When the user login and he is in the main page and try to comment '<Comment>'
    Then the list of comment will appear
    Examples:
      | Comment                 |
      | nice resipe             |
      | i think ill try it soon |
      | mmmmmmmmmmmm            |

