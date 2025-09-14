package pageObjects;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageLocators.StocksPutsPageLocators;

public class StocksPuts {
	public static WebDriver driver;
	public static LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();

	public static void urlOfMostActiveStocksPuts() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); 
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(StocksPutsPageLocators.mostActiveStocksPutUrl);
	}

	public static void mostActiveStocksPutData() throws InterruptedException {
		String red = "\u001B[31m";
        String reset = "\u001B[0m";
		try {
			WebDriverWait wait=new WebDriverWait (driver,Duration.ofSeconds(10));
			driver.findElement(StocksPutsPageLocators.btnOfMostActiveStocks).click();
			System.out
					.println("[MYLOG]"+" :  "+red+"******************[  MOST ACTIVE STOCKS PUTS  ]********************"+reset);
			

			List<WebElement> rowsElement1 = wait.until(
				    ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Options']//parent::tr | //table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Futures']//parent::tr")));
			for (int i = 0; i < rowsElement1.size(); i++) {
				WebElement cell = driver.findElement(By
						.xpath(" //table[@id='MACEquityTable']//tbody//tr[" + (i + 1) + "]//td[2]"));
				linkedHashSet.add(cell.getText());
			}
			
			for (String stockData :  linkedHashSet) {
				System.out.println("[MYLOG]"+" :  " + stockData );
				TestDataStorage.addData(stockData);
			}
			
			boolean stocksPut = false;
			for (int j = 0; j < rowsElement1.size(); j++) {
				if (rowsElement1.get(j).getText().contains("Stock Options")) {
					stocksPut = true;
					break;
				}
			}
			System.out
					.println("[MYLOG]"+" :  "+red+"******************[  MOST ACTIVE STOCKS PUTS  ]********************"+reset);
			Assert.assertTrue(stocksPut);
		} finally {
			driver.quit();
		}

	}
}
