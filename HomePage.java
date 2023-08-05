package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
	// *********Constructor*********
	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By addProxductBtn = By
			.xpath("//*[@href='https://staging.mazaady.com/add-product' and @class='btn add-product-call-to-action']");

	private By DropDownLanguage = By
			.xpath("//img[@src = 'https://staging.mazaady.com/images/icons/header-icons/translation.svg'][1]");
	private By langaugeArabic = By.xpath("//li//a[@href = 'https://staging.mazaady.com/language/ar'][1]");

	public HomePage SetArLanguage() {
		click(DropDownLanguage);
		click(langaugeArabic);
		return this;
	}

	public HomePage naviToAddProductPage() {
		click(addProxductBtn);
		return this;
	}

}
