Feature: Get All Order {admin}
  as a admin i want to get all oder
  so that i can see my order history

  Scenario: as a admin i can to get all order with valid endpoint
    Given i set API endpoint for get all order with valid endpoint
    When i send request to get all order with valid endpoint
    Then i receive status code 200
    And i receive entire order history

  Scenario: as a admin i cannot to get all order without login token
    Given i set API endpoint for get all order without login token
    When i send request to get all order without login token
    Then i receive status code 401
    And i receive unauthorized message "missing or malformed jwt"