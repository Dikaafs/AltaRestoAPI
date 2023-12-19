Feature: Create Payment {user}
  as a user i want to create payment
  so that i can checkout my order

  Background:
    Given i set API endpoint for create payment

  Scenario: as a user i can create payment with valid order id
    When i send request to create payment with valid order id
    Then i receive status code 201
    And i receive valid data payment

  Scenario: as a user i cannot create payment with unexist order id
    When i send request to create payment with unexist order id
    Then i receive status code 500
    And i receive error message "creating error"