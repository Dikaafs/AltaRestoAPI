Feature: Update Order Status {Admin}
  as a admin i want to update order status
  so that status order is updated

  Scenario: as a admin i can update order status with valid input
    Given i set API endpoint for update order status with valid input
    When i send request to update order status with valid input
    Then i receive status code 200
    And i receive success message "successfully update status order"