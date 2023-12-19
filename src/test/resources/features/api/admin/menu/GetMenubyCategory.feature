Feature: Get Menu By Category {Admin}
  as a admin i want to get menu by category
  so that i can get menu by selected category

  Scenario: as a admin i can get menu with exist category
    Given i set API endpoint for get menu by exist category
    When i send request to get menu by exist category
    Then i receive status code 200
    And i receive menu by exist category

  Scenario: as a admin i cannot get menu with invalid category id
    Given i set API endpoint for get menu with invalid category id
    When i send request to get menu with invalid category id
    Then i receive status code 400
    And i receive "invalid category ID" message