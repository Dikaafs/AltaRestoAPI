Feature: Get Order By Id {user}
  as a user i want to get order by id
  so that i get spesific data order

  Scenario: as a user i can get order with valid id
    Given i set API endpoint for get order with valid id
    When i send Request to get order with valid id
    Then i receive status code 200
    And i receive data order from valid id

  Scenario: as a user i cannot get order with invalid id
    Given i set API endpoint for get order with invalid id
    When i send request to get order with invalid id
    Then i receive status code 404
    And i receive error message "order not found"