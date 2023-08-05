package Pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductPage extends PageBase {

	public AddProductPage(WebDriver driver) {
		super(driver);
	}

	private By nextStepBtn = By.xpath("(//button[contains(text(),'Next Step')])[1]");
	private By auctionBtn = By.xpath("//input[@placeholder='Auction Name' and @name='title']");
	private By mainClassificationBtn = By.xpath("//input[@placeholder='select category']");
	private By childClassificationBtn = By.xpath("//input[@placeholder='select subcategory']");
	private By mountTb = By.xpath("//input[@placeholder='Quantity']");
	private By productPlaceTb = By.name("address");
	private By countryDDL = By.xpath("//input[@aria-controls='vs5__listbox']");
	private By areaDDl = By.xpath("//input[@aria-controls='vs6__listbox']");
	private By cityDDL = By.xpath("//input[@aria-controls='vs7__listbox']");
	WebElement iFrame = driver.findElement(By.id("tinymce_description_ifr"));
	private By descriptionTB = By.xpath("//body[@id = 'tinymce' and @data-id = 'tinymce_description']//p");
	private By secondNextStepBtn = By.xpath("//*[@id='step-2']/span/div[2]/div[13]/div/button[2]");
	private By imageBtn = By.xpath("(//a[text() = 'or click'])[1]");

	public AddProductPage setAddProductData_secondStep(String auctionName, String mainClass, String childClass,
			String mount, String productPlace, String country, String area, String city, String descriptionText)
			throws InterruptedException, AWTException {
		click(nextStepBtn);
		type(auctionBtn, auctionName);
		type(mainClassificationBtn, mainClass);
		driver.findElement(mainClassificationBtn).sendKeys(Keys.ENTER);
		type(childClassificationBtn, childClass);
		driver.findElement(childClassificationBtn).sendKeys(Keys.ENTER);
		type(mountTb, mount);
		type(productPlaceTb, productPlace);
		type(countryDDL, country);
		driver.findElement(countryDDL).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		type(areaDDl, area);
		driver.findElement(areaDDl).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		type(cityDDL, city);
		driver.findElement(cityDDL).sendKeys(Keys.ENTER);
		driver.switchTo().frame("tinymce_description_ifr");
		driver.findElement(By.xpath("//body[@id = 'tinymce' and @data-id = 'tinymce_description']//p")).click();
		driver.findElement(By.xpath("//body[@id = 'tinymce' and @data-id = 'tinymce_description']//p"))
				.sendKeys(descriptionText);

		return this;
	}

	public AddProductPage uploadPic() {
//		String picPath = System.getProperty("user.dir") + "\\images\\1.svg";
		click(imageBtn);
		driver.findElement(imageBtn).sendKeys("C:\\Users\\12016\\eclipse-workspace\\mazaady\\images\\1.svg");
		driver.findElement(imageBtn).submit();
		click(secondNextStepBtn);
		return this;
	}

	// C:\Users\12016\eclipse-workspace\mazaady\images\1.svg

}
