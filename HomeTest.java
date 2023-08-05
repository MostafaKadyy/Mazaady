package Tests;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.loginPage;

public class HomeTest extends TestBase {
	@Test
	public void navigateToAddProductPage() {
		(new loginPage(driver)).setLoginData("tester@task.com", "11111111").naviToHomepage();
		(new HomePage(driver)).SetArLanguage().naviToAddProductPage();
	}
}
