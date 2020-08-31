$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/Portal/03_SupplierPortal/SubmitRITMSupplier.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Sampada Chendake"
    }
  ],
  "line": 3,
  "name": "Validate Home Page for Supplier Portal",
  "description": "",
  "id": "validate-home-page-for-supplier-portal",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Launching the URL for Supplier Portal",
  "description": "",
  "id": "validate-home-page-for-supplier-portal;launching-the-url-for-supplier-portal",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "navigate to application \"url\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I logged in with username \"forceten.supplier.user\" and password \"12345\" to launch \"portal\" view",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "check that element \"forceTenLogoOnHome\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "check that element \"submitMenu\" is displayed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "url",
      "offset": 25
    }
  ],
  "location": "Step_Definations.navigate_to_application(String)"
});
formatter.result({
  "duration": 13785741539,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "forceten.supplier.user",
      "offset": 27
    },
    {
      "val": "12345",
      "offset": 65
    },
    {
      "val": "portal",
      "offset": 83
    }
  ],
  "location": "Step_Definations.Login(String,String,String)"
});
formatter.result({
  "duration": 41734533333,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "forceTenLogoOnHome",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 2337771897,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "submitMenu",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 2305633231,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Validating Submit Tab on Home Page",
  "description": "",
  "id": "validate-home-page-for-supplier-portal;validating-submit-tab-on-home-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I click on the element: \"submitMenu\"",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "check that element \"submitTitle\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "check that element \"procureToPay\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "I click on the element: \"procureToPay\"",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "check that element \"procureToPayTitle\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "check that element \"submitInvoiceCatalog\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I click on the element: \"submitInvoiceCatalog\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "submitMenu",
      "offset": 25
    }
  ],
  "location": "Step_Definations.clickOnElement(String)"
});
formatter.result({
  "duration": 6703489231,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "submitTitle",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 2285905641,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "procureToPay",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 2298779077,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "procureToPay",
      "offset": 25
    }
  ],
  "location": "Step_Definations.clickOnElement(String)"
});
formatter.result({
  "duration": 3254818051,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "procureToPayTitle",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 2291010462,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "submitInvoiceCatalog",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 2294939076,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "submitInvoiceCatalog",
      "offset": 25
    }
  ],
  "location": "Step_Definations.clickOnElement(String)"
});
formatter.result({
  "duration": 8542907897,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 23,
      "value": "#"
    },
    {
      "line": 24,
      "value": "#Scenario: Validating Mandatory Form Elements"
    },
    {
      "line": 25,
      "value": "#"
    },
    {
      "line": 26,
      "value": "#Given check that element \"clientLegalEntityTitle_supplier\" is displayed"
    },
    {
      "line": 27,
      "value": "#Then fill the data for input filed:\"clientLegalEntityTitle_supplier\"from data table row:\"Supplier Portal_Supplier User\""
    }
  ],
  "line": 29,
  "name": "File Upload Functioanlity part-1l",
  "description": "",
  "id": "validate-home-page-for-supplier-portal;file-upload-functioanlity-part-1l",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "check that element \"attachementSymbol\" is displayed",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "I click on the element: \"attachementSymbol\"",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "check that element \"forceTen_Logo\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "check that element \"attachemnetTitle\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "check that element \"chooseFileButton\" is displayed",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "I click on the element: \"chooseFileButton\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "attachementSymbol",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 7536146052,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "attachementSymbol",
      "offset": 25
    }
  ],
  "location": "Step_Definations.clickOnElement(String)"
});
formatter.result({
  "duration": 9077730051,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "forceTen_Logo",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 2179049026,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "attachemnetTitle",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 7604268718,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "chooseFileButton",
      "offset": 20
    }
  ],
  "location": "Step_Definations.thenCheckElementIsDisplayed(String)"
});
formatter.result({
  "duration": 7368127590,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "chooseFileButton",
      "offset": 25
    }
  ],
  "location": "Step_Definations.clickOnElement(String)"
});
formatter.result({
  "duration": 8399148718,
  "status": "passed"
});
});