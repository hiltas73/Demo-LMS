Feature: Login feature

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
	Given user navigate to login URL
	When user leave "<field>" empty
	And user click on Login button
	Then "<message>" should appear under "<field>"

	Examples:
	  | field    | message                    |
	  | email    | Please fill in this field. |
	  | password | Please fill in this field. |