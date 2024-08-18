@tag2
Feature: post a comment on recipe
  Scenario Outline: User try to comment on post
    Given the user is main page
    When the user enter a Comment '<comment>'
    Then the comment posted
    Examples:
      | comment       |
      | ill try this  |
      | good recipe   |
      | nice ..!      |
      | good ..!      |
