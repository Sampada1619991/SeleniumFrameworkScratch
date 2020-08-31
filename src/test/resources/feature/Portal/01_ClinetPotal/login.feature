#Author: atul kurkure
#Keywords Summary : To validte login page displayed correctly.


Feature: Validate login scenarios 
I want to use this template testing login scenarios.


Scenario: Launch WebBroser, navite to Portal URL and validate login page

#Given launch the "Chrome" web browser
Given navigate to application "url"
Then check that element "servicenow_Logo" is displayed
Then check that element "userNameLabel" is displayed
Then check that element "passWordlabel" is displayed



Scenario: On login page check all text

#Given check that element "servicenow_Logo" is displayed
#Then check that iframe element "userNameTextBox" is displayed
#And check that iframe element "passWordTextBox" is displayed
#And check that iframe element "rememberMeOpion" is displayed
#And check that iframe element "forgetPasswordLink" is displayed
#And check that iframe element "aboutServeiNowInfoText" is displayed

Scenario: Enter login credentials and click on login button

#Given check that element "servicenow_Logo" is displayed
Then I logged in with username "Forceten.Client.User" and password "123" to launch "portal" view
#Then I type value: "{any-text}" in the element: "{any-text}"
#Then I type value: "forceten.supplier.user" in the element: "userNameTextBox"
#Then I type value: "123" in the element: "passWordTextBox"
#When I click on  the element: "loginButton"		
#And select client to access the portal
And I navigate to company profile Page
And I navigate back
And I logged out from portal






