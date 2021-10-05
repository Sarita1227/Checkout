package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import stepDefinitions.Hooks;

public class HomePage extends Hooks {

	public HomePage() throws IOException {
		super();
	}

	public static Logger log = Logger.getLogger(String.valueOf(HomePage.class));

	@FindBy(how = How.ID, using = "user-name")
	public static WebElement userNameEle;

	@FindBy(how = How.CSS, using = "input#password")
	public static WebElement psswdEle;

	@FindBy(how = How.CSS, using = "input#login-button")
	public static WebElement loginBtn;

	@FindBy(how = How.CSS, using = "span.title")
	public static WebElement pageTitle;

	@FindBy(how = How.CLASS_NAME, using = "product_sort_container")
	public static WebElement filterSort;

	@FindAll({ @FindBy(how = How.CSS, using = "div.inventory_list>div.inventory_item") })
	public static List<WebElement> productList;

	String itemName = "(//div[@class='inventory_item_name'])[1]";
	String itemPrice = "(//div[@class='inventory_item_price'])[1]";
	String addToCart = "(//button[contains(@class,'btn_inventory')])[1]";

	@FindBy(how = How.CSS, using = "a.shopping_cart_link")
	public static WebElement checkoutCart;

	@FindAll({ @FindBy(how = How.CSS, using = "div.cart_item") })
	public static List<WebElement> checkoutList;

	@FindBy(how = How.CSS, using = "button#checkout")
	public static WebElement checkoutBtn;

	@FindBy(how = How.CSS, using = "input#first-name")
	public static WebElement firstName;

	@FindBy(how = How.CSS, using = "input#last-name")
	public static WebElement lastName;

	@FindBy(how = How.CSS, using = "input#postal-code")
	public static WebElement postCode;

	@FindBy(how = How.CSS, using = "input#continue")
	public static WebElement continueBtn;
	
	@FindBy(how = How.CSS, using = "button#finish")
	public static WebElement finishBtn;
	
	@FindBy(how = How.CSS, using = "h2.complete-header")
	public static WebElement completeMessage;

	
	
	
	
	/**
	 * User enters valid username
	 * 
	 * @param inputData
	 */
	public void verifyUserEntersUsername(String inputData) {
		log.info("User enters valid username");
		enterTextFieldValue(userNameEle, inputData);

	}

	/**
	 * User enters valid password
	 * 
	 * @param inputData
	 */
	public void verifyUserEntersPassword(String inputData) {
		log.info("User enters valid password");
		enterTextFieldValue(psswdEle, inputData);

	}

	/**
	 * Click on the login button
	 */
	public void clickOnLoginBtn() {
		log.info("User clicks on login button");
		clickOnButton(loginBtn);
	}

	/**
	 * Verify SwagLabs page title
	 * 
	 * @param inputData
	 */
	public void verifySwagLabsPageTitle(String inputData) {
		log.info("verify page title on login");
		verifyExpectedText(pageTitle, inputData);

	}

	/**
	 * Filter out items on product page
	 * 
	 * @param filterValue
	 */
	public void filterOutItemsOnProductPage(String filterValue) {
		log.info("click on the filter button to sort item by " + filterValue);
		selectDropdownByText(filterSort, filterValue);

	}

	/**
	 * Verify if items are sorted
	 * 
	 * @param filterValue
	 */
	public void verifyProductItemsAreSorted(String filterValue) {
		boolean returnValue = false;
		log.info("Verify product items are sorted as per the filter selected");
		try {
			String sortType = filterValue.substring(filterValue.indexOf("(") + 1,
					StringUtils.ordinalIndexOf(filterValue, " ", 2));

			returnValue = !productList.isEmpty();
			List<String> itemNames = new ArrayList<String>();
			List<String> sortedList = new ArrayList<String>();
			List<Float> intList = new ArrayList<Float>();
			List<Float> sortedIntList = new ArrayList<Float>();

			switch (sortType) {

			case "A":
				log.info("Verify items sorted if the filter type selected is Price(A to Z)");
				itemNames = checkList(itemName);
				for (String s : itemNames) {
					sortedList.add(s);
				}
				Collections.sort(itemNames);
				returnValue &= itemNames.equals(sortedList);
				break;
			case "Z":
				log.info("Verify items sorted if the filter type selected is Price(Z to A)");
				itemNames = checkList(itemName);
				for (String s : itemNames) {
					sortedList.add(s);
				}
				Collections.sort(itemNames, Collections.reverseOrder());
				returnValue &= itemNames.equals(sortedList);
				break;
			case "high":
				log.info("Verify items sorted if the filter type selected is Price(High to Low)");
				itemNames = checkList(itemPrice);
				for (String s : itemNames) {
					intList.add(Float.valueOf(s));
				}
				for (Float s1 : intList) {
					sortedIntList.add(s1);
				}
				Collections.sort(intList, Collections.reverseOrder());
				returnValue &= intList.equals(sortedIntList);
				break;
			case "low":
				log.info("Verify items sorted if the filter type selected is Price(Low to High)");
				itemNames = checkList(itemPrice);
				for (String s : itemNames) {
					intList.add(Float.valueOf(s));
				}
				for (Float s1 : intList) {
					sortedIntList.add(s1);
				}
				Collections.sort(intList);
				returnValue &= intList.equals(sortedIntList);
				break;

			}
			Assert.assertTrue(returnValue);
		} catch (Exception e) {
			log.warning("An error occured" + e);
			Assert.fail();
		}
	}

	public List<String> checkList(String itemEle) {
		List<String> itemsAdded = new ArrayList<String>();
		for (int i = 1; i < productList.size(); i++) {
			String name = driver.findElement(By.xpath(itemEle.replace("1", "" + i + ""))).getText().replace("$", "")
					.trim();
			itemsAdded.add(name);

		}
		return itemsAdded;
	}

	/**
	 * Add items to cart
	 */
	public void userAddsItemsToCart() {
		boolean returnValue = false;
		try {
			log.info("User add the high and low price item to the cart");
			returnValue = !productList.isEmpty();
			for (int i = 1; i <= productList.size(); i++) {
				WebElement itemBtn = driver.findElement(By.xpath(addToCart.replace("1", "" + i + "")));

				if (i == 1 || i == productList.size()) {
					itemBtn.click();
					itemBtn = driver.findElement(By.xpath(addToCart.replace("1", "" + i + "")));
					returnValue &= itemBtn.getText().equalsIgnoreCase("Remove");
				}
			}
			Assert.assertTrue(returnValue);
		} catch (Exception e) {
			log.warning("An error occured" + e);
			Assert.fail();
		}
	}

	/**
	 * User clicks on checkout button
	 * 
	 * @param itemNumber
	 */
	public void userClickCheckoutButton(String itemNumber) {
		boolean returnValue = false;
		try {
			log.info("Verify total items on cart ");
			returnValue = checkoutCart.isDisplayed();
			returnValue &= checkoutCart.getText().equalsIgnoreCase(itemNumber);
			if (returnValue) {
				log.info("User click on checkout button");
				checkoutCart.click();
			}
			Assert.assertTrue(returnValue);

		} catch (Exception e) {
			log.warning("An error occured" + e);
			Assert.fail();
		}

	}

	/**
	 * User confirms item on checkout item
	 * 
	 * @param itemNumber
	 */
	public void userConfirmItemsOnCheckoutItem(String itemNumber) {
		boolean returnValue = false;
		try {
			log.info("Verify proper items added and click on checkout button");
			returnValue = checkoutList.size() == Integer.parseInt(itemNumber);
			returnValue &= checkoutBtn.isDisplayed() && checkoutBtn.isEnabled();
			if (returnValue) {
				checkoutBtn.click();
			}
			Assert.assertTrue(returnValue);
		} catch (Exception e) {
			log.warning("An error occured" + e);
			Assert.fail();
		}
	}

	/**
	 * User enter information
	 * 
	 * @param fName
	 * @param lName
	 * @param postCode
	 */
	public void enterUserInformationAndProceed(String fName, String lName, String postal) {
		boolean returnValue = false;
		try {
			log.info("Verify all fields are enabled and displayed");
			returnValue = firstName.isDisplayed() && firstName.isEnabled();
			returnValue &= lastName.isDisplayed() && lastName.isEnabled();
			returnValue &= postCode.isDisplayed() && postCode.isEnabled();
			returnValue &= continueBtn.isEnabled();
			if (returnValue) {
				log.info("Enter user information");
				firstName.sendKeys(fName);
				lastName.sendKeys(lName);
				postCode.sendKeys(postal);
				continueBtn.click();
			}
			Assert.assertTrue(returnValue);
		} catch (Exception e) {
			log.warning("An error occured" + e);
			Assert.fail();
		}

	}
	
	/**
	 * User clicks on finish btn
	 */
	public void userClicksOnFinishBtn() {
		log.info("User clicks on finish button");
		clickOnButton(finishBtn);
	}
	
	/**
	 * Verify complete page message
	 * 
	 * @param inputData
	 */
	public void verifyCompletePageMessage(String message) {
		log.info("verify complete page message");
		verifyExpectedText(completeMessage, message);
	}
}
