Feature: Update Item {user}
  as a user i want to update quantity
  so that i can add or remove quantity item

  Background:
    Given i set API endpoint for update item

  Scenario: as a user i can update item with valid input
    When i send request to update item with valid input
    Then i receive status code 200
    And i receive valid data updated item

  Scenario: as a user i cannot update item with invalid input
    When i send request to update item with invalid input
    Then i receive status code 400
    And i receive "error when parsing data" message