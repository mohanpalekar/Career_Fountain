@Test
Feature: Customer Page Features

Background: Common Steps
Given I am on the homepage of the Itera QA site
When I click on Login button on Home Page
And I verify login form is launched
And I enter UserName as testUser123
And I enter Password as test@12345
And I click on Login button
And I verify my login is successful


@Test
Scenario: Edit Customer Details
And I click on Edit for customer no. 5
And I verify Edit page is launched
And I edit Name as TestName12
And I edit Company as TestCompany
And I edit Address as TestAddress
And I edit City as TestCity
And I edit Phone as 0123456789
And I edit Email as TestName12@itera.com
And I click on Save button
And I verify customer details edited successfully for customer TestName12
And I click on logout button
And I verify logout was successful