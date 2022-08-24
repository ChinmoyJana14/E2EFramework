@SmokeScenario
Feature: Log in Application

Scenario Outline: Positive Test Validating Login
Given Initialize browser with chrome
And Navigate to "url" site
And Click on login in home page
When User enters <username> and <password> and logs in
Then Verify users is successfully logged in
And close browser

Examples:
|username | password |
| sanujana8@gmail.com | Test12345 |
| sanujana7@gmail.com | Test123456 |
 




