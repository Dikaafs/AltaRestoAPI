Feature: Get Menu By Name {user}
  as a user i want to get menu by name
  so that i can sortir menu by name

  Scenario: as a user i can get menu with exist name
    Given i set API endpoint for get menu with exist name
    When i send request to get menu with exist name
    Then i receive status code 200
    And i receive valid data for get menu by name

  Scenario: as a admin i cannot get menu by uncreated Name
    Given i set API endpoint for get menu uncreated Name
    When i send request to get menu uncreated Name
    Then i receive status code 404
    And i receive message "menu not found"