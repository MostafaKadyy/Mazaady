package Tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Pages.AddProductPage;
import Pages.HomePage;
import Pages.loginPage;

public class AddProductTest extends TestBase {
	@Test
	public void addProduct() throws InterruptedException, AWTException {
		(new loginPage(driver)).setLoginData("tester@task.com", "11111111").naviToHomepage();
		(new HomePage(driver)).naviToAddProductPage();
		(new AddProductPage(driver)).setAddProductData_secondStep("elkady", "CARS , MOTORCYCLES & ACCESSORIES", "Cars",
				"10", "egypt", "Albania", "Berat", "Agim",
				"the task is longsdfsdfsdsdfsdfdsfdsfsdfsdfsdsdsdfsdfsdfsdfsdfdsssdfsdffwefwerfwerferferferferrefrferferferffeferfererferf");
	}

}
