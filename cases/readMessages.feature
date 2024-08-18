Feature: Read unread messages
  As a store owner or supplier,
  I want to read my unread messages
  So that I can process them

  Scenario: Successfully read all unread messages
    Given a receiver with ID 1 exists
    And the receiver has 3 unread messages
    And the messages are "Message 1", "Message 2", and "Message 3"
    When the receiver reads all unread messages
    Then all unread messages should be moved to the read messages list
    And the read messages list should contain "Message 1", "Message 2", and "Message 3"
    And the unread messages list should be empty

  Scenario: Read messages when there are no unread messages
    Given a receiver with ID 2 exists
    And the receiver has no unread messages
    When the receiver reads all unread messages
    Then the read messages list should remain empty
    And the unread messages list should remain empty