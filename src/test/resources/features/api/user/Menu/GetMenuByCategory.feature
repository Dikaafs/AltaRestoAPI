Feature: Get Menu By Category {user}
  as a user i want to get menu by category
  so that i can get menu by selected category

  Scenario: as a user i can get menu with exist category
    Given i set API endpoint for get menu with exist category
    When i send request to get menu with exist category
    Then i receive status code 200
    And i receive menu by category
    
  Scenario: as a user i cannot get menu without input id category on the endpoint 
    Given i set API endpoint for get menu without input id category on the endpoint
    When i send request to get menu without input id category on the endpoint
    Then i receive status code 400
    And i receive "invalid menu ID" message

