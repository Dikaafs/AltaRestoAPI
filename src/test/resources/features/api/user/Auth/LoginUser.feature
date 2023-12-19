Feature: Login {USER}
  as a user i want to login
  so that i can directed to homepage

  Scenario Outline: as a user i can login with valid credentials
    Given i set API endpoint for login user
    When i send request to login user with valid email "<email>" and valid password "<password>"
    Then i receive status code 200
    And i receive access token from login user
    Examples:
      |email                       |password       |
      |testingqa@gmail.com         |altaresto05    |

  Scenario Outline: as a user i cannot login with empty field
    When i send request to login user with emtpy field email "<email>" and valid password "<password>"
    Then i receive status code 500
    Examples:
      |email                   |password     |
      |                        |user1234     |

  Scenario Outline: as a user i cannot login with unregistered Account
    When i send request to login user with invalid email"<email>" and invalid password"<password>"
    Then i receive status code 500
    Examples:
      |email                         |password        |
      |akuncoba@gmail.com            |anonym001       |

  Scenario Outline: as a admin i cannot login with invalid email credentials
    When i send request to login user with invalid email credentials"<email>" and invalid password"<password>"
    Then i receive status code 500
    Examples:
      |email             |password        |
      |user              |user123         |