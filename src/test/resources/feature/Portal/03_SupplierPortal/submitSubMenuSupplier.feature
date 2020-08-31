#Author: Sampada Chendake

########################## Comment Section Start ##############################
#Line no 37,38 indicates navigating to back on Home Page
########################## Comment Section END ################################

 Feature: Validate Submit Submenus on Home Page for Client Portal
 
 #Checking Sub Menus for Submit Tab Only
 
 Scenario: Launching url for Client Portal
 
Given navigate to application "url"
Given I logged in with username "forceten.supplier.user" and password "12345" to launch "portal" view 


Scenario: Validating Catalogs under Submit Tab for Procure To Pay Tab

Given check that element "submitMenu" is displayed
Then I click on the element: "submitMenu"
Then I click on the element: "procureToPay"
Then check that element "procureToPayTitle" is displayed
Then check that element "submitInvoiceCatalog" is displayed
Then I click on the element: "submitInvoiceCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "procureToPay"
Then check that element "standardInvoiceQueryCatalog" is displayed
Then I click on the element: "standardInvoiceQueryCatalog"
And I click on the element: "forceTenLogoOnHome"


Scenario: Validating Catalogs under Submit Tab for Master Data Tab

Given check that element "submitMenu" is displayed
Then I click on the element: "submitMenu"
Then I click on the element: "masterData"
Then check that element "masterDataTitle" is displayed
Then check that element "submitCompanyProfileCatalog" is displayed
Then I click on the element: "submitCompanyProfileCatalog"
And I click on the element: "forceTenLogoOnHome"


Scenario: Log Out functionality
And I logged out from portal

