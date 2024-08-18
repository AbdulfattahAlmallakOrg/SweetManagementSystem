Feature: Increase product quantity
  As a store owner or supplier,
  I want to increase the quantity of my products by name
  So that I can update inventory levels

  Scenario: Successfully increase the quantity of a product
    Given a product with name "Product1" exists and belongs to the user
    And the product has a quantity of 10
    When the user increases the product quantity by 5
    Then the product quantity should be 15

  Scenario: Fail to increase the quantity of a product that does not exist
    Given a product with name "NonExistentProduct" does not exist
    When the user tries to increase the product quantity by 5
    Then an invalid name message should be shown

  Scenario: Fail to increase the quantity of a product that does not belong to the user
    Given a product with name "Product2" exists but does not belong to the user
    When the user tries to increase the product quantity by 5
    Then an invalid name message should be shown

  Scenario: Fail to increase the product quantity with a negative number
    Given a product with name "Product1" exists and belongs to the user
    And the product has a quantity of 10
    When the user tries to increase the product quantity by -5
    Then an invalid quantity message should be shown
    And the product quantity should remain unchanged

