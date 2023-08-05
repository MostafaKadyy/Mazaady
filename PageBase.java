package Pages;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	public static WebDriver driver;

	// **Create parametarized Constructor with (WebDriver driver) to avoid repeating
	// instalizing driver in the objects
	// All pages in pages should inherit from PageBase **
	public PageBase(WebDriver driver) {
		PageBase.driver = driver;
	}

	// ** explicit wait till element be visible**//
	public static void explicitWaitToBeVisible(By elementlocator) {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOfElementLocated(elementlocator));
	}

	// ** explicit wait till element be clickable**//
	public static void explicitWaitToBeClickable(By elementlocator) {
		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(elementlocator));
	}

	// presteps for locating element before doing action on it
	private static void locatingElementStratgy(By elementLocator) {
		try {
			// Wait for the element to be visible
			explicitWaitToBeVisible(elementLocator);
			// Scroll the element into view to handle some browsers cases
//			((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(false);",
//					driver.findElement(elementLocator));
			// Check if the element is displayed
			if (!driver.findElement(elementLocator).isDisplayed()) {
				System.out.println("The element [" + elementLocator.toString() + "] is not Displayed");
				fail("the element [" + elementLocator.toString() + "] is not displayed");
			}
		} catch (TimeoutException toe) {
			System.out.println((toe.getMessage()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	// ** type method**//
	public static void type(By elementLocator, String text) {
		// Clear before typing condition
		try {
			explicitWaitToBeVisible(elementLocator);
			if (!driver.findElement(elementLocator).getAttribute("value").isEmpty()) {
				driver.findElement(elementLocator).clear();
				// We type here!
				driver.findElement(elementLocator).sendKeys(text);
				// Type using JavascriptExecutor in case of the data is not typed successfully
				// using the Selenium sendKeys method
				if (!driver.findElement(elementLocator).getAttribute("value").equals(text)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + text + "')",
							driver.findElement(elementLocator));
				}
			} else {
				// We type here! :D
				driver.findElement(elementLocator).sendKeys(text);
				// Type using JavascriptExecutor in case of the data is not typed successfully
				// using the Selenium sendKeys method
				if (!driver.findElement(elementLocator).getAttribute("value").contains(text)) {
					String currentValue = driver.findElement(elementLocator).getAttribute("value");
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].setAttribute('value', '" + currentValue + text + "')",
							driver.findElement(elementLocator));
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
		// Make sure that the data is inserted correctly to the field
//		Assert.assertTrue(driver.findElement(elementLocator).getAttribute("value").contains(text),
//				"The data is not inserted successfully to the field, the inserted data should be: [" + text
//						+ "]; But the current field value is: ["
//						+ driver.findElement(elementLocator).getAttribute("value") + "]");
	}

	// ** click method**//
	public static void click(By elementLocator) {
		locatingElementStratgy(elementLocator);
		try {
			// wait for the element to be clickable
			explicitWaitToBeClickable(elementLocator);
		} catch (TimeoutException toe) {
			System.out.println(toe.getMessage());
			fail(toe.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
		// * Mouse hover on the element before clicking to enable styling and handle
		// some
		// *element clicking issues that happens without hovering

		try {
			new Actions(driver).moveToElement(driver.findElement(elementLocator)).perform();
			driver.findElement(elementLocator).click();
		} catch (Exception exception) {
			/*
			 * Click using JavascriptExecutor in case of the click is not performed
			 * successfully and got an exception using the Selenium click method
			 */
			try {
				((JavascriptExecutor) driver).executeScript("arguments[arguments.length - 1].click();",
						driver.findElement(elementLocator));
			} catch (Exception rootCauseExceptlion) {
				rootCauseExceptlion.initCause(exception);
				System.out.println(exception.getMessage());
				System.out.println(rootCauseExceptlion.getMessage());
				fail("couldnot click on the element:" + elementLocator, rootCauseExceptlion);
			}
		}
	}

}
