Feature: Login

  Scenario: Successful Login
    Given I open the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard

