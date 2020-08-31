#Author: Sampada Chendake

Feature: Validate Home Page for Supplier Portal


Scenario: Launching the URL for Supplier Portal

Given navigate to application "url"
Given I logged in with username "forceten.supplier.user" and password "12345" to launch "portal" view 
Then check that element "forceTenLogoOnHome" is displayed
And check that element "submitMenu" is displayed

Scenario: Validating Submit Tab on Home Page

Given I click on the element: "submitMenu"
Then check that element "submitTitle" is displayed
Then check that element "procureToPay" is displayed
Then I click on the element: "procureToPay"
Then check that element "procureToPayTitle" is displayed
Then check that element "submitInvoiceCatalog" is displayed
Then I click on the element: "submitInvoiceCatalog"

#
#Scenario: Validating Mandatory Form Elements
#
#Given check that element "clientLegalEntityTitle_supplier" is displayed
#Then fill the data for input filed:"clientLegalEntityTitle_supplier"from data table row:"Supplier Portal_Supplier User"

Scenario: File Upload Functioanlity part-1l

Given check that element "attachementSymbol" is displayed
Then I click on the element: "attachementSymbol"
Then check that element "forceTen_Logo" is displayed
Then check that element "attachemnetTitle" is displayed
And check that element "chooseFileButton" is displayed
Then I click on the element: "chooseFileButton"

#Scenario: File Upload Functionality Part-2
#
#Given I click on the element: "chooseFileButton"
#Then I Select the file in File Browser and Upload it.
#
#Scenario: Closing the File Upload Browser.
#
#Given check that element "closeButton" is displayed
#Then I click on the element: "closeButton" 
#And I click on the element: "submitRequestButton" 
