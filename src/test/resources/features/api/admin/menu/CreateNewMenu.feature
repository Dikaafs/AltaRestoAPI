Feature: Create Menu
  as a admin i want to create menu
  so that we have new menu

  Scenario: as a admin i can create new menu with valid input
    Given i set API endpoint for create new menu with valid input
    When i send request to create new menu with valid input
    Then i receive status code 201
    And i receive valid data of new menu
    
  Scenario: as a admin i cannot create new menu with existing menu
    Given i set API endpoint for create new menu with valid input
    When i send request to create new menu with existing menu
    Then i receive status code 400
    And i receive message "menu already exists"