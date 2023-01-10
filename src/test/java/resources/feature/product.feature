Feature: Testing a different request on product

Scenario: As a user I want to create product
  When As a User I create a product
  Then User must get back a valid response 201

  Scenario: As a user I want to get created product with productId
    When I get product with productId
    And  I must get back a valid response 200

    Scenario: As a user I want to update the product with productId
      When I update product with productId
      Then I must get back a again valid response 200

      Scenario: As a user I want to delete the product
        When I delete product with productId
        And  I check prodct is deleted