@Register
Feature: Regist User
  as a user i want to regist
  so that i can login and access alta resto feature

  Background:
    Given i set API endpoint for regist

  Scenario: as a admin i can regist with valid credentials
    When i send request to regist with valid credentials
    Then i receive status code 201
    And i receive valid data from regist
    
  Scenario: as a admin i cannot regist with empty field
    When i send request to regist with empty field
    Then i receive status code 500
    And i receive error message "sign up error"

  Scenario: as a admin i cannot regist with existing account
    When i send request to regist with existing account
    Then i receive status code 500
    And i receive error message "sign up error"