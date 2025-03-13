# Feature: Password Visibility Toggle
Feature: Password Visibility Toggle
  As a user
  I want to be able to toggle the visibility of my password
  So that I can verify my password entry

  # Scenario: Default State
  Scenario: Password field is masked by default
	Given user navigate to login URL
	When user enters a valid email
	Then the password field should be masked

  @wip
  # Scenario: Show Password
  Scenario: Clicking the eye icon shows the password
	Given user navigate to login URL
	And user enters a valid email
	When user click on the eye icon
	Then the password should be visible
