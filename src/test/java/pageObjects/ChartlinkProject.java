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

public class ChartlinkProject {
	public static WebDriver driver;

	public static void stocksActivechartlinkurl() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://chartink.com/");
	}

	public static void Chartlinkdata() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//a[text()='Atlas']//parent::div//following-sibling::div/a[text()='Sign in']")).click();
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("prvnreddyvallem@gmail.com");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Prave@3202");
			driver.findElement(By.xpath("//span[text()='Log in']")).click();
			driver.findElement(By.xpath("//a[text()='Momentum Futures']")).click();
			
			System.out.println("[MYLOG]"+" :  "+"****************** CHARTLINK MOMENTUM STOCKS ************************** ");

			WebElement run = driver.findElement(By.xpath("//span[text()='Run Scan']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(run).click().perform();
			Thread.sleep(2000);
			List<WebElement> data = driver.findElements(
					By.xpath("//table[@class='rounded-b-[7px] min-w-max lg:w-full whitespace-nowrap']//tbody//tr/td[position()=3 or position()=5]"));
			for (WebElement stockdata : data) {
				System.out.println("[MYLOG]"+" :  "+ stockdata.getText());
			}
			System.out.println("[MYLOG]"+" :  "+"****************** CHARTLINK MOMENTUM STOCKS ************************** ");
		} finally {
			driver.close();
		}

	}
}
