#Author: Sampada Chendake

Feature: Live Feeds Section on Home Page for Client Portal

Scenario: Validating Live Feeds Section on Home Page for Client Portal

Given navigate to application "url"
Given I logged in with username "Forceten.Client.User" and password "123" to launch "portal" view 
Then check that element "liveFeedTab" is displayed
Then I click on the element: "liveFeedTab"
Then check that element "fullScreenView" is displayed
And I click on the element: "fullScreenView"

Scenario: Validating Newly opened window on clicking User Name

Given check that element "userProfile" is displayed
And I click on the element: "userProfile"
Then check that element "aboutMe" is displayed
And check that element "messageTab" is displayed
And check that element "feedsTab" is displayed
And check that element "teamsTab" is displayed
And check that element "followersTab" is displayed
And check that element "followingTab" is displayed

Scenario: Log Out functionality
And I logged out from portal
