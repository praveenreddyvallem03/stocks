package pageObjects;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageLocators.StocksCallsPageLocators;

public class StocksCalls {
	public static WebDriver driver;
	public static LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();

	public static void enterUrlForMostActive() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(StocksCallsPageLocators.MostActieStocksCalls);
	}

	@Test
	public static void extarctStocksCallsData() throws InterruptedException {

		try {
			String red = "\u001B[31m";
	        String reset = "\u001B[0m";

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.findElement(By.xpath("//option[text()='Most Active Stocks Calls']")).click();
			System.out.println("[MYLOG]"+" :  "+red+"************************[  MOST ACTIVE STOCKS CALLS   ]*********************"+reset);
			
			List<WebElement> rowsElement2 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Options']//parent::tr | //table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Futures']//parent::tr")));
			for (int i = 0; i < rowsElement2.size(); i++) {
					WebElement cell = driver.findElement(By
							.xpath(" //table[@id='MACEquityTable']//tbody//tr[" + (i + 1) + "]//td[2]"));
					
					linkedHashSet.add(cell.getText());

				}
			for (String stockData :  linkedHashSet) {
				System.out.println("[MYLOG]"+" :  "+stockData);
				TestDataStorage.addData(stockData);
			}

			
			boolean verifyStocksCameorNot = true;
			for (int i = 0; i < rowsElement2.size(); i++) {
				verifyStocksCameorNot = rowsElement2.get(i).getText().contains("Stock Options");
				break;
			}
			System.out.println("[MYLOG]"+" :  "+red+"************************[  MOST ACTIVE STOCKS CALLS   ]*********************"+reset);
			Assert.assertEquals(verifyStocksCameorNot, true);
		} finally {
			driver.quit();
		}

	}

}
