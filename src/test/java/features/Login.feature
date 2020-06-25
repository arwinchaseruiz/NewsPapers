Feature: User logs in to Newspapers.com

Scenario Outline: User logs in to Newspapers.com

Given User is on the Newpapers.com Homepage.

When User clicks Sign In link.

And User enters his email. <email>

And User enters his password. <password>

Then User clicks Sign In with Newspapers.com button.

And User sees the Homepage.

Examples:
|email              |password|
|lourdes100@test.com|Test123!|