Feature: As a user, I want to access detailed course information so that I can choose which courses to enroll in

  Background: The same steps for all scenarios in this page
    Given user logs in to the app
    When user click on "Cydeo Learning"
    And user should see Cydeo Learning page

  @courses
  Scenario: Access Courses List
    And user click on "Courses" menu item
    Then user should see the "Courses" page

  Scenario Outline: View Course Details
    When user select a course "<course name>"
    Then user should see the details "<course details>"
    Examples:
      | course name                    | course details                 |
      | JAVA SDET SUMMER 2024          | JAVA SDET SUMMER 2024          |
      | SDET Alumni Interview Practice | SDET Alumni Interview Practice |
      | SDET Fast Track                | SDET Fast Track                |
