$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("checkout.feature");
formatter.feature({
  "line": 2,
  "name": "Online Shopping checkout feature",
  "description": "",
  "id": "online-shopping-checkout-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Checkout"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": "User place order from the page succesfully",
  "description": "",
  "id": "online-shopping-checkout-feature;user-place-order-from-the-page-succesfully",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "user enters Username as : \u003cuserName\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters Password : \u003cpassword\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user click on login button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "application homepage is displayed as : \u003ctitle\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user select filter as : \u003csortFilter\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user verifies the items are sorted by : \u003csortFilter\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user add high and low item to the cart",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user clicks on checkout button with cart value : \u003ccartValue\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user verify checkout page and click on checkout button with cart value : \u003ccartValue\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user enter : \u003cfirstname\u003e \u003clastName\u003e \u003cpostal\u003e and proceed",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user clicks on finish button",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "user verifies checkout confirmation message as : \u003ccheckoutMsg\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "online-shopping-checkout-feature;user-place-order-from-the-page-succesfully;",
  "rows": [
    {
      "cells": [
        "userName",
        "password",
        "title",
        "sortFilter",
        "cartValue",
        "firstName",
        "lastName",
        "postal",
        "checkoutMsg"
      ],
      "line": 19,
      "id": "online-shopping-checkout-feature;user-place-order-from-the-page-succesfully;;1"
    },
    {
      "cells": [
        "standard_user",
        "secret_sauce",
        "Products",
        "Price (high to low)",
        "2",
        "TestFirstName",
        "TestSecondName",
        "E16",
        "THANK YOU FOR YOUR ORDER"
      ],
      "line": 20,
      "id": "online-shopping-checkout-feature;user-place-order-from-the-page-succesfully;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8723330250,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "User place order from the page succesfully",
  "description": "",
  "id": "online-shopping-checkout-feature;user-place-order-from-the-page-succesfully;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@Checkout"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user enters Username as : standard_user",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters Password : secret_sauce",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user click on login button",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "application homepage is displayed as : Products",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user select filter as : Price (high to low)",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user verifies the items are sorted by : Price (high to low)",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user add high and low item to the cart",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user clicks on checkout button with cart value : 2",
  "matchedColumns": [
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "user verify checkout page and click on checkout button with cart value : 2",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user enter : \u003cfirstname\u003e TestSecondName E16 and proceed",
  "matchedColumns": [
    6,
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user clicks on finish button",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "user verifies checkout confirmation message as : THANK YOU FOR YOUR ORDER",
  "matchedColumns": [
    8
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "standard_user",
      "offset": 26
    }
  ],
  "location": "StepDefinitions.verifyUserEntersUsername(String)"
});
formatter.result({
  "duration": 1085102753,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "secret_sauce",
      "offset": 23
    }
  ],
  "location": "StepDefinitions.verifyUserEntersPassword(String)"
});
formatter.result({
  "duration": 446293595,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.clickOnButton()"
});
formatter.result({
  "duration": 546180863,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Products",
      "offset": 39
    }
  ],
  "location": "StepDefinitions.verifySwagLabsPageTitle(String)"
});
formatter.result({
  "duration": 708632038,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Price (high to low)",
      "offset": 24
    }
  ],
  "location": "StepDefinitions.filterOutItemsOnProductPage(String)"
});
formatter.result({
  "duration": 201294276,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Price (high to low)",
      "offset": 40
    }
  ],
  "location": "StepDefinitions.userVerifiesItemsAreSorted(String)"
});
formatter.result({
  "duration": 408204199,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.userAddHighAndLowItemsToCart()"
});
formatter.result({
  "duration": 520055769,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 49
    }
  ],
  "location": "StepDefinitions.userClickonCheckoutBtn(String)"
});
formatter.result({
  "duration": 197174231,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 73
    }
  ],
  "location": "StepDefinitions.userVerifyCheckoutPageItemAndProceed(String)"
});
formatter.result({
  "duration": 236685822,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cfirstname\u003e",
      "offset": 13
    },
    {
      "val": "TestSecondName",
      "offset": 25
    },
    {
      "val": "E16",
      "offset": 40
    }
  ],
  "location": "StepDefinitions.enterUserInformation(String,String,String)"
});
formatter.result({
  "duration": 943825747,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.userClicksOnFinishBtn()"
});
formatter.result({
  "duration": 212905723,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "THANK YOU FOR YOUR ORDER",
      "offset": 49
    }
  ],
  "location": "StepDefinitions.userVerifiesCompleteMessage(String)"
});
formatter.result({
  "duration": 90027689,
  "status": "passed"
});
formatter.after({
  "duration": 182715926,
  "status": "passed"
});
});