# Feature: Password Visibility Toggle
Feature: Password Visibility Toggle
  As a user
  I want to be able to toggle the visibility of my password
  So that I can verify my password entry

  Background: Navigate to the URL
	Given user navigate to login URL

  # Scenario: Default State
  Scenario: Password field is masked by default
	When user enters a valid email
	Then the password field should be masked

  @wip
  # Scenario: Show Password
  Scenario: Clicking the eye icon shows the password
	And user enters a valid email
	When user click on the eye icon
	Then the password should be visible

# # Scenario: Hide Password
#  Scenario: Clicking the eye icon again hides the password
#	And I enter a password
#	And I click the eye icon to show the password
#	When I click the eye icon again
#	Then the password should be masked
#
#  # Scenario: Toggle Multiple Times
#  Scenario: Toggling multiple times works correctly
#	And I enter a password
#	When I click the eye icon to show the password
#	And I click the eye icon to hide the password
#	And I click the eye icon to show the password again
#	Then the password should be visible
#
#  # Scenario: Empty Password Field
#  Scenario: Clicking the eye icon with an empty password field
#	When I click the eye icon without entering a password
#	Then the password field should remain empty
#
#  # Scenario: Icon Visibility
#  Scenario: The eye icon is visible next to the password field
#	Then the eye icon should be visible next to the password field
#
#  # Scenario: Keyboard Accessibility
#  Scenario: The eye icon is accessible via keyboard
#	When I navigate to the password field using the Tab key
#	And I use Enter or Space to toggle the eye icon
#	Then the password should be visible
