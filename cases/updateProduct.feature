Feature: Update product details
  As a store owner or supplier,
  I want to update my product details by name
  So that I can keep my product information accurate

  Scenario: Successfully update a product with valid data
    Given a product with name "Product1" exists and belongs to the user
    When the user updates the product with name "Product1", description "Updated description", price 100.00, and quantity 10
    Then the product should be updated successfully

  Scenario: Fail to update a product with a negative price
    Given a product with name "Product1" exists and belongs to the user
    When the user updates the product with name "Product1", description "Updated description", price -50.00, and quantity 10
    Then an invalid price message should be shown

  Scenario: Fail to update a product with a negative quantity
    Given a product with name "Product1" exists and belongs to the user
    When the user updates the product with name "Product1", description "Updated description", price 100.00, and quantity -5
    Then an invalid quantity message should be shown

  Scenario: Fail to update a product that does not belong to the user
    Given a product with name "Product2" exists but does not belong to the user
    When the user tries to update the product with name "Product2", description "Updated description", price 100.00, and quantity 10
    Then an invalid name message should be shown

  Scenario: Fail to update a product that does not exist
    Given a product with name "NonExistentProduct" does not exist
    When the user tries to update the product with name "NonExistentProduct", description "Updated description", price 100.00, and quantity 10
    Then an invalid name message should be shown
