@Test13
Feature: Sign up on Itera QA site

Background: Common Steps in all scenarios
Given I am on the homepage of the Itera QA site
When I click on Sign Up button on homepage
And I verify signup page is launched

@wi
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
| TestFname6 | TestLName6 | TestFName6@itera.com | 1234567890 | TestFName6@itera.com | Test@FName4 | Test@FName4 | 
| TestFname7 | TestLName7 | TestFName7@itera.com | 1234567890 | TestFName7@itera.com | Test@FName4 | Test@FName4 |
#| TestFname8 | TestLName8 | TestFName8@itera.com | 1234567890 | TestFName8@itera.com | Test@FName4 | Test@FName4 |
#| TestFname9 | TestLName9 | TestFName9@itera.com | 1234567890 | TestFName9@itera.com | Test@FName4 | Test@FName4 |
#| TestFname10 | TestLName10 | TestFName10@itera.com | 1234567890 | TestFName10@itera.com | Test@FName4 | Test@FName4 |
#| TestFname11 | TestLName11 | TestFName11@itera.com | 1234567890 | TestFName11@itera.com | Test@FName4 | Test@FName4 |


@wi
@te
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