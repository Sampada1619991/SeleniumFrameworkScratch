#Author: Sampada Chendake

########################## Comment Section Start ##############################
#
########################## Comment Section END ################################

 Feature: Validate Submit Submenus on Home Page for Client Portal
 
 #Checking Sub Menus for Submit Tab Only
 
 Scenario: Launching url for Client Portal
 
Given navigate to application "url"
Given I logged in with username "forceten.supplier.user" and password "12345" to launch "portal" view 


Scenario: Validating user access to switch window without re-login

Given check that element "forceTenLogoOnHome" is displayed
And check that element "supplierServicePortal" is displayed
Then select switch Client to switch client from dropdown
Then I select the client "forcetenDropDown" and click on OK


#Scenario: Log Out functionality
#And I logged out from portal
