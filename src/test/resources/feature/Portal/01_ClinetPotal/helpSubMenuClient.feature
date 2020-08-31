#Author: your.email@your.domain.com
#Checking Sub Menus for Help Tab Only

 Feature: Validate Help Submenu on Home Page for Client Portal
 
 
 Scenario: Launching url for Client Portal

Given navigate to application "url"
When I logged in with username "Forceten.Client.User" and password "123" to launch "portal" view 
 
Scenario: Validate all tabs under Help Menu 

Given I click on the element: "helpMenu"
When check that element "helpTitle" is displayed
Then I click on the element: "faqs"
Then I click on the element: "purchasingGuidelines"
Then I click on the element: "policiesAndProcedures"
Then I click on the element: "knowledgeBase_help"
Then I click on the element: "portalTour"
Then I click on the element: "liveChat"
Then I click on the element: "contactUs"
Then I click on the element: "forceTenLogoOnHome"


Scenario: Log Out functionality
And I logged out from portal
