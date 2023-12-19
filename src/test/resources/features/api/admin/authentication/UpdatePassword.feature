Feature: Update Password {Admin}
  as a admin i want to change password
  so that the password has been changed

  Scenario: as a admin i can update password with valid id
    Given i set API endpoint for update password
    When i send request to update password with valid id
    Then i receive status code 200
    And password has been changed

  Scenario: as a admin i cannot update password with invalid id
    Given i set API endpoint for update password with invalid id
    When i send request to update password with invalid id
    Then i receive status code 500
    And i receive error message "invalid param id"
