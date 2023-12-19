Feature: GetMenuByName {Admin}
  as a admin i want to get menu by name
  so that i can sortir menu by name

  Scenario: as a admin i can get menu by name
    Given i set API endpoint for get menu by name
    When i send request to get menu by name
    Then i receive status code 200
    And i receive valid data menu by name

  Scenario: as a admin i cannot get menu by uncreated Name
    Given i set API endpoint for get menu uncreated Name
    When i send request to get menu uncreated Name
    Then i receive status code 404
    And i receive message "menu not found"