Feature: As a user, I want to view my schedule so that I can manage my time
  Background: The same steps for all scenarios in this page
    Given user logs in to the app
    When user click on "Cydeo Learning"
    And user should see Cydeo Learning page
  @viewCalendar
  Scenario: Ensure that the calendar view is accessible from the dashboard
    When user click on "Calendar" menu item
    Then user should see the "Calendar" page