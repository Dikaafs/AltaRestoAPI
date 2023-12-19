Feature: Get Menu By ID {user}
  as a user i want to get menu by id
  so that i have spesific menu

  Scenario: as a user i can get menu with valid id
    Given i set API endpoint for get menu with valid id
    When i send request to get menu with valid id
    Then i receive status code 200
    And i receive data menu by valid id

  Scenario: as a admin i cannot get menu with invalid id
    Given i set API endpoint for get menu with invalid id
    When i send request to get menu invalid id
    Then i receive status code 400
    And i receive message "invalid menu ID"