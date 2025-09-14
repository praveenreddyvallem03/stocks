// package pageObjects;

// import java.time.Duration;
// import java.util.LinkedHashMap;
// import java.util.LinkedHashSet;
// import java.util.List;
// import java.util.NoSuchElementException;
// import java.util.TreeMap;
// import java.util.TreeSet;

// import org.openqa.selenium.By;
// import org.openqa.selenium.StaleElementReferenceException;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.firefox.FirefoxOptions;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.Select;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;
// import org.testng.annotations.Test;

// import hooks.Hooks;
// import pageLocators.ActiveFutureContractsPageLocators;

// public class FutureContracts {
// 	public static WebDriver driver;
// 	public static TreeSet<String> tset=new TreeSet<String>();
// 	public static LinkedHashSet<String> linkedHashSet=new LinkedHashSet<String>();

// 	public static void mostActiveFutureContractUrl() {
// 		FirefoxOptions options = new FirefoxOptions();
// 		options.addArguments("--headless");
// 		driver = new FirefoxDriver(options);
// 		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
// 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// 		driver.manage().window().maximize();
// 		driver.get(ActiveFutureContractsPageLocators.mostActiveFutureContractsUrl);
// 	}

// 	public static void dataOfMostActiveFutureContract() throws InterruptedException {
// 		String red = "\u001B[31m";
// 		String reset = "\u001B[0m";
// 		try {
// 			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
// 			driver.findElement(ActiveFutureContractsPageLocators.btnMostActiveFutureContracts).click();
			
// 			System.out.println("[MYLOG]"+" :  "+
// 					red + "************************[   MOST ACTIVE FUTURE CONTRACTS   ]*********************" + reset);
			
// 			List<WebElement> rowsElement = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
// 					"//table[@id='MACEquityTable']//tbody//following::tr//td[text()='Stock Futures']//parent::tr")));

// 			List<WebElement> rFuturesData = driver.findElements(By
// 					.xpath("//table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Futures']//parent::tr//td[2]"));
			
// 			for(WebElement data1:rFuturesData) {
// 				linkedHashSet.add(data1.getText());
// 			}
// 			for (String stockData :  linkedHashSet) {
// 				System.out.println("[MYLOG]"+" :  "+stockData);
// 				TestDataStorage.addData(stockData);
// 			}
			

// 			boolean stockFuturesFound = false;
// 			for (int j = 0; j < rowsElement.size(); j++) {
// 				if (rowsElement.get(j).getText().contains("Stock Futures")) {
// 					stockFuturesFound = true;
// 					break;
// 				}
// 			}

// 			System.out.println("[MYLOG]"+" :  "+
// 					red + "************************[   MOST ACTIVE FUTURE CONTRACTS   ]*********************" + reset);
// 			Assert.assertTrue(stockFuturesFound);

// 		} finally {
// 			Thread.sleep(3000);
// 			driver.quit();

// 		}

// 	}
	
// }
package pageObjects;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageLocators.ActiveFutureContractsPageLocators;

public class FutureContracts {
    public static WebDriver driver;
    public static TreeSet<String> tset = new TreeSet<>();
    public static LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

    // ✅ Open with Chrome Headless (better than Firefox in GitHub Actions)
    public static void mostActiveFutureContractUrl() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(ActiveFutureContractsPageLocators.mostActiveFutureContractsUrl);
    }

    public static void dataOfMostActiveFutureContract() throws InterruptedException {
        String red = "\u001B[31m";
        String reset = "\u001B[0m";

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // ✅ Wait for the dropdown/button to be clickable
            WebElement dropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(ActiveFutureContractsPageLocators.btnMostActiveFutureContracts)
            );
            dropdown.click();

            // ✅ Wait for option inside dropdown
            WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//option[contains(text(),'Most Active Future Contracts')]")
            ));
            option.click();

            System.out.println("[MYLOG] : " + red + "************************[   MOST ACTIVE FUTURE CONTRACTS   ]*********************" + reset);

            List<WebElement> rowsElement = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.xpath("//table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Futures']//parent::tr")
                    )
            );

            List<WebElement> rFuturesData = driver.findElements(
                    By.xpath("//table[@id='MACEquityTable']//tbody//tr//td[text()='Stock Futures']//parent::tr//td[2]")
            );

            for (WebElement data1 : rFuturesData) {
                linkedHashSet.add(data1.getText());
            }

            for (String stockData : linkedHashSet) {
                System.out.println("[MYLOG] : " + stockData);
                TestDataStorage.addData(stockData);
            }

            boolean stockFuturesFound = rowsElement.stream()
                    .anyMatch(row -> row.getText().contains("Stock Futures"));

            System.out.println("[MYLOG] : " + red + "************************[   MOST ACTIVE FUTURE CONTRACTS   ]*********************" + reset);
            Assert.assertTrue(stockFuturesFound, "Stock Futures not found in table!");

        } catch (Exception e) {
            // ✅ Debug help: print page source in CI
            System.out.println("[MYLOG][ERROR] Element not found. Printing page source for debugging...");
            System.out.println(driver.getPageSource());
            throw e;
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }
}
