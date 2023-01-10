Feature: Testing a different request on store
  Scenario: As a user I want to create store
    When As a User I create a store
    Then User must get a valid response 201

  Scenario: As a user I want to get created product with productId
    When I get store with storeId
    And  I must get back a valid response

  Scenario: As a user I want to update the product with productId
    When I update store with storeId
    Then I must get back again valid response

  Scenario: As a user I want to delete the product
    When I delete store with storeId
    And  I check store is deleted