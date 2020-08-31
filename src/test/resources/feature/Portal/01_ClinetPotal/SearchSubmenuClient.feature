#Author: Sampada Chendake

########################## Comment Section Start ##############################
#Line no 
########################## Comment Section END ################################

 Feature: Validate Search Submenu on Home Page for Client Portal
 
 #Checking Sub Menus for Search Tab Only

 Scenario: Launching url for Client Portal
 
Given navigate to application "url"
When I logged in with username "Forceten.Client.User" and password "123" to launch "portal" view 

Scenario: Validate all tabs under Search Menu 

Given I click on the element: "searchMenu"
Then I click on the element: "all_search"
Then I click on the element: "invoices_search"
Then I click on the element: "orders_search"
Then I click on the element: "requests_search"
Then I click on the element: "userProfiles_search"
Then I click on the element: "masterData_search"
Then I click on the element: "knowledgeBase_search"
Then I click on the element: "forceTenLogoOnHome"


Scenario: Log Out functionality
And I logged out from portal
