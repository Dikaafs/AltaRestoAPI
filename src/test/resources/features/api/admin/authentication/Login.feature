Feature: Login {Admin}
  as a admin i want to login
  so that i can access dashboard

  Background:
    Given i set API endpoint for login

  Scenario Outline: as a admin i can login with valid credentials
    When i send request to login with valid email"<email>" and valid password"<password>"
    Then i receive status code 200
    And i receive access token from login
    Examples:
    |email                      |password     |
    |admin123@gmail.com         |admin321     |

  Scenario Outline: as a admin i cannot login with empty field
    When i send request to login with emtpy field email "<email>" and valid password "<password>"
    Then i receive status code 500
    Examples:
      |email                         |password        |
      |                              |altaresto05     |

  Scenario Outline: as a admin i cannot login with unregistered Account
    When i send request to login with invalid email"<email>" and invalid password"<password>"
    Then i receive status code 500
    Examples:
      |email                         |password        |
      |anonym@crack.com              |anonym001       |

  Scenario Outline: as a admin i cannot login with invalid email credentials
    When i send request to login with invalid email credentials"<email>" and invalid password"<password>"
    Then i receive status code 500
    Examples:
      |email             |password        |
      |Admin             |admin123_       |