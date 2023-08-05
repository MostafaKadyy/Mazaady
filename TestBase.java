package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	// **it will be run once before suite**
	@BeforeTest
	public void startDriver() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.navigate().to("https://staging.mazaady.com/login");
	}

	// **it will be run after suite**
	@AfterTest
	public void stopDriver() {
		// driver.quit();
	}
}
