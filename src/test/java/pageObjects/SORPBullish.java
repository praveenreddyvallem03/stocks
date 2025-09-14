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
import pageLocators.SORPPageLOcators;

public class SORPBullish {
	public static WebDriver driver;
	public static LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();

	public static void urlOfShortCoveringStocks() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); 
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(SORPPageLOcators.SlideInOiRiseInPicePath);
	}

	public static void SlideOIRisePrice() throws InterruptedException {
		
		String red = "\u001B[31m";
        String reset = "\u001B[0m";
		try {
			WebDriverWait wait=new WebDriverWait (driver,Duration.ofSeconds(10));
			driver.findElement(SORPPageLOcators.shortCoveringPath).click();

			System.out.println("[MYLOG]"+" :  "+
					red+"********************[  SLIDE In OI RISE In PRICE  (BULLISH) ]*****************"+reset);
            
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

			
			List<WebElement> SORPData = driver.findElements(
					By.xpath("//table[@id='oiSpurtsTable']//tbody//tr"));
			boolean SlideInOiStatus = false;
			for (int i = 0; i < SORPData.size(); i++) {
				if (SORPData.get(i).getText().contains("Stock Futures") || SORPData.get(i).getText().contains("Stock Options") ) {
					SlideInOiStatus = true;
					break;
				}
			}

			System.out.println("[MYLOG]"+" :  "+
					red+"********************[  SLIDE In OI RISE In PRICE  (BULLISH) ]*****************"+reset);
			org.testng.Assert.assertTrue(SlideInOiStatus);
		} finally {
			driver.quit();

		}
	}
}
