Feature: Delete {Admin}
  as a admin i want to delete account
  so the account can be removed

  Scenario: as a admin i can delete account with valid id
    Given i set API endpoint for delete account with valid id
    When i send request to delete account with valid id
    Then i receive status code 200
    And i receive message "Successfully deleted"

  Scenario: as a admin i cannot delete account with invalid id
    Given i set API endpoint for delete account with invalid id
    When i send request to delete account with invalid id
    Then i receive status code 500
    And i receive message "invalid param id"

