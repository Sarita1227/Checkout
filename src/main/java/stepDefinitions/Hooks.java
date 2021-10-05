package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.Utils;

public class Hooks {

    public static WebDriver driver;

    public static Logger log = Logger.getLogger(String.valueOf(Hooks.class));

    public String fs = File.separator;

    public static Properties configProperties;

    public static String browser;

    public Hooks() throws IOException {
        configProperties = Utils.readPropertiesFile();
        browser = configProperties.getProperty("browser");
    }

    /**
     * This will initialize the driver instance.
     */
    @Before
    public void openBrowser() {

        log.info("Test Started");

        if (getOS().contains("WINDOWS")) {

            switch (browser) {
                case "chrome":
                    String winChromeDriver = "Chromedriver" + fs + "chromedriver.exe";
                    String winChromePath = Paths.get(winChromeDriver).toAbsolutePath().toString();
                    System.setProperty("webdriver.chrome.driver", winChromePath);
                    driver = new ChromeDriver();
                    break;

            }
            initiateWebdriver();
        } else if (getOS().contains("MAC")) {

            switch (browser) {
                case "chrome":
                    String macChromeDriver = "Chromedriver" + fs + "chromedriver.exe";
                    String macChromePath = Paths.get(macChromeDriver).toAbsolutePath().toString();
                    System.setProperty("webdriver.chrome.driver", macChromePath);
                   
                    driver = new ChromeDriver();
                    break;

            }
            initiateWebdriver();
        }
    }

    /**
     * This will quit the driver instance
     */
    @After
    public void quitDriver() {
        driver.quit();
        log.info("Test Finished");

    }

    public static String getOS() {
        return System.getProperty("os.name").toUpperCase();
    }

    public static void initiateWebdriver() {
        log.info("Opening Browser...." + browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(configProperties.getProperty("url"));
        //driver.findElement(By.cssSelector("div.optanon-alert-box-corner-close")).click();
    }

	public void scrollToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/**
	 * Enter field value text
	 * @param element
	 * @param fieldValue
	 */
	public void enterTextFieldValue(WebElement element, String fieldValue) {
		boolean returnValue = false;
		try {
			returnValue = element.isDisplayed();
			if (returnValue) {
				element.sendKeys(fieldValue);
			}
			Assert.assertTrue(returnValue);
		} catch (Exception e) {
			log.warning("An error occured" + e);

		}
	}
	
	/**
	 * Click on button
	 * @param element
	 */
	public void clickOnButton(WebElement element) {
		boolean returnValue = false;
		try {
			returnValue = element.isEnabled();
			if(returnValue) {
				element.click();
			}
			Assert.assertTrue(returnValue);
			
		} catch (Exception e) {
			log.warning("An error occured" + e);

		}
	}
	
	/**
	 * Verify expected and actual text
	 * @param element
	 * @param expectedText
	 */
	public void verifyExpectedText(WebElement element, String expectedText) {
		boolean returnValue = false;
		try {
			returnValue = element.isDisplayed();
			if(returnValue) {
				returnValue = element.getText().equalsIgnoreCase(expectedText);
			}
			Assert.assertTrue(returnValue);
			
			
		} catch (Exception e) {
			log.warning("An error occured" + e);

		}
	}
	
	/**
	 * Select dropdown by value
	 * 
	 * @param dropdownEle
	 * @param value
	 */
	public void selectDropdownByText(WebElement dropdownEle, String value) {
		Select dropdown = new Select(dropdownEle);
		dropdown.selectByVisibleText(value);

	}
}