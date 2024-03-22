Feature: To test the Login page functionality

  @LoginDetails
  Scenario Outline:Verify the login functionality by valid credentials

    Given user is in login page

    When user enters valid <username> and <password>

    And Clicks on Login Button

    Then User should be redirected to Home page

    Examples:
      | username               | password |
      | shobithjl123@gmail.com | admin123 |


