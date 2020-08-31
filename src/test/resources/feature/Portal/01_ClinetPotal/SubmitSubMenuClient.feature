#Author: Sampada Chendake

########################## Comment Section Start ##############################
#Line no 37,38 indicates navigating to back on Home Page
########################## Comment Section END ################################

 Feature: Validate Submit Submenus on Home Page for Client Portal
 
 #Checking Sub Menus for Submit Tab Only
 
 Scenario: Launching url for Client Portal
 
Given navigate to application "url"
When I logged in with username "Forceten.Client.User" and password "123" to launch "portal" view 


Scenario: Validating Catalogs under Submit Tab for Order to Cash Tab

Given check that element "submitMenu" is displayed
Then I click on the element: "submitMenu"
Then I click on the element: "orderToCash"
Then check that element "orderToCashTitle" is displayed
Then check that element "submitPurchaseOrderCatalog" is displayed
Then I click on the element: "submitPurchaseOrderCatalog"
And I click on the element: "forceTenLogoOnHome"

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

Scenario: Validating Catalogs under Submit Tab for Record To Report Tab

Given check that element "submitMenu" is displayed
Then I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
Then check that element "recordToReportTitle" is displayed
#CATALOG-1
Then check that element "addFixedAssetCatalog" is displayed
Then I click on the element: "addFixedAssetCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-2
Then check that element "submitCostCenterDataCatalog" is displayed
Then I click on the element: "submitCostCenterDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-3
Then check that element "updateCostCenterDataCatalog" is displayed
Then I click on the element: "updateCostCenterDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-4
Then check that element "updateProfitCenterDataCatalog" is displayed
Then I click on the element: "updateProfitCenterDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-5
Then check that element "submitJournalEntryCatalog" is displayed
Then I click on the element: "submitJournalEntryCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-6
Then check that element "createFixedAssetCatalog" is displayed
Then I click on the element: "createFixedAssetCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-7
Then check that element "modifyFixedAssetCatalog" is displayed
Then I click on the element: "modifyFixedAssetCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-8
Then check that element "blockUnblockProfitCenterDataCatalog" is displayed
Then I click on the element: "blockUnblockProfitCenterDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-9
Then check that element "saleFixedAssetCatalog" is displayed
Then I click on the element: "saleFixedAssetCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-10
Then check that element "blockUnblockCompanyCodeDataCatalog" is displayed
Then I click on the element: "blockUnblockCompanyCodeDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-11
Then check that element "submitProfitCenterDataCatalog" is displayed
Then I click on the element: "submitProfitCenterDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-12
Then check that element "blockUnblockCostCenterDataCatalog" is displayed
Then I click on the element: "blockUnblockCostCenterDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-13
Then check that element "updateCompanyCodeDataCatalog" is displayed
Then I click on the element: "updateCompanyCodeDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-14
Then check that element "submitGLAccountDataCatalog" is displayed
Then I click on the element: "submitGLAccountDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-15
Then check that element "retireFixedAssetDataCatalog" is displayed
Then I click on the element: "retireFixedAssetDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-16
Then check that element "updateGLAccountDataCatalog" is displayed
Then I click on the element: "updateGLAccountDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-17
Then check that element "transferFixedAssetDataCatalog" is displayed
Then I click on the element: "transferFixedAssetDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-18
Then check that element "blockUnblockGLAccountDataCatalog" is displayed
Then I click on the element: "blockUnblockGLAccountDataCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "recordToReport"
#CATALOG-19
Then check that element "submitCompanyCodeDataCatalog" is displayed
Then I click on the element: "submitCompanyCodeDataCatalog"
And I click on the element: "forceTenLogoOnHome"

Scenario: Validating Catalogs under Submit Tab for User Access Management Tab

Given check that element "submitMenu" is displayed
Then I click on the element: "submitMenu"
Then I click on the element: "userAccessManagement"
Then check that element "userAccessManagementTitle" is displayed
Then check that element "inviteUserToRegisterCatalog" is displayed
Then I click on the element: "inviteUserToRegisterCatalog"
And I click on the element: "submitMenu"
Then I click on the element: "userAccessManagement"
Then check that element "submitAccessUserGroupRequestCatalog" is displayed
Then I click on the element: "submitAccessUserGroupRequestCatalog"
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

