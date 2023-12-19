Feature: Get all Menu {Admin}
  as a admin i want to get all menu
  so that i can view entire data of menu

  Scenario: as a admin i can get all menu with valid endpoint
    Given i set API endpoint for get all menu
    When i send request to get all menu
    Then i receive status code 200
    And i receive valid data all menu

  Scenario: as a admin i cannot get all menu without login token
    Given i set API endpoint for get all menu
    When i send request to get all menu without login token
    Then i receive status code 401
    And i receive unauthorized message "missing or malformed jwt"