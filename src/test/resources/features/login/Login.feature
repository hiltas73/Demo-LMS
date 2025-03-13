Feature: Login Functionality
  As a user, I want to log in successfully with valid credentials
  so that I can access my account.

  @login @ui
  Scenario: Login with valid credentials
	Given user navigate to login URL
	When user enters a valid email
	And user enters a valid password
	And user click on Login button button
	Then user should see home page