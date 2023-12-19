Feature: Update Password {User}
  as a user i want to change password
  so that i can make sure my acc is safe

  Scenario: as a user i can update password with valid input
    Given i set API endpoint for update password user
    When i send request to update password with valid input
    Then i receive status code 200
    And password user has been changed