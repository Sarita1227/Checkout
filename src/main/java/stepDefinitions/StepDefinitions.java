package stepDefinitions;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;

public class StepDefinitions {

	private HomePage page = PageFactory.initElements(HomePage.driver, HomePage.class);

	@Given("^user enters Username as : (.*)$")
	public void verifyUserEntersUsername(String userName) {
		page.verifyUserEntersUsername(userName);
	}

	@Then("^user enters Password : (.*)$")
	public void verifyUserEntersPassword(String password) {
		page.verifyUserEntersPassword(password);
	}

	@When("^user click on login button$")
	public void clickOnButton() {
		page.clickOnLoginBtn();

	}
	
	@Then("^application homepage is displayed as : (.*)$")
	public void verifySwagLabsPageTitle(String title) {
		page.verifySwagLabsPageTitle(title);

	}

	@When("^user select filter as : (.*)$")
	public void filterOutItemsOnProductPage(String filterName) {
		page.filterOutItemsOnProductPage(filterName);
	}
	
	@Then("^user verifies the items are sorted by : (.*)$")
	public void userVerifiesItemsAreSorted(String filterName) {
		page.verifyProductItemsAreSorted(filterName);

	}
	
	@Then("^user add high and low item to the cart$")
	public void userAddHighAndLowItemsToCart() {
		page.userAddsItemsToCart();
	}
	
	@When("^user clicks on checkout button with cart value : (.*)$")
	public void userClickonCheckoutBtn(String cartValue) {
		page.userClickCheckoutButton(cartValue);
	}
	
	@Then("^user verify checkout page and click on checkout button with cart value : (.*)$")
	public void userVerifyCheckoutPageItemAndProceed(String cartValue) {
		page.userConfirmItemsOnCheckoutItem(cartValue);
	}
	
	@When("^user enter : (.*) (.*) (.*) and proceed$")
	public void enterUserInformation(String firstName, String lastName, String postal) {
		page.enterUserInformationAndProceed(firstName, lastName, postal);
		
	}
	
	@Then("^user clicks on finish button$")
	public void userClicksOnFinishBtn() {
		page.userClicksOnFinishBtn();
	}
	
	@And("^user verifies checkout confirmation message as : (.*)$")
	public void userVerifiesCompleteMessage(String message) {
		page.verifyCompletePageMessage(message);
	}
	
}