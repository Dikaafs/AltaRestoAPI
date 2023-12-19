Feature: Get Order By Id {admin}
  as a admin i want to get order by id
  so that i get spesific data order

  Scenario: as a admin i can get order with valid id
    Given i set API endpoint for get order with valid id
    When i send Request to get order with valid id
    Then i receive status code 200
    And i receive data order from valid id

  Scenario: as a admin i cannot get order with invalid id
    Given i set API endpoint for get order with invalid id
    When i send request to get order with invalid id
    Then i receive status code 404
    And i receive error message "order not found"