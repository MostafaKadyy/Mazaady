package Tests;

import org.testng.annotations.Test;

import Pages.loginPage;

public class LoginTest extends TestBase {

	@Test
	public void loginWithValidData() {
		(new loginPage(driver)).setLoginData("tester@task.com", "11111111").naviToHomepage();

	}
}
