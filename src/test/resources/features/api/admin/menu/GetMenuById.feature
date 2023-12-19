Feature: Get Menu By ID {Admin}
  as a user i want to get menu by id
  so that i can sortir menu that i want to see

  Scenario: as a admin i can get menu with valid id
    Given i set API endpoint for get menu valid id
    When i send request to get menu valid id
    Then i receive status code 200
    And i receive valid data menu by id
    
  Scenario: as a admin i cannot get menu with invalid id
    Given i set API endpoint for get menu with invalid id
    When i send request to get menu invalid id
    Then i receive status code 400
    And i receive message "invalid menu ID"