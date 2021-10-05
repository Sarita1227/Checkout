@Checkout 
Feature: Online Shopping checkout feature 

Scenario Outline: User place order from the page succesfully 
	Given user enters Username as : <userName> 
	Then user enters Password : <password> 
	When user click on login button 
	Then application homepage is displayed as : <title> 
	When user select filter as : <sortFilter> 
	Then user verifies the items are sorted by : <sortFilter> 
	Then user add high and low item to the cart 
	When user clicks on checkout button with cart value : <cartValue> 
	Then user verify checkout page and click on checkout button with cart value : <cartValue> 
	When user enter : <firstname> <lastName> <postal> and proceed 
	Then user clicks on finish button 
	And user verifies checkout confirmation message as : <checkoutMsg>
	
	Examples: 
		| userName 		| password 		| title    |sortFilter       	 | cartValue | firstName     |   lastName     | postal | checkoutMsg |
		| standard_user | secret_sauce  | Products |Price (high to low)  | 2 		 | TestFirstName | TestSecondName | E16    | THANK YOU FOR YOUR ORDER |
		
		
	