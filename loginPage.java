package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends PageBase {

	// *********Constructor*********
	public loginPage(WebDriver driver) {
		super(driver);
	}

	// *********Web Elements*********
	private By emailTxtBx = By.id("email");
	private By passwordtxtBx = By.id("password");
	private By loginBtn = By.xpath("//*[@type='submit' and @class='btn btn-lg btn-login btn-block']");

	// *********Page Methods*********
	// *********set data*********
	// *********set data*********
	public loginPage setLoginData(String mail, String password) {
		// *********set email*********
		type(emailTxtBx, mail);
		// *********set password*********
		type(passwordtxtBx, password);
		return this;
	}

	public HomePage naviToHomepage() {
		click(loginBtn);
		return new HomePage(driver);
	}

}
