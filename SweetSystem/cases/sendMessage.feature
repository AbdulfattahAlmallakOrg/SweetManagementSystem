Feature: Send a message to another user
  As a user
  I want to send a message to another user
  So that I can communicate with them

  Scenario: Successfully send a message to an existing user
    Given a user with ID 1 exists
    And a receiver with ID 2 exists
    And the receiver is an owner or supplier
    When the user sends a message "Hello!" to receiver with ID 2
    Then the message should be added to the user's sent messages
    And the message should be received by the receiver
    And the method should return 0

  Scenario: Fail to send a message to a non-existent receiver
    Given a user with ID 1 exists
    And a receiver with ID 3 does not exist
    When the user sends a message "Hello!" to receiver with ID 3
    Then the method should return 1
    And the message should not be added to the user's sent messages
