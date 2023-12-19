Feature: Get All Menu {user}
  as a user i want to get all menu
  so that i can view the entire menu

  Background:
    Given i set API endpoint for get all menu with valid endpoint

  Scenario: as a user i can get all menu with valid endpoint
    When i send request to get all menu with valid endpoint
    Then i receive status code 200
    And i receive entire menu

  Scenario: as a user i cannot get all menu without login token
    When i send request to get all menu without login token
    Then i receive status code 401
    And i receive unauthorized message "missing or malformed jwt"