Feature: login Test

  Background:
    Given I am on homepage
    When I click on login link

  Scenario: user should navigate to login page successfully
    Then I should navigate to login page successfully

    @smoke
  Scenario: user should navigate to login page successfully with invalid credentials
    And I enter email "code1@gmail.com"
    And I enter password "122344"
    And I click on login button
    Then I should login to login page successfully


  Scenario Outline: verify multiple user
    And I enter email "<email>"
    And I enter password "<password>"
    And I click on login button
    And I should see error message "<errorMessage>"

    Examples:
      | email           | password | errorMessage                                                                                |
      | code@gmail.com  | 123456   | Login was unsuccessful. Please correct the errors and try again.\nNo customer account found |
      | code1@gmail.com | 123456   | Login was unsuccessful. Please correct the errors and try again.\nNo customer account found |
 # |code2@gmail.com|123456|Login was unsuccessful. Please correct the errors and try again.\nNo customer account found|
  #|code3@gmail.com|123456|Login was unsuccessful. Please correct the errors and try again.\nNo customer account found|