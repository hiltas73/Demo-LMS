Feature: Login Functionality
  As a user, I want to see an appropriate error message when I enter invalid credentials
  so that I understand why I cannot log in.

  Background: Navigate to Login page
	Given user navigate to login URL

  Scenario: User misses entering email address
	When user leaves the email address box empty
	And user enters a valid password
	And user click on Login button
	Then the system display "Please fill in this field." message under the email box

  Scenario: User misses entering password
	When user enters a valid email
	And user leaves the password box empty
	And user click on Login button
	Then the system display "Please fill in this field." message under the password box

  Scenario Outline: Login validation with missing credentials
	When user leave "<field>" empty
	And user click on Login button
	Then "<message>" should appear under "<field>"

	Examples:
	  | field    | message                    |
	  | email    | Please fill in this field. |
	  | password | Please fill in this field. |

  @invalid-credentials
  Scenario Outline: Invalid credential combinations
	When user enter "<email>" in email field
	And user enter "<password>" in password field
	And user click on Login button
	Then email and password fields should have "<border-color>"
	And user should see the error message "<error_message>"

	Examples:
	  | email               | password     | error_message              | border-color       |
	  |                     |              | Please fill in this field. | rgb(99, 93, 255)   |
	  | valid2025@email.com |              | Please fill in this field. | rgb(156, 154, 228) |
	  |                     | validPass123 | Please fill in this field. | rgb(192, 193, 210) |
	  | wrong2025@email.com | wrongPass123 | Wrong email or password.   | rgb(181, 52, 49)   |
	  | valid2025@email.com | wrongPass123 | Wrong email or password.   | rgb(208, 60, 56)   |
	  | wrong2025@email.com | validPass123 | Wrong email or password.   | rgb(208, 60, 56)   |
