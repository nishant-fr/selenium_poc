Feature: User Registration page related tests

  Scenario: Successful registration with valid data
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo       | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | random   | 0198653223 | 21656369563 | O+        | Male | 06/06/2001 | random             | random            | Dr.            | testSite     | 6 rue de Paris  | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then upon successfull registration the user is redirected to the login page
    And newly registered user is able to login successfully to the application

  Scenario: First Name field - Invalid first name error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo       | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | T         | random   | 0198653223 | 21656369563 | B+        | Male | 06/06/2001 | random             | random            | Dr.            | testSite     | 6 rue de Paris  | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"firstName" length must be at least 2 characters long'

  Scenario: Last Name field - Invalid last name error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo       | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | T        | 0198653223 | 21656369563 | A+        | Male | 06/06/2001 | random             | random            | Dr.            | testSite     | 6 rue de Paris  | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"lastName" length must be at least 2 characters long'

  Scenario: Phone Number field - Invalid phone number error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo       | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | random   | 019865322a | 1234567890a | A-        | Male | 06/06/2001 | random             | random            | Dr.            | testSite     | 6 rue de Paris  | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"phone" with value "019865322a" fails to match the required pattern: /^[0-9]+$/'

  Scenario: Physician First Name field - Invalid physician first name error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo      | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | random   | 0198653220 | 1234567890 | A-        | Male | 06/06/2001 | T                  | random            | Dr.            | testSite     | 6 rue de Paris  | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"usualPhysician.firstName" length must be at least 2 characters long'

  Scenario: Physician Last Name field - Invalid physician last name error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo      | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | random   | 0198653220 | 1234567890 | A-        | Male | 06/06/2001 | random             | T                 | Dr.            | testSite     | 6 rue de Paris  | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"usualPhysician.lastName" length must be at least 2 characters long'

  Scenario: Care Site Name field - Invalid care site name error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo      | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | random   | 0198653220 | 1234567890 | A-        | Male | 06/06/2001 | random             | random            | Dr.            | T            | 6 rue de Paris  | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"usualCareSite.name" length must be at least 2 characters long'

  Scenario: Care Site Address field - Invalid care site address error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo      | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | random   | 0198653220 | 1234567890 | A-        | Male | 06/06/2001 | random             | random            | Dr.            | testSite     | 6 r             | random  | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"usualCareSite.address" length must be at least 5 characters long'


  Scenario: Email Address field - Invalid email address error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo      | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId   | password |
      | random    | random   | 0198653220 | 1234567890 | A-        | Male | 06/06/2001 | random             | random            | Dr.            | testSite     | 6 r             | test@test | random   |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"email" must be a valid email'

  Scenario: Password Address field - Invalid password address error handling
    Given the user is on the login page
    And the user clicks the "REGISTER" button
    And the user should be redirected to the registration page
    When the user enters the following values to register
      | firstName | lastName | phoneNo    | ssnNo      | bloodType | sex  | dob        | physicianFirstName | physicianLastName | physicianTitle | careSiteName | careSiteAddress | emailId | password |
      | random    | random   | 0198653220 | 1234567890 | A-        | Male | 06/06/2001 | random             | random            | Dr.            | testSite     | 6 r             | random  | abcd     |
    And the user clicks the "REGISTER" button under registration page
    Then the user should see an error message '"password" length must be at least 6 characters long'