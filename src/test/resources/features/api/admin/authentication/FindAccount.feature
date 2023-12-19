Feature: find acc user {Admin}
  as a admin i want to find acc user
  so that i knew the user information

  Scenario: as a admin i can find acc user with valid token
    Given i set API endpoint for find acc user
    When i send request to find acc user
    Then i receive status code 200
    And i receive valid data user acc