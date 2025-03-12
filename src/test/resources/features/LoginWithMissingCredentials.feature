Feature: Login feature
  @wip
  Scenario Outline: Login validation with missing credentials
	Given user navigate to login URL
	When user leave "<field>" empty
	And click on login button
	Then "<message>" should appear under "<field>"

	Examples:
	  | field    | message                   |
	  | email    | Please fill in this field. |
	  | password | Please fill in this field. |