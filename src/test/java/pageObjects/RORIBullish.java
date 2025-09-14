package pageObjects;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import junit.framework.Assert;
import pageLocators.RORPPageLocators;

public class RORIBullish {

	public static WebDriver driver;
	public static LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();

	public static void urlOfRiseInOIRiseInPrice() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(RORPPageLocators.riseInOiAndRiseInPricePath);
	}

	public static void riseInOiandRiseInPrice() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String red = "\u001B[31m";
		String reset = "\u001B[0m";
		try {
			driver.findElement(RORPPageLocators.clickRiseInOiRisePriceBtn).click();

			System.out.println("[MYLOG]"+" :  "+
					red + "********************[  RISE In OI ad RISE In PRICE (BULLISH) ]*****************" + reset);
			

			List<WebElement> StockOptionData = driver.findElements(By.xpath(
					"//table[@id='oiSpurtsTable']//tbody/tr//following::td[text()='Stock Futures']//parent::tr//td[1] |//table[@id='oiSpurtsTable']//tbody/tr//following::td[text()='Stock Options']//parent::tr//td[1] "));
			
			for(WebElement data1:StockOptionData) {
				linkedHashSet.add(data1.getText());
			}
			for (String stockData :  linkedHashSet) {
				System.out.println("[MYLOG]"+" :  "+stockData);
				TestDataStorage.addData(stockData);
			}
			//			for (WebElement sdata : StockOptionData) {
//				System.out.println("[MYLOG]"+" :  "+sdata.getText() + " ");
//			}

			List<WebElement> riseInOiRowData = wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='oiSpurtsTable']//tbody//tr")));

			boolean riseInOiStatus = false;
			for (int i = 0; i < riseInOiRowData.size(); i++) {
				if (riseInOiRowData.get(i).getText().contains("Stock Futures") || riseInOiRowData.get(i).getText().contains("Stock Options")) {
					riseInOiStatus = true;
					break;
				}
			}

			System.out.println("[MYLOG]"+" :  "+
					red + "********************[   RISE In OI ad RISE In PRICE (BULLISH) ]*****************" + reset);
			org.testng.Assert.assertTrue(riseInOiStatus);
		} finally {
			driver.quit();

		}
	}

}
