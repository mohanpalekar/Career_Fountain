@Test
Feature: Sign up on Itera QA site

Background: Common Steps in all scenarios
Given I am on the homepage of the Itera QA site
When I click on Sign Up button on homepage
And I verify signup page is launched

Scenario Outline: Sign Up with valid data on QA Itera Site
And I enter FirstName as <FirstName>
And I enter LastName as <LastName>
And I enter Email as <Email>
And I enter Mobile as <Mobile>
And I enter UserName as <UserName>
And I enter Password as <Password>
And I enter Confirm Password as <ConfirmPassword>
Then I click on Submit button
Then I verify Registration successful message is shown on the screen

Examples:
| FirstName | LastName | Email | Mobile | UserName | Password | ConfirmPassword |
| TestFname12 | TestLName12 | TestFName12@itera.com | 1234567890 | TestFName12@itera.com | Test@FName4 | Test@FName4 | 
| TestFname13 | TestLName13 | TestFName13@itera.com | 1234567890 | TestFName13@itera.com | Test@FName4 | Test@FName4 |
| TestFname14 | TestLName14 | TestFName14@itera.com | 1234567890 | TestFName14@itera.com | Test@FName4 | Test@FName4 |
| TestFname17 | TestLName17 | TestFName17@itera.com | 1234567890 | TestFName17@itera.com | Test@FName4 | Test@FName4 |
| TestFname18 | TestLName18 | TestFName18@itera.com | 1234567890 | TestFName18@itera.com | Test@FName4 | Test@FName4 |
| TestFname19 | TestLName19 | TestFName19@itera.com | 1234567890 | TestFName19@itera.com | Test@FName4 | Test@FName4 |


Scenario: Sign Up with invalid data on QA Itera Site
And I enter FirstName as TestFname3
And I enter LastName as TestLName3
And I enter Email as TestFName3@itera.com
And I enter Mobile as 1234567890
And I enter UserName as TestFName3@itera.com
And I enter Password as TestFName1@
And I enter Confirm Password as TestFName1@
Then I click on Submit button
Then I verify DUplicate UserName message is shown on the screen

@wi
Scenario: Sign Up with valid data and mismatching password on QA Itera Site
And I enter FirstName as TestFname4
And I enter LastName as TestLName4
And I enter Email as TestFName4@itera.com
And I enter Mobile as 1234567890
And I enter UserName as TestFName4@itera.com
And I enter Password as TestFName4@
And I enter Confirm Password as TestFName3@
Then I click on Submit button
Then I verify password mismatch message is shown on the screen