Feature: User Login Page tests

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid email and password
    And clicks the "LOGIN" button
    Then the user should be redirected to the homepage

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid email or password
    And clicks the "LOGIN" button
    Then the user should see an error message "must be a valid email"
    And the user should remain on the login page

  Scenario: Attempt to login with missing email
    Given the user is on the login page
    When the user leaves the email field empty
    And enters a password
    And clicks the "LOGIN" button
    Then the user should see a validation message '"email" is not allowed to be empty'


  Scenario: Attempt to login with missing password
    Given the user is on the login page
    When the user enters an email
    And leaves the password field empty
    And clicks the "LOGIN" button
    Then the user should see a validation message '"password" is not allowed to be empty'

  Scenario: Navigate to registration page
    Given the user is on the login page
    When the user clicks the "REGISTER" button
    Then the user should be redirected to the registration page

  Scenario: Navigate to forgot password page
    Given the user is on the login page
    When the user clicks the "Forgot Password?" link
    Then the user should be redirected to the forgot password page
