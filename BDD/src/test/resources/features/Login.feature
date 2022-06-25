@Test
Feature: Login Functionality Test Cases


@Smoke
@wip1
Scenario: Login with valid data
Given I am on the homepage of the Itera QA site
When I click on Login button on Home Page
And I verify login form is launched
And I enter UserName as testUser1234
And I enter Password as test@12345
And I click on Login button
And I verify my login is successful
And I click on logout button
And I verify logout was successful


@Sanity
@wip11
Scenario: Login with invalid data
Given I am on the homepage of the Itera QA site
When I click on Login button on Home Page
And I verify login form is launched
And I enter UserName as testUser124
And I enter Password as test@1234545
And I click on Login button
And I verify my login is unsuccessful


@Regression
@wip11
Scenario: Login with blank UserName data
Given I am on the homepage of the Itera QA site
When I click on Login button on Home Page
And I verify login form is launched
And I enter Password as test@1234545
And I click on Login button
And I verify blank Username message is shown