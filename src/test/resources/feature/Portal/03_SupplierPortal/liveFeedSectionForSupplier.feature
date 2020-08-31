#Author: Sampada Chendake

Feature: Live Feeds Section on Home Page for Supplier Portal

Scenario: Validating Live Feeds Section on Home Page for Supplier Portal

Given navigate to application "url"
Given I logged in with username "forceten.supplier.user" and password "12345" to launch "portal" view 
Then check that element "liveFeedTab" is displayed
Then I click on the element: "liveFeedTab"
Then check that element "fullScreenView" is displayed
And I click on the element: "fullScreenView"

Scenario: Validating Newly opened window on clicking User Name

Given check that element "feeds" is displayed in new tab
And check that element "userProfile" is displayed in new tab
And I click on the element: "userProfile" in new tab
Then check that element "aboutMe" is displayed in new tab
And check that element "messageTab" is displayed in new tab
And check that element "feedsTab" is displayed in new tab
And check that element "teamsTab" is displayed in new tab
And check that element "followersTab" is displayed in new tab
And check that element "followingTab" is displayed in new tab

Scenario: Validating Group Feed option in left pane on new tab 

Given check that element "feeds" is displayed in new tab
And check that element "groupFeed" is displayed in new tab
Then I click on the element: "groupFeed" in new tab
Then check that element "myFeeds" is displayed in new tab
Then check that element "pendingFeeds" is displayed in new tab
Then check that element "allFeed" is displayed in new tab

Scenario: Validating Record Feed Option in left Pane on new tab

Given check that element "feeds" is displayed in new tab
And check that element "recordFeed" is displayed in new tab
Then I click on the element: "recordFeed" in new tab
Then check that element "myFeeds" is displayed in new tab
Then check that element "pendingFeeds" is displayed in new tab
Then check that element "allFeed" is displayed in new tab

Scenario: Validating People Option in left Pane on new tab

Given check that element "feeds" is displayed in new tab
And check that element "people" is displayed in new tab
Then I click on the element: "people" in new tab
Then check that element "followers_people" is displayed in new tab
Then check that element "following_people" is displayed in new tab

Scenario: Validating HashTag Option in left Pane on new tab

Given check that element "feeds" is displayed in new tab
And check that element "hashtag" is displayed in new tab
Then I click on the element: "hashtag" in new tab


Scenario: Log Out functionality
And I logged out from portal
