Feature: Login feature
  @login @ui
  Scenario: Login with valid credentials
    Given user navigate to login URL
    When user enters email
    And user enters password
    And click on login button
    Then user should see home page