Feature: As a user, I want to view my schedule so that I can manage my time

  Background: The same steps for all scenarios in this page
	Given user logs in to the app
	When user click on "Cydeo Learning"
	And user should see Cydeo Learning page

  @viewCalendar @ui
  Scenario: Ensure that the calendar view is accessible from the dashboard
	When user click on "Calendar" menu item
	Then user should see the "Calendar" page

  @switchView
  Scenario: Verify switching to Week view
	Given the user is on the "Calendar – Cydeo" page
	And the "Month" view is currently displayed
	When the user clicks on the "Week" view button on the top right
	Then the calendar should display the weekly view
	And daily hours should be displayed on the left
	And weekday numbers should be displayed on top
