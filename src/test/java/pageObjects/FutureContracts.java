package pageObjects;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import hooks.Hooks;
import pageLocators.ActiveFutureContractsPageLocators;

public class FutureContracts {
	public static WebDriver driver;
	public static TreeSet<String> tset=new TreeSet<String>();
	public static LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();

	public static void mostActiveFutureContractUrl() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(ActiveFutureContractsPageLocators.mostActiveFutureContractsUrl);
	}

	public static void dataOfMostActiveFutureContract() throws InterruptedException {
		String red = "\u001B[31m";
		String reset = "\u001B[0m";
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.findElement(ActiveFutureContractsPageLocators.btnMostActiveFutureContracts).click();
			
			System.out.println("[MYLOG]"+" :  "+
					red + "************************[   MOST ACTIVE FUTURE CONTRACTS   ]*********************" + reset);
			
			List<WebElement> rowsElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
					"//table[@id='MACEquityTable']//tbody//following::tr//td[text()='Stock Futures']//parent::tr")));

			List<WebElement> rFuturesData = driver.findElements(By
					.xpath("//table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Futures']//parent::tr//td[2]"));
			
			for(WebElement data1:rFuturesData) {
				linkedHashSet.add(data1.getText());
			}
			for (String stockData :  linkedHashSet) {
				System.out.println("[MYLOG]"+" :  "+stockData);
				TestDataStorage.addData(stockData);
			}
			

			boolean stockFuturesFound = false;
			for (int j = 0; j < rowsElement.size(); j++) {
				if (rowsElement.get(j).getText().contains("Stock Futures")) {
					stockFuturesFound = true;
					break;
				}
			}

			System.out.println("[MYLOG]"+" :  "+
					red + "************************[   MOST ACTIVE FUTURE CONTRACTS   ]*********************" + reset);
			Assert.assertTrue(stockFuturesFound);

		} finally {
			Thread.sleep(3000);
			driver.quit();

		}

	}
	
}
