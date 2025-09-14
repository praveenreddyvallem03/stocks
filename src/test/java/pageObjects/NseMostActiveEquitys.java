package pageObjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageLocators.ActiveFutureContractsPageLocators;

public class NseMostActiveEquitys {

	public static WebDriver driver;
	@Test

	public static void stocksActivechartlinkurl() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.nseindia.com/market-data/most-active-equities");

//			driver.findElement(By.xpath("//div[@id='mae_mainboard']//following-sibling::div/div/div/div/following-sibling::div/div/label[@id='volume_s']")).click();
	    	List<WebElement> equitiesData=	driver.findElements(By.xpath("//table[@id='mae_mainboard_tableC']//tbody/tr"));
			
			System.out.println("[MYLOG]"+" :  "+"******************  MOST ACTIVE EQUITY STOCKS ************************** ");
			Thread.sleep(3000);

			for (WebElement stockdata : equitiesData) {
				Thread.sleep(2000);
				System.out.println("[MYLOG]"+" :  "+ stockdata.getText());
			}
			System.out.println("[MYLOG]"+" :  "+"****************** MOST ACTIVE EQUITY STOCKS ************************** ");



	}
}
