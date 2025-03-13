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

#  Scenario Outline: Invalid credential combinations
#	When user enter "<email>" in email field
#	And user enter "<password>" in password field
#	And user click on Login button
#	Then email and password fields should have red border
#	And user should see the error message "<error_message>"
#
#	Examples:
#	  | email           | password     | error_message              |
#	  |                 |              | Please fill in this field. |
#	  | valid@email.com |              | Please fill in this field. |
#	  |                 | validPass123 | Please fill in this field. |
#	  | wrong@email.com | wrongPass123 | Wrong email or password.   |
#	  | valid@email.com | wrongPass123 | Wrong email or password.   |
#	  | wrong@email.com | validPass123 | Wrong email or password.   |
