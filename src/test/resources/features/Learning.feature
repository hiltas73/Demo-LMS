Feature: Navigate LMS feature
  @LMS @ui
  Scenario: Navigate to LMS
    Given user logs in to the app
    When user click on "Cydeo Learning"
    Then user should see Cydeo Learning page