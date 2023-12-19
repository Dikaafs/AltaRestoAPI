Feature: Update Menu {Admin}
  as a admin i want to update menu
  so that the menu is updated

  Scenario: as a admin i can update menu with valid input
    Given i set API endpoint for update menu
    When i send request to update menu with valid input
    Then i receive status code 200
    And i receive valid data for updated menu

  Scenario: as a admin i cannot update menu with invalid input
    When i send request to update menu with invalid input
    Then i receive status code 400
    And i receive message "error when parsing data"