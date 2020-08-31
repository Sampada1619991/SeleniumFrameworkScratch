#Author: Sampada Chendake

Feature: Validate Home Page for Supplier Portal


Scenario: Validating top Menu bar on Home Page for Client

Given navigate to application "url"
Given I logged in with username "forceten.supplier.user" and password "12345" to launch "portal" view 
Then check that element "forceTenLogoOnHome" is displayed
Then check that element "homeMenu" is displayed
Then check that element "searchMenu" is displayed
Then check that element "submitMenu" is displayed
Then check that element "profileMenu" is displayed
Then check that element "helpMenu" is displayed
Then check that element "searchButtonOnMenu" is displayed

Scenario: Clicking on LOGO
Given I click on the element: "forceTenLogoOnHome"

Scenario: Validating Search Tab on Home Page 

Given I click on the element: "searchMenu"
Then check that element "searchTitle" is displayed
Then check that element "all_search" is displayed
Then check that element "invoices_search" is displayed
Then check that element "requests_search" is displayed
Then check that element "knowledgeBase_search" is displayed
And I click on the element: "home_Search"


Scenario: Validating Submit Tab on Home Page

Given I click on the element: "submitMenu"
Then check that element "submitTitle" is displayed
Then check that element "procureToPay" is displayed
Then check that element "masterData" is displayed
And I click on the element: "home_submit"


Scenario: Validating Help Tab on Home Page

Given I click on the element: "helpMenu"
Then check that element "helpTitle" is displayed
Then check that element "faqs" is displayed
Then check that element "purchasingGuidelines" is displayed
Then check that element "policiesAndProcedures" is displayed
Then check that element "knowledgeBase_help" is displayed
Then check that element "portalTour" is displayed
Then check that element "liveChat" is displayed
Then check that element "contactUs" is displayed
And I click on the element: "home_help"


Scenario: Validating Other General Elements on Home Page

Given check that element "myRequest" is displayed
Given check that element "pendingResponse" is displayed


Scenario: Log Out functionality
And I logged out from portal
