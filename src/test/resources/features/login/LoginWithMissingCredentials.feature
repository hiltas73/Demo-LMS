Feature: Login feature
  @wip
  Scenario: User misses entering email address
	Given user navigate to login URL
	When user leaves the email address box empty
	And user enters a valid password
	And user click on Login button
	Then the system display "Please fill in this field." message under the email box

  Scenario Outline: Login validation with missing credentials
	Given user navigate to login URL
	When user leave "<field>" empty
	And click on login button
	Then "<message>" should appear under "<field>"

	Examples:
	  | field    | message                   |
	  | email    | Please fill in this field. |
	  | password | Please fill in this field. |
