Feature: Request an order from a supplier

  As a store owner,
  I want to request an order from a supplier
  So that I can replenish my inventory

  Scenario: Successfully placing an order with a valid supplier
    Given I have a supplier with ID 100 and a product with ID 200
    When I request an order of 50 units for product 200 from supplier 100
    Then the order should be placed successfully
    And the order status should be "pending"

  Scenario: Trying to place an order with an invalid supplier
    Given I have a product with ID 200
    And supplier ID 101 is not a valid supplier
    When I request an order of 20 units for product 200 from supplier 101
    Then the system should print "NOT_AN_INSTANCE_MESSAGE"

  Scenario: Placing an order with a non-supplier owner
    Given I have an owner with ID 102 who is not a supplier
    And I have a product with ID 200
    When I request an order of 30 units for product 200 from owner 102
    Then the system should print "NOT_AN_INSTANCE_MESSAGE"

  Scenario: Placing an order with zero quantity
    Given I have a supplier with ID 100 and a product with ID 200
    When I request an order of 0 units for product 200 from supplier 100
    Then the order should be placed successfully
    And the order status should be "pending"
