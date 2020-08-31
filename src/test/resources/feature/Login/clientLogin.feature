#Author: Sampada Chendake

Feature: Validate login page 
I want to use this template testing login scenarios.


Scenario: Launch WebBroser, navite to Portal URL and validate login page

Given navigate to application "url"
Then check that element "servicenow_Logo" is displayed
Then check that element "userNameLabel" is displayed
Then check that element "passWordlabel" is displayed
Then check that element "rememberMe" is displayed
And I check the checkbox is ticked :"rememberMe"
Then check that element "forgotPassword" is displayed
Then check that element "informationAtBottom" is displayed

#Scenario: forgot password functionality
#
#Then I click on the element: "forgotPassword"


Scenario: Login Functionality

Then fill the data for input filed:"username_aaa"from data table row:"Customer Portal_Customer User"
Then fill the data for input filed:"password_aaa"from data table row:"Customer Portal_Customer User"  
Then I click on loginbutton to launch the "portal" view

Scenario: Log Out functionality
And I logged out from portal

