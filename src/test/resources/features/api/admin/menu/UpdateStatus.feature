Feature: Update Status {Admin}
  as a admin i want to update status menu
  so that i can change status from false to true at update menu feature

  Scenario: as a admin i can update status with valid menu id
    Given i set API endpoint for update status with valid menu id
    When i send request to update status with valid menu id
    Then i receive status code 200
    And status is updated

  Scenario: as a admin i cannot update status with invalid menu id
    Given i set API endpoint for update status with invalid menu id
    When i send request to update status with invalid menu id
    Then i receive status code 400
    And i receive "invalid menu ID" message
