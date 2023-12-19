Feature: Create Order {user}
  as a user i want to create order
  so that i can for the food

  Scenario: as a user i can create order with valid menu id
    Given i set API endpoint for create order with valid menu id
    When i send request to create order with valid menu id
    Then i receive status code 201
    And i receive valid data my order

  Scenario: as a user i cannot create order with no exist menu id
    Given i set API endpoint for create order with no exist menu id
    When i send request to create order with no exist menu id
    Then i receive status code 500
    And i receive error message "creating error"

  Scenario: as a user i cannot create order with empty field
    Given i set API endpoint for create order with empty field
    When i send request to create order with empty field
    Then i receive status code 400
    And i receive error message "error when parsing data"